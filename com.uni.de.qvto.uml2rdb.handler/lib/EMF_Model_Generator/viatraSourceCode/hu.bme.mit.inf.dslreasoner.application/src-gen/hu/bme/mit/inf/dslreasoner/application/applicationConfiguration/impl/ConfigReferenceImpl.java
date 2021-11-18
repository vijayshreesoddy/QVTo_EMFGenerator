/**
 * generated by Xtext 2.21.0
 */
package hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl;

import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.ApplicationConfigurationPackage;
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.ConfigDeclaration;
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.ConfigReference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.ConfigReferenceImpl#getConfig <em>Config</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigReferenceImpl extends ConfigImpl implements ConfigReference
{
  /**
   * The cached value of the '{@link #getConfig() <em>Config</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConfig()
   * @generated
   * @ordered
   */
  protected ConfigDeclaration config;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConfigReferenceImpl()
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
    return ApplicationConfigurationPackage.Literals.CONFIG_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConfigDeclaration getConfig()
  {
    if (config != null && config.eIsProxy())
    {
      InternalEObject oldConfig = (InternalEObject)config;
      config = (ConfigDeclaration)eResolveProxy(oldConfig);
      if (config != oldConfig)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationConfigurationPackage.CONFIG_REFERENCE__CONFIG, oldConfig, config));
      }
    }
    return config;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConfigDeclaration basicGetConfig()
  {
    return config;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setConfig(ConfigDeclaration newConfig)
  {
    ConfigDeclaration oldConfig = config;
    config = newConfig;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.CONFIG_REFERENCE__CONFIG, oldConfig, config));
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
      case ApplicationConfigurationPackage.CONFIG_REFERENCE__CONFIG:
        if (resolve) return getConfig();
        return basicGetConfig();
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
      case ApplicationConfigurationPackage.CONFIG_REFERENCE__CONFIG:
        setConfig((ConfigDeclaration)newValue);
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
      case ApplicationConfigurationPackage.CONFIG_REFERENCE__CONFIG:
        setConfig((ConfigDeclaration)null);
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
      case ApplicationConfigurationPackage.CONFIG_REFERENCE__CONFIG:
        return config != null;
    }
    return super.eIsSet(featureID);
  }

} //ConfigReferenceImpl
