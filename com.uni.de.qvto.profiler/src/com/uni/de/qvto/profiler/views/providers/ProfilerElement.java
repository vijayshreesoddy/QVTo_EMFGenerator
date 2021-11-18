package com.uni.de.qvto.profiler.views.providers;

import java.util.ArrayList;
import java.util.List;

public class ProfilerElement {
	private String ruleName;
	private double responseTime;
	private String memoryUsage;
	private String numberofElements;
	private String inputModel;
	public String getInputModel() {
		return inputModel;
	}
	public void setInputModel(String inputModel) {
		this.inputModel = inputModel;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public double getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(double responseTime) {
		this.responseTime = responseTime;
	}
	public String getMemoryUsage() {
		return memoryUsage;
	}
	public void setMemoryUsage(String memoryUsage) {
		this.memoryUsage = memoryUsage;
	}
	public String getNumberofElements() {
		return numberofElements;
	}
	public void setNumberofElements(String numberofElements) {
		this.numberofElements = numberofElements;
	}
	

	public static List<ProfilerElement> constructModel() {
		
		List<ProfilerElement> profilerList = new ArrayList<ProfilerElement>();
		/*profilerList.add(getElement("model2RDBModel"));
		profilerList.add(getElement("package2schemas"));
		profilerList.add(getElement("persistentClass2table"));
		profilerList.add(getElement("class2primaryKey"));
		profilerList.add(getElement("class2columns"));
		profilerList.add(getElement("dataType2columns"));
		profilerList.add(getElement("dataType2primaryKeyColumns"));
		profilerList.add(getElement("primitiveAttributes2columns"));
		profilerList.add(getElement("enumerationAttributes2columns"));
		profilerList.add(getElement("relationshipAttributes2columns"));
		profilerList.add(getElement("relationshipAttribute2foreignKey"));
		profilerList.add(getElement("associationAttributes2columns"));
		profilerList.add(getElement("generalizations2columns"));*/
		
		return profilerList;

		
	}
	
	public static ProfilerElement getElement(String ruleName) {
		ProfilerElement element = new ProfilerElement();
		element.setRuleName(ruleName);
		element.setNumberofElements("53");
		element.setResponseTime(Math.random());
		element.setMemoryUsage(String.valueOf(Math.random()));
		element.setInputModel(ruleName.substring(ruleName.indexOf('2')+1));;

		return element;

		
	}
	
	
	
	
}
