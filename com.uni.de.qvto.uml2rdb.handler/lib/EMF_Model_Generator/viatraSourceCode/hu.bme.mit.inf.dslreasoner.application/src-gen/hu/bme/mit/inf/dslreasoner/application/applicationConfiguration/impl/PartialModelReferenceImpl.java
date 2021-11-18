/**
 * generated by Xtext 2.21.0
 */
package hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl;

import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.ApplicationConfigurationPackage;
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.PartialModelDeclaration;
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.PartialModelReference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partial Model Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.PartialModelReferenceImpl#getReferred <em>Referred</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PartialModelReferenceImpl extends PartialModelImpl implements PartialModelReference
{
  /**
   * The cached value of the '{@link #getReferred() <em>Referred</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferred()
   * @generated
   * @ordered
   */
  protected PartialModelDeclaration referred;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PartialModelReferenceImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ApplicationConfigurationPackage.Literals.PARTIAL_MODEL_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PartialModelDeclaration getReferred()
  {
    if (referred != null && referred.eIsProxy())
    {
      InternalEObject oldReferred = (InternalEObject)referred;
      referred = (PartialModelDeclaration)eResolveProxy(oldReferred);
      if (referred != oldReferred)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationConfigurationPackage.PARTIAL_MODEL_REFERENCE__REFERRED, oldReferred, referred));
      }
    }
    return referred;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartialModelDeclaration basicGetReferred()
  {
    return referred;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setReferred(PartialModelDeclaration newReferred)
  {
    PartialModelDeclaration oldReferred = referred;
    referred = newReferred;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.PARTIAL_MODEL_REFERENCE__REFERRED, oldReferred, referred));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ApplicationConfigurationPackage.PARTIAL_MODEL_REFERENCE__REFERRED:
        if (resolve) return getReferred();
        return basicGetReferred();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ApplicationConfigurationPackage.PARTIAL_MODEL_REFERENCE__REFERRED:
        setReferred((PartialModelDeclaration)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ApplicationConfigurationPackage.PARTIAL_MODEL_REFERENCE__REFERRED:
        setReferred((PartialModelDeclaration)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ApplicationConfigurationPackage.PARTIAL_MODEL_REFERENCE__REFERRED:
        return referred != null;
    }
    return super.eIsSet(featureID);
  }

} //PartialModelReferenceImpl