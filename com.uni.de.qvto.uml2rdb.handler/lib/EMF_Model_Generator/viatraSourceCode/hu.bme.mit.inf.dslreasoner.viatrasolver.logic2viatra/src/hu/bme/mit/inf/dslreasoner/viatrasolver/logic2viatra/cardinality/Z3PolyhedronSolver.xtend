package hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.cardinality

import com.microsoft.z3.AlgebraicNum
import com.microsoft.z3.ArithExpr
import com.microsoft.z3.Context
import com.microsoft.z3.Expr
import com.microsoft.z3.IntNum
import com.microsoft.z3.Optimize
import com.microsoft.z3.RatNum
import com.microsoft.z3.Status
import com.microsoft.z3.Symbol
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

class Z3PolyhedronSolver implements PolyhedronSolver {
	val boolean lpRelaxation
	val double timeoutSeconds

	@FinalFieldsConstructor
	new() {
	}

	new() {
		this(false, -1)
	}

	override createSaturationOperator(Polyhedron polyhedron) {
		new DisposingZ3SaturationOperator(this, polyhedron)
	}

	def createPersistentSaturationOperator(Polyhedron polyhedron) {
		new Z3SaturationOperator(polyhedron, lpRelaxation, timeoutSeconds)
	}
}

@FinalFieldsConstructor
class DisposingZ3SaturationOperator implements PolyhedronSaturationOperator {
	val Z3PolyhedronSolver solver
	@Accessors val Polyhedron polyhedron

	override saturate() {
		val persistentOperator = solver.createPersistentSaturationOperator(polyhedron)
		try {
			persistentOperator.saturate
		} finally {
			persistentOperator.close
		}
	}

	override close() throws Exception {
		// Nothing to close.
	}
}

class Z3SaturationOperator extends AbstractPolyhedronSaturationOperator {
	static val INFINITY_SYMBOL_NAME = "oo"
	static val MULT_SYMBOL_NAME = "*"
	static val TIMEOUT_SYMBOL_NAME = "timeout"
	static val INTEGER_PRECISION = new BigDecimal(Integer.MAX_VALUE).precision
	static val ROUND_DOWN = new MathContext(INTEGER_PRECISION, RoundingMode.FLOOR)
	static val ROUND_UP = new MathContext(INTEGER_PRECISION, RoundingMode.CEILING)
	// The interval isolating the number is smaller than 1/10^precision. 
	static val ALGEBRAIC_NUMBER_ROUNDING = 0

	extension val Context context
	val Symbol infinitySymbol
	val Symbol multSymbol
	val Map<Dimension, ArithExpr> variables
	val int timeoutMilliseconds

	new(Polyhedron polyhedron, boolean lpRelaxation, double timeoutSeconds) {
		super(polyhedron)
		context = new Context
		infinitySymbol = context.mkSymbol(INFINITY_SYMBOL_NAME)
		multSymbol = context.mkSymbol(MULT_SYMBOL_NAME)
		variables = polyhedron.dimensions.toInvertedMap [ dimension |
			val name = dimension.name
			if (lpRelaxation) {
				mkRealConst(name)
			} else {
				mkIntConst(name)
			}
		]
		timeoutMilliseconds = Math.ceil(timeoutSeconds * 1000) as int
	}

	override doSaturate() {
		val status = executeSolver()
		convertStatusToSaturationResult(status)
	}

	private def convertStatusToSaturationResult(Status status) {
		switch (status) {
			case SATISFIABLE:
				PolyhedronSaturationResult.SATURATED
			case UNSATISFIABLE:
				PolyhedronSaturationResult.EMPTY
			case UNKNOWN:
				PolyhedronSaturationResult.UNKNOWN
			default:
				throw new IllegalArgumentException("Unknown Status: " + status)
		}
	}

	private def executeSolver() {
		for (expressionToSaturate : polyhedron.expressionsToSaturate) {
			val expr = expressionToSaturate.toExpr
			val lowerResult = saturateLowerBound(expr, expressionToSaturate)
			if (lowerResult != Status.SATISFIABLE) {
				return lowerResult
			}
			val upperResult = saturateUpperBound(expr, expressionToSaturate)
			if (upperResult != Status.SATISFIABLE) {
				return upperResult
			}
		}
		Status.SATISFIABLE
	}

	private def saturateLowerBound(ArithExpr expr, LinearBoundedExpression expressionToSaturate) {
		val optimize = prepareOptimize
		val handle = optimize.MkMinimize(expr)
		val status = optimize.Check()
		if (status == Status.SATISFIABLE) {
			val value = switch (resultExpr : handle.lower) {
				IntNum:
					resultExpr.getInt()
				RatNum:
					ceil(resultExpr)
				AlgebraicNum:
					ceil(resultExpr.toUpper(ALGEBRAIC_NUMBER_ROUNDING))
				default:
					if (isNegativeInfinity(resultExpr)) {
						null
					} else {
						throw new IllegalArgumentException("Integer result expected, got: " + resultExpr)
					}
			}
			expressionToSaturate.lowerBound = value
		}
		status
	}

	private def floor(RatNum ratNum) {
		val numerator = new BigDecimal(ratNum.numerator.bigInteger)
		val denominator = new BigDecimal(ratNum.denominator.bigInteger)
		numerator.divide(denominator, ROUND_DOWN).setScale(0, RoundingMode.FLOOR).intValue
	}

	private def saturateUpperBound(ArithExpr expr, LinearBoundedExpression expressionToSaturate) {
		val optimize = prepareOptimize
		val handle = optimize.MkMaximize(expr)
		val status = optimize.Check()
		if (status == Status.SATISFIABLE) {
			val value = switch (resultExpr : handle.upper) {
				IntNum:
					resultExpr.getInt()
				RatNum:
					floor(resultExpr)
				AlgebraicNum:
					floor(resultExpr.toLower(ALGEBRAIC_NUMBER_ROUNDING))
				default:
					if (isPositiveInfinity(resultExpr)) {
						null
					} else {
						throw new IllegalArgumentException("Integer result expected, got: " + resultExpr)
					}
			}
			expressionToSaturate.upperBound = value
		}
		status
	}

	private def ceil(RatNum ratNum) {
		val numerator = new BigDecimal(ratNum.numerator.bigInteger)
		val denominator = new BigDecimal(ratNum.denominator.bigInteger)
		numerator.divide(denominator, ROUND_UP).setScale(0, RoundingMode.CEILING).intValue
	}

	private def isPositiveInfinity(Expr expr) {
		expr.app && expr.getFuncDecl.name == infinitySymbol
	}

	private def isNegativeInfinity(Expr expr) {
		// Negative infinity is represented as (* (- 1) oo)
		if (!expr.app || expr.getFuncDecl.name != multSymbol || expr.numArgs != 2) {
			return false
		}
		isPositiveInfinity(expr.args.get(1))
	}

	private def prepareOptimize() {
		val optimize = mkOptimize()
		if (timeoutMilliseconds >= 0) {
			val params = mkParams()
			// We cannot turn TIMEOUT_SYMBOL_NAME into a Symbol in the constructor,
			// because there is no add(Symbol, int) overload.
			params.add(TIMEOUT_SYMBOL_NAME, timeoutMilliseconds)
			optimize.parameters = params
		}
		assertConstraints(optimize)
		optimize
	}

	private def assertConstraints(Optimize it) {
		for (pair : variables.entrySet) {
			assertBounds(pair.value, pair.key)
		}
		for (constraint : nonTrivialConstraints) {
			val expr = createLinearCombination(constraint.coefficients)
			assertBounds(expr, constraint)
		}
	}

	private def assertBounds(Optimize it, ArithExpr expression, LinearBoundedExpression bounds) {
		val lowerBound = bounds.lowerBound
		val upperBound = bounds.upperBound
		if (lowerBound == upperBound) {
			if (lowerBound === null) {
				return
			}
			Assert(mkEq(expression, mkInt(lowerBound)))
		} else {
			if (lowerBound !== null) {
				Assert(mkGe(expression, mkInt(lowerBound)))
			}
			if (upperBound !== null) {
				Assert(mkLe(expression, mkInt(upperBound)))
			}
		}
	}

	private def toExpr(LinearBoundedExpression linearBoundedExpression) {
		switch (linearBoundedExpression) {
			Dimension: variables.get(linearBoundedExpression)
			LinearConstraint: createLinearCombination(linearBoundedExpression.coefficients)
			default: throw new IllegalArgumentException("Unknown linear bounded expression:" + linearBoundedExpression)
		}
	}

	private def createLinearCombination(Map<Dimension, Integer> coefficients) {
		val size = coefficients.size
		if (size == 0) {
			return mkInt(0)
		}
		val array = newArrayOfSize(size)
		var int i = 0
		for (pair : coefficients.entrySet) {
			val variable = variables.get(pair.key)
			if (variable === null) {
				throw new IllegalArgumentException("Unknown dimension: " + pair.key.name)
			}
			val coefficient = pair.value
			val term = if (coefficient == 1) {
					variable
				} else {
					mkMul(mkInt(coefficient), variable)
				}
			array.set(i, term)
			i++
		}
		mkAdd(array)
	}

	override close() throws Exception {
		context.close()
	}
}
