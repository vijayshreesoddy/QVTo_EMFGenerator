/**
 */
package hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.NumericOperation#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.NumericOperation#getRightOperand <em>Right Operand</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.LogiclanguagePackage#getNumericOperation()
 * @model abstract="true"
 * @generated
 */
public interface NumericOperation extends Term {
	/**
	 * Returns the value of the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Operand</em>' containment reference.
	 * @see #setLeftOperand(Term)
	 * @see hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.LogiclanguagePackage#getNumericOperation_LeftOperand()
	 * @model containment="true"
	 * @generated
	 */
	Term getLeftOperand();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.NumericOperation#getLeftOperand <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Operand</em>' containment reference.
	 * @see #getLeftOperand()
	 * @generated
	 */
	void setLeftOperand(Term value);

	/**
	 * Returns the value of the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Operand</em>' containment reference.
	 * @see #setRightOperand(Term)
	 * @see hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.LogiclanguagePackage#getNumericOperation_RightOperand()
	 * @model containment="true"
	 * @generated
	 */
	Term getRightOperand();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.NumericOperation#getRightOperand <em>Right Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Operand</em>' containment reference.
	 * @see #getRightOperand()
	 * @generated
	 */
	void setRightOperand(Term value);

} // NumericOperation
