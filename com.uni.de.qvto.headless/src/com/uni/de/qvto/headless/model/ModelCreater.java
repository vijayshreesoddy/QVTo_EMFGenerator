package com.uni.de.qvto.headless.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;



public class ModelCreater {
	private final static String ECLASS = "TaggedValue,Package,Class,Association,Enumeration,EnumerationLiteral,Generalization,PrimitiveType,Property";
	private final static int MAX_SIZE =  300;
	
	public static Resource createModel(ResourceSet resourceSet,Resource inResource, String genModel, String numberofElements, String eClass) {
		//copyElements(inResource);
		EMFCloneObjects.INSTANCE.clear();
		createElements(inResource, eClass, numberofElements);
		
		List<EObject> outObjects = inResource.getContents();
		// let's persist them using a resource 
		Resource outResource = resourceSet.createResource(
				URI.createFileURI(genModel));
		System.out.println("GenModelPath---"+genModel);
		outResource.getContents().addAll(outObjects);
		try {
			outResource.save(Collections.emptyMap());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outResource;

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
	
	private static void createElements(Resource inResource, String eClass, String numberofElements) {
		Map<String, List<EObject>> className2EObject = getEObjectsMap(inResource);
		Map<String, String> modelMap = getModelMap(eClass, numberofElements);
		Set<String> keySet = modelMap.keySet();
		for (String key : keySet) {
			String eClassName = modelMap.get(key);
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

	private static Map<String, String> getModelMap(String eClass, String numberofElements) {
		Map<String, String> modelMap = new LinkedHashMap<String, String>();
		String[] classArray = eClass.split(",");
		int [] randNumbers = ModelGeneratorUtils.n_random(classArray.length, Integer.parseInt(numberofElements));		
		for (int i = 0; i < classArray.length; i++) {
			modelMap.put(classArray[i], String.valueOf(randNumbers[i]));
		}
		return modelMap;
		
		
	}
	
}
