/**
 * generated by Xtext 2.21.0
 */
package hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl;

import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.ApplicationConfigurationPackage;
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.Config;
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.File;
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.GenerationTask;
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.GraphPattern;
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.Metamodel;
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.Objective;
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.PartialModel;
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.Scope;
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.Solver;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generation Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.GenerationTaskImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.GenerationTaskImpl#getPartialModel <em>Partial Model</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.GenerationTaskImpl#getPatterns <em>Patterns</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.GenerationTaskImpl#getObjectives <em>Objectives</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.GenerationTaskImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.GenerationTaskImpl#isNumberSpecified <em>Number Specified</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.GenerationTaskImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.GenerationTaskImpl#isRunSpecified <em>Run Specified</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.GenerationTaskImpl#getRuns <em>Runs</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.GenerationTaskImpl#getSolver <em>Solver</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.GenerationTaskImpl#getConfig <em>Config</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.GenerationTaskImpl#getDebugFolder <em>Debug Folder</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.GenerationTaskImpl#getTargetLogFile <em>Target Log File</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.GenerationTaskImpl#getTargetStatisticsFile <em>Target Statistics File</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.impl.GenerationTaskImpl#getTagetFolder <em>Taget Folder</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenerationTaskImpl extends TaskImpl implements GenerationTask
{
  /**
   * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodel()
   * @generated
   * @ordered
   */
  protected Metamodel metamodel;

  /**
   * The cached value of the '{@link #getPartialModel() <em>Partial Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartialModel()
   * @generated
   * @ordered
   */
  protected PartialModel partialModel;

  /**
   * The cached value of the '{@link #getPatterns() <em>Patterns</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPatterns()
   * @generated
   * @ordered
   */
  protected GraphPattern patterns;

  /**
   * The cached value of the '{@link #getObjectives() <em>Objectives</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjectives()
   * @generated
   * @ordered
   */
  protected Objective objectives;

  /**
   * The cached value of the '{@link #getScope() <em>Scope</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScope()
   * @generated
   * @ordered
   */
  protected Scope scope;

  /**
   * The default value of the '{@link #isNumberSpecified() <em>Number Specified</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNumberSpecified()
   * @generated
   * @ordered
   */
  protected static final boolean NUMBER_SPECIFIED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNumberSpecified() <em>Number Specified</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNumberSpecified()
   * @generated
   * @ordered
   */
  protected boolean numberSpecified = NUMBER_SPECIFIED_EDEFAULT;

  /**
   * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumber()
   * @generated
   * @ordered
   */
  protected static final int NUMBER_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumber()
   * @generated
   * @ordered
   */
  protected int number = NUMBER_EDEFAULT;

  /**
   * The default value of the '{@link #isRunSpecified() <em>Run Specified</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRunSpecified()
   * @generated
   * @ordered
   */
  protected static final boolean RUN_SPECIFIED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRunSpecified() <em>Run Specified</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRunSpecified()
   * @generated
   * @ordered
   */
  protected boolean runSpecified = RUN_SPECIFIED_EDEFAULT;

  /**
   * The default value of the '{@link #getRuns() <em>Runs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRuns()
   * @generated
   * @ordered
   */
  protected static final int RUNS_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getRuns() <em>Runs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRuns()
   * @generated
   * @ordered
   */
  protected int runs = RUNS_EDEFAULT;

  /**
   * The default value of the '{@link #getSolver() <em>Solver</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSolver()
   * @generated
   * @ordered
   */
  protected static final Solver SOLVER_EDEFAULT = Solver.SMT_SOLVER;

  /**
   * The cached value of the '{@link #getSolver() <em>Solver</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSolver()
   * @generated
   * @ordered
   */
  protected Solver solver = SOLVER_EDEFAULT;

  /**
   * The cached value of the '{@link #getConfig() <em>Config</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConfig()
   * @generated
   * @ordered
   */
  protected Config config;

  /**
   * The cached value of the '{@link #getDebugFolder() <em>Debug Folder</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDebugFolder()
   * @generated
   * @ordered
   */
  protected File debugFolder;

  /**
   * The cached value of the '{@link #getTargetLogFile() <em>Target Log File</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetLogFile()
   * @generated
   * @ordered
   */
  protected File targetLogFile;

  /**
   * The cached value of the '{@link #getTargetStatisticsFile() <em>Target Statistics File</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetStatisticsFile()
   * @generated
   * @ordered
   */
  protected File targetStatisticsFile;

  /**
   * The cached value of the '{@link #getTagetFolder() <em>Taget Folder</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTagetFolder()
   * @generated
   * @ordered
   */
  protected File tagetFolder;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GenerationTaskImpl()
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
    return ApplicationConfigurationPackage.Literals.GENERATION_TASK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Metamodel getMetamodel()
  {
    return metamodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMetamodel(Metamodel newMetamodel, NotificationChain msgs)
  {
    Metamodel oldMetamodel = metamodel;
    metamodel = newMetamodel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__METAMODEL, oldMetamodel, newMetamodel);
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
  public void setMetamodel(Metamodel newMetamodel)
  {
    if (newMetamodel != metamodel)
    {
      NotificationChain msgs = null;
      if (metamodel != null)
        msgs = ((InternalEObject)metamodel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__METAMODEL, null, msgs);
      if (newMetamodel != null)
        msgs = ((InternalEObject)newMetamodel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__METAMODEL, null, msgs);
      msgs = basicSetMetamodel(newMetamodel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__METAMODEL, newMetamodel, newMetamodel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PartialModel getPartialModel()
  {
    return partialModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPartialModel(PartialModel newPartialModel, NotificationChain msgs)
  {
    PartialModel oldPartialModel = partialModel;
    partialModel = newPartialModel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__PARTIAL_MODEL, oldPartialModel, newPartialModel);
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
  public void setPartialModel(PartialModel newPartialModel)
  {
    if (newPartialModel != partialModel)
    {
      NotificationChain msgs = null;
      if (partialModel != null)
        msgs = ((InternalEObject)partialModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__PARTIAL_MODEL, null, msgs);
      if (newPartialModel != null)
        msgs = ((InternalEObject)newPartialModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__PARTIAL_MODEL, null, msgs);
      msgs = basicSetPartialModel(newPartialModel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__PARTIAL_MODEL, newPartialModel, newPartialModel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GraphPattern getPatterns()
  {
    return patterns;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPatterns(GraphPattern newPatterns, NotificationChain msgs)
  {
    GraphPattern oldPatterns = patterns;
    patterns = newPatterns;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__PATTERNS, oldPatterns, newPatterns);
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
  public void setPatterns(GraphPattern newPatterns)
  {
    if (newPatterns != patterns)
    {
      NotificationChain msgs = null;
      if (patterns != null)
        msgs = ((InternalEObject)patterns).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__PATTERNS, null, msgs);
      if (newPatterns != null)
        msgs = ((InternalEObject)newPatterns).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__PATTERNS, null, msgs);
      msgs = basicSetPatterns(newPatterns, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__PATTERNS, newPatterns, newPatterns));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Objective getObjectives()
  {
    return objectives;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetObjectives(Objective newObjectives, NotificationChain msgs)
  {
    Objective oldObjectives = objectives;
    objectives = newObjectives;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__OBJECTIVES, oldObjectives, newObjectives);
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
  public void setObjectives(Objective newObjectives)
  {
    if (newObjectives != objectives)
    {
      NotificationChain msgs = null;
      if (objectives != null)
        msgs = ((InternalEObject)objectives).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__OBJECTIVES, null, msgs);
      if (newObjectives != null)
        msgs = ((InternalEObject)newObjectives).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__OBJECTIVES, null, msgs);
      msgs = basicSetObjectives(newObjectives, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__OBJECTIVES, newObjectives, newObjectives));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Scope getScope()
  {
    return scope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetScope(Scope newScope, NotificationChain msgs)
  {
    Scope oldScope = scope;
    scope = newScope;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__SCOPE, oldScope, newScope);
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
  public void setScope(Scope newScope)
  {
    if (newScope != scope)
    {
      NotificationChain msgs = null;
      if (scope != null)
        msgs = ((InternalEObject)scope).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__SCOPE, null, msgs);
      if (newScope != null)
        msgs = ((InternalEObject)newScope).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__SCOPE, null, msgs);
      msgs = basicSetScope(newScope, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__SCOPE, newScope, newScope));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isNumberSpecified()
  {
    return numberSpecified;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNumberSpecified(boolean newNumberSpecified)
  {
    boolean oldNumberSpecified = numberSpecified;
    numberSpecified = newNumberSpecified;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__NUMBER_SPECIFIED, oldNumberSpecified, numberSpecified));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getNumber()
  {
    return number;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNumber(int newNumber)
  {
    int oldNumber = number;
    number = newNumber;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__NUMBER, oldNumber, number));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isRunSpecified()
  {
    return runSpecified;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRunSpecified(boolean newRunSpecified)
  {
    boolean oldRunSpecified = runSpecified;
    runSpecified = newRunSpecified;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__RUN_SPECIFIED, oldRunSpecified, runSpecified));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getRuns()
  {
    return runs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRuns(int newRuns)
  {
    int oldRuns = runs;
    runs = newRuns;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__RUNS, oldRuns, runs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Solver getSolver()
  {
    return solver;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSolver(Solver newSolver)
  {
    Solver oldSolver = solver;
    solver = newSolver == null ? SOLVER_EDEFAULT : newSolver;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__SOLVER, oldSolver, solver));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Config getConfig()
  {
    return config;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConfig(Config newConfig, NotificationChain msgs)
  {
    Config oldConfig = config;
    config = newConfig;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__CONFIG, oldConfig, newConfig);
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
  public void setConfig(Config newConfig)
  {
    if (newConfig != config)
    {
      NotificationChain msgs = null;
      if (config != null)
        msgs = ((InternalEObject)config).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__CONFIG, null, msgs);
      if (newConfig != null)
        msgs = ((InternalEObject)newConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__CONFIG, null, msgs);
      msgs = basicSetConfig(newConfig, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__CONFIG, newConfig, newConfig));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public File getDebugFolder()
  {
    return debugFolder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDebugFolder(File newDebugFolder, NotificationChain msgs)
  {
    File oldDebugFolder = debugFolder;
    debugFolder = newDebugFolder;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__DEBUG_FOLDER, oldDebugFolder, newDebugFolder);
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
  public void setDebugFolder(File newDebugFolder)
  {
    if (newDebugFolder != debugFolder)
    {
      NotificationChain msgs = null;
      if (debugFolder != null)
        msgs = ((InternalEObject)debugFolder).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__DEBUG_FOLDER, null, msgs);
      if (newDebugFolder != null)
        msgs = ((InternalEObject)newDebugFolder).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__DEBUG_FOLDER, null, msgs);
      msgs = basicSetDebugFolder(newDebugFolder, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__DEBUG_FOLDER, newDebugFolder, newDebugFolder));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public File getTargetLogFile()
  {
    return targetLogFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTargetLogFile(File newTargetLogFile, NotificationChain msgs)
  {
    File oldTargetLogFile = targetLogFile;
    targetLogFile = newTargetLogFile;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__TARGET_LOG_FILE, oldTargetLogFile, newTargetLogFile);
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
  public void setTargetLogFile(File newTargetLogFile)
  {
    if (newTargetLogFile != targetLogFile)
    {
      NotificationChain msgs = null;
      if (targetLogFile != null)
        msgs = ((InternalEObject)targetLogFile).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__TARGET_LOG_FILE, null, msgs);
      if (newTargetLogFile != null)
        msgs = ((InternalEObject)newTargetLogFile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__TARGET_LOG_FILE, null, msgs);
      msgs = basicSetTargetLogFile(newTargetLogFile, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__TARGET_LOG_FILE, newTargetLogFile, newTargetLogFile));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public File getTargetStatisticsFile()
  {
    return targetStatisticsFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTargetStatisticsFile(File newTargetStatisticsFile, NotificationChain msgs)
  {
    File oldTargetStatisticsFile = targetStatisticsFile;
    targetStatisticsFile = newTargetStatisticsFile;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__TARGET_STATISTICS_FILE, oldTargetStatisticsFile, newTargetStatisticsFile);
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
  public void setTargetStatisticsFile(File newTargetStatisticsFile)
  {
    if (newTargetStatisticsFile != targetStatisticsFile)
    {
      NotificationChain msgs = null;
      if (targetStatisticsFile != null)
        msgs = ((InternalEObject)targetStatisticsFile).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__TARGET_STATISTICS_FILE, null, msgs);
      if (newTargetStatisticsFile != null)
        msgs = ((InternalEObject)newTargetStatisticsFile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__TARGET_STATISTICS_FILE, null, msgs);
      msgs = basicSetTargetStatisticsFile(newTargetStatisticsFile, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__TARGET_STATISTICS_FILE, newTargetStatisticsFile, newTargetStatisticsFile));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public File getTagetFolder()
  {
    return tagetFolder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTagetFolder(File newTagetFolder, NotificationChain msgs)
  {
    File oldTagetFolder = tagetFolder;
    tagetFolder = newTagetFolder;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__TAGET_FOLDER, oldTagetFolder, newTagetFolder);
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
  public void setTagetFolder(File newTagetFolder)
  {
    if (newTagetFolder != tagetFolder)
    {
      NotificationChain msgs = null;
      if (tagetFolder != null)
        msgs = ((InternalEObject)tagetFolder).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__TAGET_FOLDER, null, msgs);
      if (newTagetFolder != null)
        msgs = ((InternalEObject)newTagetFolder).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationConfigurationPackage.GENERATION_TASK__TAGET_FOLDER, null, msgs);
      msgs = basicSetTagetFolder(newTagetFolder, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApplicationConfigurationPackage.GENERATION_TASK__TAGET_FOLDER, newTagetFolder, newTagetFolder));
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
      case ApplicationConfigurationPackage.GENERATION_TASK__METAMODEL:
        return basicSetMetamodel(null, msgs);
      case ApplicationConfigurationPackage.GENERATION_TASK__PARTIAL_MODEL:
        return basicSetPartialModel(null, msgs);
      case ApplicationConfigurationPackage.GENERATION_TASK__PATTERNS:
        return basicSetPatterns(null, msgs);
      case ApplicationConfigurationPackage.GENERATION_TASK__OBJECTIVES:
        return basicSetObjectives(null, msgs);
      case ApplicationConfigurationPackage.GENERATION_TASK__SCOPE:
        return basicSetScope(null, msgs);
      case ApplicationConfigurationPackage.GENERATION_TASK__CONFIG:
        return basicSetConfig(null, msgs);
      case ApplicationConfigurationPackage.GENERATION_TASK__DEBUG_FOLDER:
        return basicSetDebugFolder(null, msgs);
      case ApplicationConfigurationPackage.GENERATION_TASK__TARGET_LOG_FILE:
        return basicSetTargetLogFile(null, msgs);
      case ApplicationConfigurationPackage.GENERATION_TASK__TARGET_STATISTICS_FILE:
        return basicSetTargetStatisticsFile(null, msgs);
      case ApplicationConfigurationPackage.GENERATION_TASK__TAGET_FOLDER:
        return basicSetTagetFolder(null, msgs);
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
      case ApplicationConfigurationPackage.GENERATION_TASK__METAMODEL:
        return getMetamodel();
      case ApplicationConfigurationPackage.GENERATION_TASK__PARTIAL_MODEL:
        return getPartialModel();
      case ApplicationConfigurationPackage.GENERATION_TASK__PATTERNS:
        return getPatterns();
      case ApplicationConfigurationPackage.GENERATION_TASK__OBJECTIVES:
        return getObjectives();
      case ApplicationConfigurationPackage.GENERATION_TASK__SCOPE:
        return getScope();
      case ApplicationConfigurationPackage.GENERATION_TASK__NUMBER_SPECIFIED:
        return isNumberSpecified();
      case ApplicationConfigurationPackage.GENERATION_TASK__NUMBER:
        return getNumber();
      case ApplicationConfigurationPackage.GENERATION_TASK__RUN_SPECIFIED:
        return isRunSpecified();
      case ApplicationConfigurationPackage.GENERATION_TASK__RUNS:
        return getRuns();
      case ApplicationConfigurationPackage.GENERATION_TASK__SOLVER:
        return getSolver();
      case ApplicationConfigurationPackage.GENERATION_TASK__CONFIG:
        return getConfig();
      case ApplicationConfigurationPackage.GENERATION_TASK__DEBUG_FOLDER:
        return getDebugFolder();
      case ApplicationConfigurationPackage.GENERATION_TASK__TARGET_LOG_FILE:
        return getTargetLogFile();
      case ApplicationConfigurationPackage.GENERATION_TASK__TARGET_STATISTICS_FILE:
        return getTargetStatisticsFile();
      case ApplicationConfigurationPackage.GENERATION_TASK__TAGET_FOLDER:
        return getTagetFolder();
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
      case ApplicationConfigurationPackage.GENERATION_TASK__METAMODEL:
        setMetamodel((Metamodel)newValue);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__PARTIAL_MODEL:
        setPartialModel((PartialModel)newValue);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__PATTERNS:
        setPatterns((GraphPattern)newValue);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__OBJECTIVES:
        setObjectives((Objective)newValue);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__SCOPE:
        setScope((Scope)newValue);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__NUMBER_SPECIFIED:
        setNumberSpecified((Boolean)newValue);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__NUMBER:
        setNumber((Integer)newValue);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__RUN_SPECIFIED:
        setRunSpecified((Boolean)newValue);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__RUNS:
        setRuns((Integer)newValue);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__SOLVER:
        setSolver((Solver)newValue);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__CONFIG:
        setConfig((Config)newValue);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__DEBUG_FOLDER:
        setDebugFolder((File)newValue);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__TARGET_LOG_FILE:
        setTargetLogFile((File)newValue);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__TARGET_STATISTICS_FILE:
        setTargetStatisticsFile((File)newValue);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__TAGET_FOLDER:
        setTagetFolder((File)newValue);
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
      case ApplicationConfigurationPackage.GENERATION_TASK__METAMODEL:
        setMetamodel((Metamodel)null);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__PARTIAL_MODEL:
        setPartialModel((PartialModel)null);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__PATTERNS:
        setPatterns((GraphPattern)null);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__OBJECTIVES:
        setObjectives((Objective)null);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__SCOPE:
        setScope((Scope)null);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__NUMBER_SPECIFIED:
        setNumberSpecified(NUMBER_SPECIFIED_EDEFAULT);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__NUMBER:
        setNumber(NUMBER_EDEFAULT);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__RUN_SPECIFIED:
        setRunSpecified(RUN_SPECIFIED_EDEFAULT);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__RUNS:
        setRuns(RUNS_EDEFAULT);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__SOLVER:
        setSolver(SOLVER_EDEFAULT);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__CONFIG:
        setConfig((Config)null);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__DEBUG_FOLDER:
        setDebugFolder((File)null);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__TARGET_LOG_FILE:
        setTargetLogFile((File)null);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__TARGET_STATISTICS_FILE:
        setTargetStatisticsFile((File)null);
        return;
      case ApplicationConfigurationPackage.GENERATION_TASK__TAGET_FOLDER:
        setTagetFolder((File)null);
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
      case ApplicationConfigurationPackage.GENERATION_TASK__METAMODEL:
        return metamodel != null;
      case ApplicationConfigurationPackage.GENERATION_TASK__PARTIAL_MODEL:
        return partialModel != null;
      case ApplicationConfigurationPackage.GENERATION_TASK__PATTERNS:
        return patterns != null;
      case ApplicationConfigurationPackage.GENERATION_TASK__OBJECTIVES:
        return objectives != null;
      case ApplicationConfigurationPackage.GENERATION_TASK__SCOPE:
        return scope != null;
      case ApplicationConfigurationPackage.GENERATION_TASK__NUMBER_SPECIFIED:
        return numberSpecified != NUMBER_SPECIFIED_EDEFAULT;
      case ApplicationConfigurationPackage.GENERATION_TASK__NUMBER:
        return number != NUMBER_EDEFAULT;
      case ApplicationConfigurationPackage.GENERATION_TASK__RUN_SPECIFIED:
        return runSpecified != RUN_SPECIFIED_EDEFAULT;
      case ApplicationConfigurationPackage.GENERATION_TASK__RUNS:
        return runs != RUNS_EDEFAULT;
      case ApplicationConfigurationPackage.GENERATION_TASK__SOLVER:
        return solver != SOLVER_EDEFAULT;
      case ApplicationConfigurationPackage.GENERATION_TASK__CONFIG:
        return config != null;
      case ApplicationConfigurationPackage.GENERATION_TASK__DEBUG_FOLDER:
        return debugFolder != null;
      case ApplicationConfigurationPackage.GENERATION_TASK__TARGET_LOG_FILE:
        return targetLogFile != null;
      case ApplicationConfigurationPackage.GENERATION_TASK__TARGET_STATISTICS_FILE:
        return targetStatisticsFile != null;
      case ApplicationConfigurationPackage.GENERATION_TASK__TAGET_FOLDER:
        return tagetFolder != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (numberSpecified: ");
    result.append(numberSpecified);
    result.append(", number: ");
    result.append(number);
    result.append(", runSpecified: ");
    result.append(runSpecified);
    result.append(", runs: ");
    result.append(runs);
    result.append(", solver: ");
    result.append(solver);
    result.append(')');
    return result.toString();
  }

} //GenerationTaskImpl
