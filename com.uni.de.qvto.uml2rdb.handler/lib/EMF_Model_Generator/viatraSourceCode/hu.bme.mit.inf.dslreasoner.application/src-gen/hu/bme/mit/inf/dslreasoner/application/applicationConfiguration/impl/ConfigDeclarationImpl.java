/**
 * generated by Xtext 2.21.0
 */
package hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl;

import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.ApplicationConfigurationPackage;
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.ConfigDeclaration;
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.ConfigSpecification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.ConfigDeclarationImpl#getSpecification <em>Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigDeclarationImpl extends DeclarationImpl implements ConfigDeclaration
{
  /**
   * The cached value of the '{@link #getSpecification() <em>Specification</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecification()
   * @generated
   * @ordered
   */
  protected ConfigSpecification specification;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConfigDeclarationImpl()
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
    return ApplicationConfigurationPackage.Literals.CONFIG_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConfigSpecification getSpecification()
  {
    return specification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSpecification(ConfigSpecification newSpecification, NotificationChain msgs)
  {
    ConfigSpecification oldSpecification = specification;
    specification = newSpecification;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.CONFIG_DECLARATION__SPECIFICATION, oldSpecification, newSpecification);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSpecification(ConfigSpecification newSpecification)
  {
    if (newSpecification != specification)
    {
      NotificationChain msgs = null;
      if (specification != null)
        msgs = ((InternalEObject)specification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.CONFIG_DECLARATION__SPECIFICATION, null, msgs);
      if (newSpecification != null)
        msgs = ((InternalEObject)newSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.CONFIG_DECLARATION__SPECIFICATION, null, msgs);
      msgs = basicSetSpecification(newSpecification, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.CONFIG_DECLARATION__SPECIFICATION, newSpecification, newSpecification));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ApplicationConfigurationPackage.CONFIG_DECLARATION__SPECIFICATION:
        return basicSetSpecification(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case ApplicationConfigurationPackage.CONFIG_DECLARATION__SPECIFICATION:
        return getSpecification();
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
      case ApplicationConfigurationPackage.CONFIG_DECLARATION__SPECIFICATION:
        setSpecification((ConfigSpecification)newValue);
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
      case ApplicationConfigurationPackage.CONFIG_DECLARATION__SPECIFICATION:
        setSpecification((ConfigSpecification)null);
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
      case ApplicationConfigurationPackage.CONFIG_DECLARATION__SPECIFICATION:
        return specification != null;
    }
    return super.eIsSet(featureID);
  }

} //ConfigDeclarationImpl
