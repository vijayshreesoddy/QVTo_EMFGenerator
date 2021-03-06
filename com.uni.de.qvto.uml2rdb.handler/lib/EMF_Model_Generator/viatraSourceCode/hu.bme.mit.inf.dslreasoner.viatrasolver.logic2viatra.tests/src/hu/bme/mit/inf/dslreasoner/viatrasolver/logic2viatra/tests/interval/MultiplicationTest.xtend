package hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.tests.interval

import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.interval.Interval
import java.util.Collection
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameter
import org.junit.runners.Parameterized.Parameters

import static hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.interval.Interval.*

@RunWith(Parameterized)
class MultiplicationTest {
	@Parameters(name="{index}: {0} * {1} = {2}")
	static def Collection<Object[]> data() {
		#[
			#[EMPTY, EMPTY, EMPTY],
			#[EMPTY, between(-1, 1), EMPTY],
			#[between(-1, 1), EMPTY, EMPTY],
			#[UNBOUNDED, UNBOUNDED, UNBOUNDED],
			#[UNBOUNDED, upTo(-2), UNBOUNDED],
			#[UNBOUNDED, upTo(0), UNBOUNDED],
			#[UNBOUNDED, upTo(3), UNBOUNDED],
			#[UNBOUNDED, above(-2), UNBOUNDED],
			#[UNBOUNDED, above(0), UNBOUNDED],
			#[UNBOUNDED, above(3), UNBOUNDED],
			#[UNBOUNDED, between(-4, -3), UNBOUNDED],
			#[UNBOUNDED, between(-4, 0), UNBOUNDED],
			#[UNBOUNDED, between(-3, 4), UNBOUNDED],
			#[UNBOUNDED, between(0, 4), UNBOUNDED],
			#[UNBOUNDED, between(3, 4), UNBOUNDED],
			#[UNBOUNDED, ZERO, ZERO],
			#[upTo(-5), UNBOUNDED, UNBOUNDED],
			#[upTo(-5), upTo(-2), above(10)],
			#[upTo(-5), upTo(0), above(0)],
			#[upTo(-5), upTo(3), UNBOUNDED],
			#[upTo(-5), above(-2), UNBOUNDED],
			#[upTo(-5), above(0), upTo(0)],
			#[upTo(-5), above(3), upTo(-15)],
			#[upTo(-5), between(-4, -3), above(15)],
			#[upTo(-5), between(-4, 0), above(0)],
			#[upTo(-5), between(-3, 4), UNBOUNDED],
			#[upTo(-5), between(0, 4), upTo(0)],
			#[upTo(-5), between(3, 4), upTo(-15)],
			#[upTo(-5), ZERO, ZERO],
			#[upTo(0), UNBOUNDED, UNBOUNDED],
			#[upTo(0), upTo(-2), above(0)],
			#[upTo(0), upTo(0), above(0)],
			#[upTo(0), upTo(3), UNBOUNDED],
			#[upTo(0), above(-2), UNBOUNDED],
			#[upTo(0), above(0), upTo(0)],
			#[upTo(0), above(3), upTo(0)],
			#[upTo(0), between(-4, -3), above(0)],
			#[upTo(0), between(-4, 0), above(0)],
			#[upTo(0), between(-3, 4), UNBOUNDED],
			#[upTo(0), between(0, 4), upTo(0)],
			#[upTo(0), between(3, 4), upTo(0)],
			#[upTo(0), ZERO, ZERO],
			#[upTo(5), UNBOUNDED, UNBOUNDED],
			#[upTo(5), upTo(-2), UNBOUNDED],
			#[upTo(5), upTo(0), UNBOUNDED],
			#[upTo(5), upTo(3), UNBOUNDED],
			#[upTo(5), above(-2), UNBOUNDED],
			#[upTo(5), above(0), UNBOUNDED],
			#[upTo(5), above(3), UNBOUNDED],
			#[upTo(5), between(-4, -3), above(-20)],
			#[upTo(5), between(-4, 0), above(-20)],
			#[upTo(5), between(-3, 4), UNBOUNDED],
			#[upTo(5), between(0, 4), upTo(20)],
			#[upTo(5), between(3, 4), upTo(20)],
			#[upTo(5), ZERO, ZERO],
			#[above(-5), UNBOUNDED, UNBOUNDED],
			#[above(-5), upTo(-2), UNBOUNDED],
			#[above(-5), upTo(0), UNBOUNDED],
			#[above(-5), upTo(3), UNBOUNDED],
			#[above(-5), above(-2), UNBOUNDED],
			#[above(-5), above(0), UNBOUNDED],
			#[above(-5), above(3), UNBOUNDED],
			#[above(-5), between(-4, -3), upTo(20)],
			#[above(-5), between(-4, 0), upTo(20)],
			#[above(-5), between(-3, 4), UNBOUNDED],
			#[above(-5), between(0, 4), above(-20)],
			#[above(-5), between(3, 4), above(-20)],
			#[above(-5), ZERO, ZERO],
			#[above(0), UNBOUNDED, UNBOUNDED],
			#[above(0), upTo(-2), upTo(0)],
			#[above(0), upTo(0), upTo(0)],
			#[above(0), upTo(3), UNBOUNDED],
			#[above(0), above(-2), UNBOUNDED],
			#[above(0), above(0), above(0)],
			#[above(0), above(3), above(0)],
			#[above(0), between(-4, -3), upTo(0)],
			#[above(0), between(-4, 0), upTo(0)],
			#[above(0), between(-3, 4), UNBOUNDED],
			#[above(0), between(0, 4), above(0)],
			#[above(0), between(3, 4), above(0)],
			#[above(0), ZERO, ZERO],
			#[above(5), UNBOUNDED, UNBOUNDED],
			#[above(5), upTo(-2), upTo(-10)],
			#[above(5), upTo(0), upTo(0)],
			#[above(5), upTo(3), UNBOUNDED],
			#[above(5), above(-2), UNBOUNDED],
			#[above(5), above(0), above(0)],
			#[above(5), above(3), above(15)],
			#[above(5), between(-4, -3), upTo(-15)],
			#[above(5), between(-4, 0), upTo(0)],
			#[above(5), between(-3, 4), UNBOUNDED],
			#[above(5), between(0, 4), above(0)],
			#[above(5), between(3, 4), above(15)],
			#[above(5), ZERO, ZERO],
			#[between(-6, -5), UNBOUNDED, UNBOUNDED],
			#[between(-6, -5), upTo(-2), above(10)],
			#[between(-6, -5), upTo(0), above(0)],
			#[between(-6, -5), upTo(3), above(-18)],
			#[between(-6, -5), above(-2), upTo(12)],
			#[between(-6, -5), above(0), upTo(0)],
			#[between(-6, -5), above(3), upTo(-15)],
			#[between(-6, -5), between(-4, -3), between(15, 24)],
			#[between(-6, -5), between(-4, 0), between(0, 24)],
			#[between(-6, -5), between(-3, 4), between(-24, 18)],
			#[between(-6, -5), between(0, 4), between(-24, 0)],
			#[between(-6, -5), between(3, 4), between(-24, -15)],
			#[between(-6, -5), ZERO, ZERO],
			#[between(-6, 0), UNBOUNDED, UNBOUNDED],
			#[between(-6, 0), upTo(-2), above(0)],
			#[between(-6, 0), upTo(0), above(0)],
			#[between(-6, 0), upTo(3), above(-18)],
			#[between(-6, 0), above(-2), upTo(12)],
			#[between(-6, 0), above(0), upTo(0)],
			#[between(-6, 0), above(3), upTo(0)],
			#[between(-6, 0), between(-4, -3), between(0, 24)],
			#[between(-6, 0), between(-4, 0), between(0, 24)],
			#[between(-6, 0), between(-3, 4), between(-24, 18)],
			#[between(-6, 0), between(0, 4), between(-24, 0)],
			#[between(-6, 0), between(3, 4), between(-24, 0)],
			#[between(-6, 0), ZERO, ZERO],
			#[between(-5, 6), UNBOUNDED, UNBOUNDED],
			#[between(-5, 6), upTo(-2), UNBOUNDED],
			#[between(-5, 6), upTo(0), UNBOUNDED],
			#[between(-5, 6), upTo(3), UNBOUNDED],
			#[between(-5, 6), above(-2), UNBOUNDED],
			#[between(-5, 6), above(0), UNBOUNDED],
			#[between(-5, 6), above(3), UNBOUNDED],
			#[between(-5, 6), between(-4, -3), between(-24, 20)],
			#[between(-5, 6), between(-4, 0), between(-24, 20)],
			#[between(-5, 6), between(-3, 4), between(-20, 24)],
			#[between(-5, 6), between(-3, 2), between(-18, 15)],
			#[between(-5, 1), between(-3, 4), between(-20, 15)],
			#[between(-5, 1), between(-3, 2), between(-10, 15)],
			#[between(-5, 6), between(0, 4), between(-20, 24)],
			#[between(-5, 6), between(3, 4), between(-20, 24)],
			#[between(-5, 6), ZERO, ZERO],
			#[between(0, 6), UNBOUNDED, UNBOUNDED],
			#[between(0, 6), upTo(-2), upTo(0)],
			#[between(0, 6), upTo(0), upTo(0)],
			#[between(0, 6), upTo(3), upTo(18)],
			#[between(0, 6), above(-2), above(-12)],
			#[between(0, 6), above(0), above(0)],
			#[between(0, 6), above(3), above(0)],
			#[between(0, 6), between(-4, -3), between(-24, 0)],
			#[between(0, 6), between(-4, 0), between(-24, 0)],
			#[between(0, 6), between(-3, 4), between(-18, 24)],
			#[between(0, 6), between(0, 4), between(0, 24)],
			#[between(0, 6), between(3, 4), between(0, 24)],
			#[between(0, 6), ZERO, ZERO],
			#[between(5, 6), UNBOUNDED, UNBOUNDED],
			#[between(5, 6), upTo(-2), upTo(-10)],
			#[between(5, 6), upTo(0), upTo(0)],
			#[between(5, 6), upTo(3), upTo(18)],
			#[between(5, 6), above(-2), above(-12)],
			#[between(5, 6), above(0), above(0)],
			#[between(5, 6), above(3), above(15)],
			#[between(5, 6), between(-4, -3), between(-24, -15)],
			#[between(5, 6), between(-4, 0), between(-24, 0)],
			#[between(5, 6), between(-3, 4), between(-18, 24)],
			#[between(5, 6), between(0, 4), between(0, 24)],
			#[between(5, 6), between(3, 4), between(15, 24)],
			#[between(5, 6), ZERO, ZERO],
			#[ZERO, UNBOUNDED, ZERO],
			#[ZERO, upTo(-2), ZERO],
			#[ZERO, upTo(0), ZERO],
			#[ZERO, upTo(3), ZERO],
			#[ZERO, above(-2), ZERO],
			#[ZERO, above(0), ZERO],
			#[ZERO, above(3), ZERO],
			#[ZERO, between(-4, -3), ZERO],
			#[ZERO, between(-4, 0), ZERO],
			#[ZERO, between(-3, 4), ZERO],
			#[ZERO, between(0, 4), ZERO],
			#[ZERO, between(3, 4), ZERO],
			#[ZERO, ZERO, ZERO]
		]
	}

	@Parameter(0) public var Interval a
	@Parameter(1) public var Interval b
	@Parameter(2) public var Interval result

	@Test
	def void multiplicatonTest() {
		Assert.assertEquals(result, a * b)
	}
}
