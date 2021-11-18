/**
 */
package org.eclipse.viatra.solver.language.solverLanguage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.solver.language.solverLanguage.StringLiteral#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.viatra.solver.language.solverLanguage.SolverLanguagePackage#getStringLiteral()
 * @model
 * @generated
 */
public interface StringLiteral extends Literal {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.viatra.solver.language.solverLanguage.SolverLanguagePackage#getStringLiteral_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.solver.language.solverLanguage.StringLiteral#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // StringLiteral
