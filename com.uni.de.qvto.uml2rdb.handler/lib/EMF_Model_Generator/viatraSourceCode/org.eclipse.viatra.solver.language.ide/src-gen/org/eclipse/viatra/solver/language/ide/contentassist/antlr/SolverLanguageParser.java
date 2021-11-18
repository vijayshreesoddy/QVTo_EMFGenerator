/*
 * generated by Xtext 2.12.0
 */
package org.eclipse.viatra.solver.language.ide.contentassist.antlr;

import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.viatra.solver.language.ide.contentassist.antlr.internal.InternalSolverLanguageParser;
import org.eclipse.viatra.solver.language.services.SolverLanguageGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class SolverLanguageParser extends AbstractContentAssistParser {

	@Inject
	private SolverLanguageGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalSolverLanguageParser createParser() {
		InternalSolverLanguageParser result = new InternalSolverLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected TokenSource createLexer(CharStream stream) {
		return new SolverLanguageTokenSource(super.createLexer(stream));
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getStatementAccess().getAlternatives(), "rule__Statement__Alternatives");
					put(grammarAccess.getImportAccess().getAlternatives(), "rule__Import__Alternatives");
					put(grammarAccess.getAssertionOrDefinitionAccess().getAlternatives_1(), "rule__AssertionOrDefinition__Alternatives_1");
					put(grammarAccess.getPredicateDefinitionAccess().getAlternatives_0(), "rule__PredicateDefinition__Alternatives_0");
					put(grammarAccess.getExternDeclarationAccess().getAlternatives(), "rule__ExternDeclaration__Alternatives");
					put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
					put(grammarAccess.getDisjunctiveExpressionAccess().getAlternatives_1(), "rule__DisjunctiveExpression__Alternatives_1");
					put(grammarAccess.getUnaryExpressionAccess().getAlternatives(), "rule__UnaryExpression__Alternatives");
					put(grammarAccess.getBracedAggregateExpressionAccess().getAlternatives(), "rule__BracedAggregateExpression__Alternatives");
					put(grammarAccess.getAtomicExpressionAccess().getAlternatives(), "rule__AtomicExpression__Alternatives");
					put(grammarAccess.getArgumentAccess().getAlternatives(), "rule__Argument__Alternatives");
					put(grammarAccess.getPathComponentAccess().getAlternatives_2(), "rule__PathComponent__Alternatives_2");
					put(grammarAccess.getLiteralAccess().getAlternatives(), "rule__Literal__Alternatives");
					put(grammarAccess.getClassDeclarationAccess().getAlternatives_4(), "rule__ClassDeclaration__Alternatives_4");
					put(grammarAccess.getFieldAccess().getAlternatives_0(), "rule__Field__Alternatives_0");
					put(grammarAccess.getMultiplicityAccess().getAlternatives(), "rule__Multiplicity__Alternatives");
					put(grammarAccess.getEnumDeclarationAccess().getAlternatives_2(), "rule__EnumDeclaration__Alternatives_2");
					put(grammarAccess.getScopeDeclarationAccess().getAlternatives(), "rule__ScopeDeclaration__Alternatives");
					put(grammarAccess.getBoundedScopeAccess().getAlternatives_1(), "rule__BoundedScope__Alternatives_1");
					put(grammarAccess.getLowerBoundedScopeAccess().getAlternatives_1(), "rule__LowerBoundedScope__Alternatives_1");
					put(grammarAccess.getUpperMultiplictyAccess().getAlternatives(), "rule__UpperMultiplicty__Alternatives");
					put(grammarAccess.getQualifiedNameSegmentAccess().getAlternatives(), "rule__QualifiedNameSegment__Alternatives");
					put(grammarAccess.getAttributeKindAccess().getAlternatives(), "rule__AttributeKind__Alternatives");
					put(grammarAccess.getComparisonOperatorAccess().getAlternatives(), "rule__ComparisonOperator__Alternatives");
					put(grammarAccess.getAdditiveBinaryOperatorAccess().getAlternatives(), "rule__AdditiveBinaryOperator__Alternatives");
					put(grammarAccess.getMultiplicativeBinaryOperatorAccess().getAlternatives(), "rule__MultiplicativeBinaryOperator__Alternatives");
					put(grammarAccess.getUnaryOperatorAccess().getAlternatives(), "rule__UnaryOperator__Alternatives");
					put(grammarAccess.getLogicValueAccess().getAlternatives(), "rule__LogicValue__Alternatives");
					put(grammarAccess.getObjectiveKindAccess().getAlternatives(), "rule__ObjectiveKind__Alternatives");
					put(grammarAccess.getProblemAccess().getGroup(), "rule__Problem__Group__0");
					put(grammarAccess.getProblemAccess().getGroup_0(), "rule__Problem__Group_0__0");
					put(grammarAccess.getUriImportAccess().getGroup(), "rule__UriImport__Group__0");
					put(grammarAccess.getUriImportAccess().getGroup_2(), "rule__UriImport__Group_2__0");
					put(grammarAccess.getNamespaceImportAccess().getGroup(), "rule__NamespaceImport__Group__0");
					put(grammarAccess.getNamespaceImportAccess().getGroup_2(), "rule__NamespaceImport__Group_2__0");
					put(grammarAccess.getAssertionOrDefinitionAccess().getGroup(), "rule__AssertionOrDefinition__Group__0");
					put(grammarAccess.getAssertionOrDefinitionAccess().getGroup_1_0(), "rule__AssertionOrDefinition__Group_1_0__0");
					put(grammarAccess.getAssertionOrDefinitionAccess().getGroup_1_0_1(), "rule__AssertionOrDefinition__Group_1_0_1__0");
					put(grammarAccess.getAssertionOrDefinitionAccess().getGroup_1_1(), "rule__AssertionOrDefinition__Group_1_1__0");
					put(grammarAccess.getAssertionOrDefinitionAccess().getGroup_1_2(), "rule__AssertionOrDefinition__Group_1_2__0");
					put(grammarAccess.getPredicateDefinitionAccess().getGroup(), "rule__PredicateDefinition__Group__0");
					put(grammarAccess.getPredicateDefinitionAccess().getGroup_0_0(), "rule__PredicateDefinition__Group_0_0__0");
					put(grammarAccess.getPredicateDefinitionAccess().getGroup_0_1(), "rule__PredicateDefinition__Group_0_1__0");
					put(grammarAccess.getUnnamedErrorPredicateDefintionAccess().getGroup(), "rule__UnnamedErrorPredicateDefintion__Group__0");
					put(grammarAccess.getDefaultAssertionAccess().getGroup(), "rule__DefaultAssertion__Group__0");
					put(grammarAccess.getDefaultAssertionAccess().getGroup_2(), "rule__DefaultAssertion__Group_2__0");
					put(grammarAccess.getFunctionDefinitionAccess().getGroup(), "rule__FunctionDefinition__Group__0");
					put(grammarAccess.getTypeReferenceAccess().getGroup(), "rule__TypeReference__Group__0");
					put(grammarAccess.getAttributeAccess().getGroup(), "rule__Attribute__Group__0");
					put(grammarAccess.getExternPredicateDeclarationAccess().getGroup(), "rule__ExternPredicateDeclaration__Group__0");
					put(grammarAccess.getExternFunctionDeclarationAccess().getGroup(), "rule__ExternFunctionDeclaration__Group__0");
					put(grammarAccess.getExternAggregationOperatorDeclarationAccess().getGroup(), "rule__ExternAggregationOperatorDeclaration__Group__0");
					put(grammarAccess.getExternDatatypeDeclarationAccess().getGroup(), "rule__ExternDatatypeDeclaration__Group__0");
					put(grammarAccess.getExpressionAccess().getGroup_2(), "rule__Expression__Group_2__0");
					put(grammarAccess.getExpressionAccess().getGroup_2_1(), "rule__Expression__Group_2_1__0");
					put(grammarAccess.getConditionalExpressionAccess().getGroup(), "rule__ConditionalExpression__Group__0");
					put(grammarAccess.getLetExpressionAccess().getGroup(), "rule__LetExpression__Group__0");
					put(grammarAccess.getLetExpressionAccess().getGroup_2(), "rule__LetExpression__Group_2__0");
					put(grammarAccess.getLetBindingAccess().getGroup(), "rule__LetBinding__Group__0");
					put(grammarAccess.getDisjunctiveExpressionAccess().getGroup(), "rule__DisjunctiveExpression__Group__0");
					put(grammarAccess.getDisjunctiveExpressionAccess().getGroup_1_0(), "rule__DisjunctiveExpression__Group_1_0__0");
					put(grammarAccess.getDisjunctiveExpressionAccess().getGroup_1_0_1(), "rule__DisjunctiveExpression__Group_1_0_1__0");
					put(grammarAccess.getDisjunctiveExpressionAccess().getGroup_1_1(), "rule__DisjunctiveExpression__Group_1_1__0");
					put(grammarAccess.getDisjunctiveExpressionAccess().getGroup_1_1_4(), "rule__DisjunctiveExpression__Group_1_1_4__0");
					put(grammarAccess.getCaseAccess().getGroup(), "rule__Case__Group__0");
					put(grammarAccess.getConjunctiveExpressionAccess().getGroup(), "rule__ConjunctiveExpression__Group__0");
					put(grammarAccess.getConjunctiveExpressionAccess().getGroup_1(), "rule__ConjunctiveExpression__Group_1__0");
					put(grammarAccess.getConjunctiveExpressionAccess().getGroup_1_1(), "rule__ConjunctiveExpression__Group_1_1__0");
					put(grammarAccess.getComparisonExpressionAccess().getGroup(), "rule__ComparisonExpression__Group__0");
					put(grammarAccess.getComparisonExpressionAccess().getGroup_1(), "rule__ComparisonExpression__Group_1__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup(), "rule__AdditiveExpression__Group__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup_1(), "rule__AdditiveExpression__Group_1__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup(), "rule__MultiplicativeExpression__Group__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1(), "rule__MultiplicativeExpression__Group_1__0");
					put(grammarAccess.getExponentialExpressionAccess().getGroup(), "rule__ExponentialExpression__Group__0");
					put(grammarAccess.getExponentialExpressionAccess().getGroup_1(), "rule__ExponentialExpression__Group_1__0");
					put(grammarAccess.getCastExpressionAccess().getGroup(), "rule__CastExpression__Group__0");
					put(grammarAccess.getCastExpressionAccess().getGroup_1(), "rule__CastExpression__Group_1__0");
					put(grammarAccess.getUnaryExpressionAccess().getGroup_1(), "rule__UnaryExpression__Group_1__0");
					put(grammarAccess.getAggregationAccess().getGroup(), "rule__Aggregation__Group__0");
					put(grammarAccess.getCountAccess().getGroup(), "rule__Count__Group__0");
					put(grammarAccess.getAtomicExpressionAccess().getGroup_4(), "rule__AtomicExpression__Group_4__0");
					put(grammarAccess.getCallAccess().getGroup(), "rule__Call__Group__0");
					put(grammarAccess.getArgumentListAccess().getGroup(), "rule__ArgumentList__Group__0");
					put(grammarAccess.getArgumentListAccess().getGroup_2(), "rule__ArgumentList__Group_2__0");
					put(grammarAccess.getArgumentListAccess().getGroup_2_1(), "rule__ArgumentList__Group_2_1__0");
					put(grammarAccess.getStarArgumentAccess().getGroup(), "rule__StarArgument__Group__0");
					put(grammarAccess.getTypedVariableArgumentAccess().getGroup(), "rule__TypedVariableArgument__Group__0");
					put(grammarAccess.getTypedStarArgumentAccess().getGroup(), "rule__TypedStarArgument__Group__0");
					put(grammarAccess.getReferenceAccess().getGroup(), "rule__Reference__Group__0");
					put(grammarAccess.getReferenceAccess().getGroup_1(), "rule__Reference__Group_1__0");
					put(grammarAccess.getPathComponentAccess().getGroup(), "rule__PathComponent__Group__0");
					put(grammarAccess.getIntervalAccess().getGroup(), "rule__Interval__Group__0");
					put(grammarAccess.getInfinityLiteralAccess().getGroup(), "rule__InfinityLiteral__Group__0");
					put(grammarAccess.getEmptyLiteralAccess().getGroup(), "rule__EmptyLiteral__Group__0");
					put(grammarAccess.getClassDeclarationAccess().getGroup(), "rule__ClassDeclaration__Group__0");
					put(grammarAccess.getClassDeclarationAccess().getGroup_3(), "rule__ClassDeclaration__Group_3__0");
					put(grammarAccess.getClassDeclarationAccess().getGroup_3_2(), "rule__ClassDeclaration__Group_3_2__0");
					put(grammarAccess.getClassDeclarationAccess().getGroup_4_0(), "rule__ClassDeclaration__Group_4_0__0");
					put(grammarAccess.getFieldAccess().getGroup(), "rule__Field__Group__0");
					put(grammarAccess.getFieldAccess().getGroup_4(), "rule__Field__Group_4__0");
					put(grammarAccess.getUnboundedMultiplicityAccess().getGroup(), "rule__UnboundedMultiplicity__Group__0");
					put(grammarAccess.getExactMultiplicityAccess().getGroup(), "rule__ExactMultiplicity__Group__0");
					put(grammarAccess.getBoundedMultiplicityAccess().getGroup(), "rule__BoundedMultiplicity__Group__0");
					put(grammarAccess.getEnumDeclarationAccess().getGroup(), "rule__EnumDeclaration__Group__0");
					put(grammarAccess.getEnumDeclarationAccess().getGroup_2_0(), "rule__EnumDeclaration__Group_2_0__0");
					put(grammarAccess.getEnumDeclarationAccess().getGroup_2_0_1(), "rule__EnumDeclaration__Group_2_0_1__0");
					put(grammarAccess.getEnumDeclarationAccess().getGroup_2_0_1_1(), "rule__EnumDeclaration__Group_2_0_1_1__0");
					put(grammarAccess.getExactScopeAccess().getGroup(), "rule__ExactScope__Group__0");
					put(grammarAccess.getBoundedScopeAccess().getGroup(), "rule__BoundedScope__Group__0");
					put(grammarAccess.getBoundedScopeAccess().getGroup_1_0(), "rule__BoundedScope__Group_1_0__0");
					put(grammarAccess.getBoundedScopeAccess().getGroup_1_0_0(), "rule__BoundedScope__Group_1_0_0__0");
					put(grammarAccess.getBoundedScopeAccess().getGroup_1_1(), "rule__BoundedScope__Group_1_1__0");
					put(grammarAccess.getBoundedScopeAccess().getGroup_1_1_3(), "rule__BoundedScope__Group_1_1_3__0");
					put(grammarAccess.getLowerBoundedScopeAccess().getGroup(), "rule__LowerBoundedScope__Group__0");
					put(grammarAccess.getLowerBoundedScopeAccess().getGroup_1_0(), "rule__LowerBoundedScope__Group_1_0__0");
					put(grammarAccess.getLowerBoundedScopeAccess().getGroup_1_1(), "rule__LowerBoundedScope__Group_1_1__0");
					put(grammarAccess.getObjectiveDeclarationAccess().getGroup(), "rule__ObjectiveDeclaration__Group__0");
					put(grammarAccess.getRealAccess().getGroup(), "rule__Real__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getProblemAccess().getNameAssignment_0_1(), "rule__Problem__NameAssignment_0_1");
					put(grammarAccess.getProblemAccess().getImportsAssignment_1(), "rule__Problem__ImportsAssignment_1");
					put(grammarAccess.getProblemAccess().getStatementsAssignment_2(), "rule__Problem__StatementsAssignment_2");
					put(grammarAccess.getUriImportAccess().getUriAssignment_1(), "rule__UriImport__UriAssignment_1");
					put(grammarAccess.getUriImportAccess().getAliasAssignment_2_1(), "rule__UriImport__AliasAssignment_2_1");
					put(grammarAccess.getNamespaceImportAccess().getImportedNamespaceAssignment_1(), "rule__NamespaceImport__ImportedNamespaceAssignment_1");
					put(grammarAccess.getNamespaceImportAccess().getAliasAssignment_2_1(), "rule__NamespaceImport__AliasAssignment_2_1");
					put(grammarAccess.getAssertionOrDefinitionAccess().getRangeAssignment_1_0_1_1(), "rule__AssertionOrDefinition__RangeAssignment_1_0_1_1");
					put(grammarAccess.getAssertionOrDefinitionAccess().getBodyAssignment_1_1_2(), "rule__AssertionOrDefinition__BodyAssignment_1_1_2");
					put(grammarAccess.getAssertionOrDefinitionAccess().getBodyAssignment_1_2_2(), "rule__AssertionOrDefinition__BodyAssignment_1_2_2");
					put(grammarAccess.getPredicateDefinitionAccess().getFunctionalAssignment_0_0_0(), "rule__PredicateDefinition__FunctionalAssignment_0_0_0");
					put(grammarAccess.getPredicateDefinitionAccess().getErrorAssignment_0_0_1(), "rule__PredicateDefinition__ErrorAssignment_0_0_1");
					put(grammarAccess.getPredicateDefinitionAccess().getErrorAssignment_0_1_0(), "rule__PredicateDefinition__ErrorAssignment_0_1_0");
					put(grammarAccess.getPredicateDefinitionAccess().getFunctionalAssignment_0_1_1(), "rule__PredicateDefinition__FunctionalAssignment_0_1_1");
					put(grammarAccess.getPredicateDefinitionAccess().getHeadAssignment_1(), "rule__PredicateDefinition__HeadAssignment_1");
					put(grammarAccess.getPredicateDefinitionAccess().getBodyAssignment_3(), "rule__PredicateDefinition__BodyAssignment_3");
					put(grammarAccess.getUnnamedErrorPredicateDefintionAccess().getArgumentListAssignment_1(), "rule__UnnamedErrorPredicateDefintion__ArgumentListAssignment_1");
					put(grammarAccess.getUnnamedErrorPredicateDefintionAccess().getBodyAssignment_3(), "rule__UnnamedErrorPredicateDefintion__BodyAssignment_3");
					put(grammarAccess.getDefaultAssertionAccess().getExpressionAssignment_1(), "rule__DefaultAssertion__ExpressionAssignment_1");
					put(grammarAccess.getDefaultAssertionAccess().getRangeAssignment_2_1(), "rule__DefaultAssertion__RangeAssignment_2_1");
					put(grammarAccess.getFunctionDefinitionAccess().getResultTypeAssignment_0(), "rule__FunctionDefinition__ResultTypeAssignment_0");
					put(grammarAccess.getFunctionDefinitionAccess().getHeadAssignment_1(), "rule__FunctionDefinition__HeadAssignment_1");
					put(grammarAccess.getFunctionDefinitionAccess().getBodyAssignment_3(), "rule__FunctionDefinition__BodyAssignment_3");
					put(grammarAccess.getTypeReferenceAccess().getTypeAssignment_0(), "rule__TypeReference__TypeAssignment_0");
					put(grammarAccess.getTypeReferenceAccess().getForceObjectTypeAssignment_1(), "rule__TypeReference__ForceObjectTypeAssignment_1");
					put(grammarAccess.getAttributeAccess().getKindAssignment_0(), "rule__Attribute__KindAssignment_0");
					put(grammarAccess.getAttributeAccess().getTargetAssignment_1(), "rule__Attribute__TargetAssignment_1");
					put(grammarAccess.getExternPredicateDeclarationAccess().getFunctionalAssignment_1_0(), "rule__ExternPredicateDeclaration__FunctionalAssignment_1_0");
					put(grammarAccess.getExternPredicateDeclarationAccess().getErrorAssignment_1_1(), "rule__ExternPredicateDeclaration__ErrorAssignment_1_1");
					put(grammarAccess.getExternPredicateDeclarationAccess().getNameAssignment_2(), "rule__ExternPredicateDeclaration__NameAssignment_2");
					put(grammarAccess.getExternPredicateDeclarationAccess().getArgumentListAssignment_3(), "rule__ExternPredicateDeclaration__ArgumentListAssignment_3");
					put(grammarAccess.getExternFunctionDeclarationAccess().getResultTypeAssignment_1(), "rule__ExternFunctionDeclaration__ResultTypeAssignment_1");
					put(grammarAccess.getExternFunctionDeclarationAccess().getNameAssignment_2(), "rule__ExternFunctionDeclaration__NameAssignment_2");
					put(grammarAccess.getExternFunctionDeclarationAccess().getArgumentListAssignment_3(), "rule__ExternFunctionDeclaration__ArgumentListAssignment_3");
					put(grammarAccess.getExternAggregationOperatorDeclarationAccess().getResultTypeAssignment_1(), "rule__ExternAggregationOperatorDeclaration__ResultTypeAssignment_1");
					put(grammarAccess.getExternAggregationOperatorDeclarationAccess().getNameAssignment_2(), "rule__ExternAggregationOperatorDeclaration__NameAssignment_2");
					put(grammarAccess.getExternAggregationOperatorDeclarationAccess().getArgumentTypeAssignment_4(), "rule__ExternAggregationOperatorDeclaration__ArgumentTypeAssignment_4");
					put(grammarAccess.getExternDatatypeDeclarationAccess().getNameAssignment_2(), "rule__ExternDatatypeDeclaration__NameAssignment_2");
					put(grammarAccess.getExpressionAccess().getBodyAssignment_2_1_2(), "rule__Expression__BodyAssignment_2_1_2");
					put(grammarAccess.getConditionalExpressionAccess().getConditionAssignment_1(), "rule__ConditionalExpression__ConditionAssignment_1");
					put(grammarAccess.getConditionalExpressionAccess().getThenAssignment_3(), "rule__ConditionalExpression__ThenAssignment_3");
					put(grammarAccess.getConditionalExpressionAccess().getElseAssignment_5(), "rule__ConditionalExpression__ElseAssignment_5");
					put(grammarAccess.getLetExpressionAccess().getBindingsAssignment_1(), "rule__LetExpression__BindingsAssignment_1");
					put(grammarAccess.getLetExpressionAccess().getBindingsAssignment_2_1(), "rule__LetExpression__BindingsAssignment_2_1");
					put(grammarAccess.getLetExpressionAccess().getBodyAssignment_4(), "rule__LetExpression__BodyAssignment_4");
					put(grammarAccess.getLetBindingAccess().getTypeAssignment_0(), "rule__LetBinding__TypeAssignment_0");
					put(grammarAccess.getLetBindingAccess().getNameAssignment_1(), "rule__LetBinding__NameAssignment_1");
					put(grammarAccess.getLetBindingAccess().getValueAssignment_3(), "rule__LetBinding__ValueAssignment_3");
					put(grammarAccess.getDisjunctiveExpressionAccess().getChildrenAssignment_1_0_1_1(), "rule__DisjunctiveExpression__ChildrenAssignment_1_0_1_1");
					put(grammarAccess.getDisjunctiveExpressionAccess().getBodyAssignment_1_1_2(), "rule__DisjunctiveExpression__BodyAssignment_1_1_2");
					put(grammarAccess.getDisjunctiveExpressionAccess().getCasesAssignment_1_1_4_1(), "rule__DisjunctiveExpression__CasesAssignment_1_1_4_1");
					put(grammarAccess.getCaseAccess().getConditionAssignment_0(), "rule__Case__ConditionAssignment_0");
					put(grammarAccess.getCaseAccess().getBodyAssignment_2(), "rule__Case__BodyAssignment_2");
					put(grammarAccess.getConjunctiveExpressionAccess().getChildrenAssignment_1_1_1(), "rule__ConjunctiveExpression__ChildrenAssignment_1_1_1");
					put(grammarAccess.getComparisonExpressionAccess().getOpAssignment_1_1(), "rule__ComparisonExpression__OpAssignment_1_1");
					put(grammarAccess.getComparisonExpressionAccess().getRightAssignment_1_2(), "rule__ComparisonExpression__RightAssignment_1_2");
					put(grammarAccess.getAdditiveExpressionAccess().getOpAssignment_1_1(), "rule__AdditiveExpression__OpAssignment_1_1");
					put(grammarAccess.getAdditiveExpressionAccess().getRightAssignment_1_2(), "rule__AdditiveExpression__RightAssignment_1_2");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOpAssignment_1_1(), "rule__MultiplicativeExpression__OpAssignment_1_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getRightAssignment_1_2(), "rule__MultiplicativeExpression__RightAssignment_1_2");
					put(grammarAccess.getExponentialExpressionAccess().getOpAssignment_1_1(), "rule__ExponentialExpression__OpAssignment_1_1");
					put(grammarAccess.getExponentialExpressionAccess().getRightAssignment_1_2(), "rule__ExponentialExpression__RightAssignment_1_2");
					put(grammarAccess.getCastExpressionAccess().getTargetTypeAssignment_1_2(), "rule__CastExpression__TargetTypeAssignment_1_2");
					put(grammarAccess.getUnaryExpressionAccess().getOpAssignment_1_1(), "rule__UnaryExpression__OpAssignment_1_1");
					put(grammarAccess.getUnaryExpressionAccess().getBodyAssignment_1_2(), "rule__UnaryExpression__BodyAssignment_1_2");
					put(grammarAccess.getAggregationAccess().getOpAssignment_0(), "rule__Aggregation__OpAssignment_0");
					put(grammarAccess.getAggregationAccess().getValueAssignment_2(), "rule__Aggregation__ValueAssignment_2");
					put(grammarAccess.getAggregationAccess().getConditionAssignment_4(), "rule__Aggregation__ConditionAssignment_4");
					put(grammarAccess.getCountAccess().getConditionAssignment_2(), "rule__Count__ConditionAssignment_2");
					put(grammarAccess.getCallAccess().getFunctorAssignment_0(), "rule__Call__FunctorAssignment_0");
					put(grammarAccess.getCallAccess().getArgumentListAssignment_1(), "rule__Call__ArgumentListAssignment_1");
					put(grammarAccess.getArgumentListAccess().getArgumentsAssignment_2_0(), "rule__ArgumentList__ArgumentsAssignment_2_0");
					put(grammarAccess.getArgumentListAccess().getArgumentsAssignment_2_1_1(), "rule__ArgumentList__ArgumentsAssignment_2_1_1");
					put(grammarAccess.getExpressionArgumentAccess().getExpressionAssignment(), "rule__ExpressionArgument__ExpressionAssignment");
					put(grammarAccess.getTypedVariableArgumentAccess().getTypeReferenceAssignment_0(), "rule__TypedVariableArgument__TypeReferenceAssignment_0");
					put(grammarAccess.getTypedVariableArgumentAccess().getNameAssignment_1(), "rule__TypedVariableArgument__NameAssignment_1");
					put(grammarAccess.getTypedStarArgumentAccess().getTypeReferenceAssignment_0(), "rule__TypedStarArgument__TypeReferenceAssignment_0");
					put(grammarAccess.getReferenceAccess().getComponentsAssignment_0(), "rule__Reference__ComponentsAssignment_0");
					put(grammarAccess.getReferenceAccess().getComponentsAssignment_1_1(), "rule__Reference__ComponentsAssignment_1_1");
					put(grammarAccess.getPathComponentAccess().getInverseAssignment_0(), "rule__PathComponent__InverseAssignment_0");
					put(grammarAccess.getPathComponentAccess().getSymbolAssignment_1(), "rule__PathComponent__SymbolAssignment_1");
					put(grammarAccess.getPathComponentAccess().getTransitiveClosureAssignment_2_0(), "rule__PathComponent__TransitiveClosureAssignment_2_0");
					put(grammarAccess.getPathComponentAccess().getReflexiveTransitiveClosureAssignment_2_1(), "rule__PathComponent__ReflexiveTransitiveClosureAssignment_2_1");
					put(grammarAccess.getIntervalAccess().getLowerBoundAssignment_1(), "rule__Interval__LowerBoundAssignment_1");
					put(grammarAccess.getIntervalAccess().getUpperBoundAssignment_3(), "rule__Interval__UpperBoundAssignment_3");
					put(grammarAccess.getLogicLiteralAccess().getValueAssignment(), "rule__LogicLiteral__ValueAssignment");
					put(grammarAccess.getIntLiteralAccess().getValueAssignment(), "rule__IntLiteral__ValueAssignment");
					put(grammarAccess.getRealLiteralAccess().getValueAssignment(), "rule__RealLiteral__ValueAssignment");
					put(grammarAccess.getStringLiteralAccess().getValueAssignment(), "rule__StringLiteral__ValueAssignment");
					put(grammarAccess.getClassDeclarationAccess().getAbstractAssignment_0_0(), "rule__ClassDeclaration__AbstractAssignment_0_0");
					put(grammarAccess.getClassDeclarationAccess().getRootAssignment_0_1(), "rule__ClassDeclaration__RootAssignment_0_1");
					put(grammarAccess.getClassDeclarationAccess().getNameAssignment_2(), "rule__ClassDeclaration__NameAssignment_2");
					put(grammarAccess.getClassDeclarationAccess().getSupertypesAssignment_3_1(), "rule__ClassDeclaration__SupertypesAssignment_3_1");
					put(grammarAccess.getClassDeclarationAccess().getSupertypesAssignment_3_2_1(), "rule__ClassDeclaration__SupertypesAssignment_3_2_1");
					put(grammarAccess.getClassDeclarationAccess().getFieldsAssignment_4_0_1(), "rule__ClassDeclaration__FieldsAssignment_4_0_1");
					put(grammarAccess.getFieldAccess().getContainmentAssignment_0_0(), "rule__Field__ContainmentAssignment_0_0");
					put(grammarAccess.getFieldAccess().getCrossReferenceAssignment_0_1(), "rule__Field__CrossReferenceAssignment_0_1");
					put(grammarAccess.getFieldAccess().getTypeAssignment_1(), "rule__Field__TypeAssignment_1");
					put(grammarAccess.getFieldAccess().getMultiplicityAssignment_2(), "rule__Field__MultiplicityAssignment_2");
					put(grammarAccess.getFieldAccess().getNameAssignment_3(), "rule__Field__NameAssignment_3");
					put(grammarAccess.getFieldAccess().getOppositeAssignment_4_1(), "rule__Field__OppositeAssignment_4_1");
					put(grammarAccess.getExactMultiplicityAccess().getValueAssignment_1(), "rule__ExactMultiplicity__ValueAssignment_1");
					put(grammarAccess.getBoundedMultiplicityAccess().getLowerBoundAssignment_1(), "rule__BoundedMultiplicity__LowerBoundAssignment_1");
					put(grammarAccess.getBoundedMultiplicityAccess().getUpperBoundAssignment_3(), "rule__BoundedMultiplicity__UpperBoundAssignment_3");
					put(grammarAccess.getEnumDeclarationAccess().getNameAssignment_1(), "rule__EnumDeclaration__NameAssignment_1");
					put(grammarAccess.getEnumDeclarationAccess().getLiteralsAssignment_2_0_1_0(), "rule__EnumDeclaration__LiteralsAssignment_2_0_1_0");
					put(grammarAccess.getEnumDeclarationAccess().getLiteralsAssignment_2_0_1_1_1(), "rule__EnumDeclaration__LiteralsAssignment_2_0_1_1_1");
					put(grammarAccess.getEnumLiteralAccess().getNameAssignment(), "rule__EnumLiteral__NameAssignment");
					put(grammarAccess.getExactScopeAccess().getTypeAssignment_1(), "rule__ExactScope__TypeAssignment_1");
					put(grammarAccess.getExactScopeAccess().getSizeAssignment_3(), "rule__ExactScope__SizeAssignment_3");
					put(grammarAccess.getBoundedScopeAccess().getLowerBoundAssignment_1_0_0_0(), "rule__BoundedScope__LowerBoundAssignment_1_0_0_0");
					put(grammarAccess.getBoundedScopeAccess().getTypeAssignment_1_0_1(), "rule__BoundedScope__TypeAssignment_1_0_1");
					put(grammarAccess.getBoundedScopeAccess().getUpperBoundAssignment_1_0_3(), "rule__BoundedScope__UpperBoundAssignment_1_0_3");
					put(grammarAccess.getBoundedScopeAccess().getUpperBoundAssignment_1_1_0(), "rule__BoundedScope__UpperBoundAssignment_1_1_0");
					put(grammarAccess.getBoundedScopeAccess().getTypeAssignment_1_1_2(), "rule__BoundedScope__TypeAssignment_1_1_2");
					put(grammarAccess.getBoundedScopeAccess().getLowerBoundAssignment_1_1_3_1(), "rule__BoundedScope__LowerBoundAssignment_1_1_3_1");
					put(grammarAccess.getLowerBoundedScopeAccess().getLowerBoundAssignment_1_0_0(), "rule__LowerBoundedScope__LowerBoundAssignment_1_0_0");
					put(grammarAccess.getLowerBoundedScopeAccess().getTypeAssignment_1_0_2(), "rule__LowerBoundedScope__TypeAssignment_1_0_2");
					put(grammarAccess.getLowerBoundedScopeAccess().getTypeAssignment_1_1_0(), "rule__LowerBoundedScope__TypeAssignment_1_1_0");
					put(grammarAccess.getLowerBoundedScopeAccess().getLowerBoundAssignment_1_1_2(), "rule__LowerBoundedScope__LowerBoundAssignment_1_1_2");
					put(grammarAccess.getObjectiveDeclarationAccess().getKindAssignment_0(), "rule__ObjectiveDeclaration__KindAssignment_0");
					put(grammarAccess.getObjectiveDeclarationAccess().getObjectiveAssignment_1(), "rule__ObjectiveDeclaration__ObjectiveAssignment_1");
					put(grammarAccess.getExternPredicateDeclarationAccess().getUnorderedGroup_1(), "rule__ExternPredicateDeclaration__UnorderedGroup_1");
					put(grammarAccess.getClassDeclarationAccess().getUnorderedGroup_0(), "rule__ClassDeclaration__UnorderedGroup_0");
				}
			};
		}
		return nameMappings.get(element);
	}
			
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public SolverLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(SolverLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
