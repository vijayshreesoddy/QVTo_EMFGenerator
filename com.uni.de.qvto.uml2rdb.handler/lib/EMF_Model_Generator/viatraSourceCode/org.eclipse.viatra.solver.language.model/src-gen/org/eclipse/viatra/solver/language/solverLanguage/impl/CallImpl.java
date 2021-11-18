/**
 */
package org.eclipse.viatra.solver.language.solverLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.viatra.solver.language.solverLanguage.ArgumentList;
import org.eclipse.viatra.solver.language.solverLanguage.Call;
import org.eclipse.viatra.solver.language.solverLanguage.Reference;
import org.eclipse.viatra.solver.language.solverLanguage.SolverLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.solver.language.solverLanguage.impl.CallImpl#getFunctor <em>Functor</em>}</li>
 *   <li>{@link org.eclipse.viatra.solver.language.solverLanguage.impl.CallImpl#getArgumentList <em>Argument List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CallImpl extends ExpressionImpl implements Call {
	/**
	 * The cached value of the '{@link #getFunctor() <em>Functor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctor()
	 * @generated
	 * @ordered
	 */
	protected Reference functor;

	/**
	 * The cached value of the '{@link #getArgumentList() <em>Argument List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgumentList()
	 * @generated
	 * @ordered
	 */
	protected ArgumentList argumentList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolverLanguagePackage.Literals.CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference getFunctor() {
		return functor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunctor(Reference newFunctor, NotificationChain msgs) {
		Reference oldFunctor = functor;
		functor = newFunctor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					SolverLanguagePackage.CALL__FUNCTOR, oldFunctor, newFunctor);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctor(Reference newFunctor) {
		if (newFunctor != functor) {
			NotificationChain msgs = null;
			if (functor != null)
				msgs = ((InternalEObject) functor).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - SolverLanguagePackage.CALL__FUNCTOR, null, msgs);
			if (newFunctor != null)
				msgs = ((InternalEObject) newFunctor).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - SolverLanguagePackage.CALL__FUNCTOR, null, msgs);
			msgs = basicSetFunctor(newFunctor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolverLanguagePackage.CALL__FUNCTOR, newFunctor,
					newFunctor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArgumentList getArgumentList() {
		return argumentList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArgumentList(ArgumentList newArgumentList, NotificationChain msgs) {
		ArgumentList oldArgumentList = argumentList;
		argumentList = newArgumentList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					SolverLanguagePackage.CALL__ARGUMENT_LIST, oldArgumentList, newArgumentList);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgumentList(ArgumentList newArgumentList) {
		if (newArgumentList != argumentList) {
			NotificationChain msgs = null;
			if (argumentList != null)
				msgs = ((InternalEObject) argumentList).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - SolverLanguagePackage.CALL__ARGUMENT_LIST, null, msgs);
			if (newArgumentList != null)
				msgs = ((InternalEObject) newArgumentList).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - SolverLanguagePackage.CALL__ARGUMENT_LIST, null, msgs);
			msgs = basicSetArgumentList(newArgumentList, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolverLanguagePackage.CALL__ARGUMENT_LIST,
					newArgumentList, newArgumentList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SolverLanguagePackage.CALL__FUNCTOR:
			return basicSetFunctor(null, msgs);
		case SolverLanguagePackage.CALL__ARGUMENT_LIST:
			return basicSetArgumentList(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SolverLanguagePackage.CALL__FUNCTOR:
			return getFunctor();
		case SolverLanguagePackage.CALL__ARGUMENT_LIST:
			return getArgumentList();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SolverLanguagePackage.CALL__FUNCTOR:
			setFunctor((Reference) newValue);
			return;
		case SolverLanguagePackage.CALL__ARGUMENT_LIST:
			setArgumentList((ArgumentList) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SolverLanguagePackage.CALL__FUNCTOR:
			setFunctor((Reference) null);
			return;
		case SolverLanguagePackage.CALL__ARGUMENT_LIST:
			setArgumentList((ArgumentList) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SolverLanguagePackage.CALL__FUNCTOR:
			return functor != null;
		case SolverLanguagePackage.CALL__ARGUMENT_LIST:
			return argumentList != null;
		}
		return super.eIsSet(featureID);
	}

} //CallImpl
