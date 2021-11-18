package com.uni.de.qvto.uml2rdb.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class ModelCreater {
	private final static String ECLASS = "TaggedValue,Package,Class,Association,Enumeration,EnumerationLiteral,Generalization,PrimitiveType,Property";
	private final static int MAX_SIZE =  400;
	
	public static void createModel() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		
		
		ResourceSet resourceSet = new ResourceSetImpl();
		EPackage simpleuml = (EPackage) resourceSet.getResource(URI.createURI("file:////Users/vijayshree/QVTo_BB_04_07_2019/com.uni.de.qvto.uml2rdb/SimpleUML.ecore"), true).getContents().get(0);
        EPackage.Registry.INSTANCE.put(simpleuml.getNsURI(), simpleuml);

		Resource inResource = resourceSet.getResource(
				
	    URI.createURI("file:////Users/vijayshree/QVTo_BB_04_02_2021/com.uni.de.qvto.uml2rdb/pim.simpleuml"), true);		
		EList<EObject> inObjects = inResource.getContents();
		//copyElements(inResource);
		createElements(inResource);
		
		List<EObject> outObjects = inResource.getContents();
		// let's persist them using a resource 
		Resource outResource = resourceSet.createResource(
				URI.createURI("file:////Users/vijayshree/QVToProfiler-master-2-09-2021/com.uni.de.qvto.uml2rdb/inputUML.simpleuml"));
		outResource.getContents().addAll(outObjects);
		try {
			outResource.save(Collections.emptyMap());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			// check the result for success
	}
	
	private static Map<String, List<EObject>> getEObjectsMap(Resource inResource) {
		Map<String, List<EObject>> className2EObject = new HashMap<String, List<EObject>>();
		TreeIterator<Object> childObjects = EcoreUtil.getAllContents(inResource, true);
		while (childObjects.hasNext()) {
		    EObject sourceElement = (EObject) childObjects.next();
		    String key = sourceElement.eClass().getName();
		    List<EObject> eObjects = className2EObject.get(key);
		    if(eObjects==null) {
		    	eObjects = new ArrayList<EObject>();
		    	className2EObject.put(key, eObjects);
		    }
		    eObjects.add(sourceElement);
		    
		}
		return className2EObject;
		
	}
	
	private static void createElements(Resource inResource) {
		Map<String, List<EObject>> className2EObject = getEObjectsMap(inResource);
		Map<String, String> modelMap = getModelMap();
		Set<String> keySet = modelMap.keySet();
		for (String key : keySet) {
			String eClassName = modelMap.get(key);
			System.out.println("key is-----"+key);
			int numGen = Integer.parseInt(modelMap.get(key));
			List<EObject> eObjectList = className2EObject.get(key);
			if(eObjectList!=null)
			generateModelElement(numGen, eObjectList);
		}
		
	}
	private static void generateModelElement(int numGen, List<EObject> eObjectList) {
		int i =0;
		while(numGen>0) {
			if(i>eObjectList.size()-1) {
				i=0;
			}
			EObject eObject = eObjectList.get(i);
			numGen--;
			i++;
			copyElements(eObject, numGen);
		}
	}
	
	private static void copyElements(EObject sourceElement, int index) {
		String instanceName = getName(sourceElement);
		
		EObject cloneObject = EcoreUtil.copy(sourceElement);
		setName(cloneObject, instanceName+index);
		//EObject container = sourceElement.eContainer();
		EObject container = EMFCloneObjects.INSTANCE.getRandomEObject(sourceElement);
		    if (container != null) {
		        Object parentFeatureValue = container.eGet(sourceElement.eContainingFeature());
		        if (parentFeatureValue instanceof EList<?>) {
		            //			int index = ((EList) parentFeatureValue).indexOf(sourceElement);
		            // Add the new element at the same place than the older one
		            // ((EList) parentFeatureValue).set(((EList)
		            // parentFeatureValue).indexOf(sourceElement), targetElement);
		            ((EList) parentFeatureValue).add(/* index, */cloneObject);
		        } else {
		            container.eSet(sourceElement.eContainingFeature(), cloneObject);
		        }
		    }
			EcoreUtil.deleteAll(cloneObject.eContents(), true);
			EMFCloneObjects.INSTANCE.addClonedObjects(cloneObject);

	}

	private static void copyElements(Resource inResource) {
		TreeIterator<Object> childObjects = EcoreUtil.getAllContents(inResource, true);
	    int i = 0;

		while (childObjects.hasNext()) {
		    EObject sourceElement = (EObject) childObjects.next();
			System.out.println("Root Name---"+sourceElement.eClass().getName());
		  //  System.out.println("Instance Name---"+sourceElement.eContainingFeature().getName());
			String instanceName = getName(sourceElement);

		    System.out.println("Instance Name---"+ instanceName);

			if(sourceElement.eClass().getName().equalsIgnoreCase("Class")) {
			
				EObject cloneObject = EcoreUtil.copy(sourceElement);
				setName(cloneObject, instanceName+i);
				i++;

				 EObject container = sourceElement.eContainer();
				    if (container != null) {
				        Object parentFeatureValue = container.eGet(sourceElement.eContainingFeature());
				        if (parentFeatureValue instanceof EList<?>) {
				            //			int index = ((EList) parentFeatureValue).indexOf(sourceElement);
				            // Add the new element at the same place than the older one
				            // ((EList) parentFeatureValue).set(((EList)
				            // parentFeatureValue).indexOf(sourceElement), targetElement);
				            ((EList) parentFeatureValue).add(/* index, */cloneObject);
				        } else {
				            container.eSet(sourceElement.eContainingFeature(), cloneObject);
				        }
				    }
					EcoreUtil.deleteAll(cloneObject.eContents(), true);

			}

		  }
	}
	
	private static String getName(EObject eObject)
	  {
	    EStructuralFeature nameFeature = eObject.eClass().getEStructuralFeature("name");
	    if (nameFeature instanceof EAttribute && !nameFeature.isMany())
	    {
	      EAttribute nameAttribute = (EAttribute)nameFeature;
	      Object nameValue = eObject.eGet(nameFeature);
	      return EcoreUtil.convertToString(nameAttribute.getEAttributeType(), nameValue);
	    }
	    return null;
	  }
	
	private static void setName(EObject eObject, String newValue)
	  {
	    EStructuralFeature nameFeature = eObject.eClass().getEStructuralFeature("name");
	    if (nameFeature instanceof EAttribute && !nameFeature.isMany())
	    {
	      EAttribute nameAttribute = (EAttribute)nameFeature;
	      eObject.eSet(nameFeature, newValue);
	    }
	  }

	private static Map<String, String> getModelMap() {
		Map<String, String> modelMap = new LinkedHashMap<String, String>();
		Random randGen = new Random();
		String[] classArray = ECLASS.split(",");
		int [] randNumbers = ModelGeneratorUtils.n_random(classArray.length, MAX_SIZE);		
		for (int i = 0; i < classArray.length; i++) {
			System.out.println("Added Kex is---"+classArray[i]);
			modelMap.put(classArray[i], String.valueOf(randNumbers[i]));
		}
		return modelMap;
		
		
	}
	
}
