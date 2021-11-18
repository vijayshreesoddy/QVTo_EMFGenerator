package com.uni.de.qvto.uml2rdb.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.eclipse.emf.ecore.EObject;

public enum EMFCloneObjects {
	    INSTANCE;
		private Map<String, List<EObject>> className2EObject;

	    private EMFCloneObjects() {
	    	className2EObject = new HashMap<String, List<EObject>>();
	    }
	    public void addClonedObjects(EObject clonedObject) {
			String key = clonedObject.eClass().getName();
		    List<EObject> eObjects = className2EObject.get(key);
		    if(eObjects==null) {
		    	eObjects = new ArrayList<EObject>();
		    	className2EObject.put(key, eObjects);
		    }
		    eObjects.add(clonedObject);
		} 
	    
	    public EObject getRandomEObject(EObject clonedObject) {
			EObject container = clonedObject.eContainer();
			String key = container.eClass().getName();
			List<EObject> eObjectList = className2EObject.get(key);
			if(eObjectList!=null && eObjectList.size()>1) {
				Random randNum = new Random();
				int index = randNum.nextInt(eObjectList.size()-1)+1;
				return eObjectList.get(index-1);
				
			}
			return container;
		} 
}
