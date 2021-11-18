/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.examples.blackbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Parameter;
import org.eclipse.ocl.util.Bag;
import org.eclipse.ocl.util.CollectionUtil;
import org.hyperic.sigar.SigarException;

import com.uni.de.qvto.profiler.memory.OshiProfilerFactory;
import com.uni.de.qvto.profiler.views.providers.ProfilerElement;
import com.uni.de.qvto.profiler.views.providers.ProfilierModelProvider;

import kieker.common.record.controlflow.OperationExecutionRecord;
import kieker.monitoring.core.controller.IMonitoringController;
import kieker.monitoring.core.controller.MonitoringController;
import kieker.monitoring.sampler.oshi.OshiSamplerFactory;


public class UtilitiesLibrary {
	
	private static final IMonitoringController MONITORING_CONTROLLER =
			MonitoringController.getInstance();
	public UtilitiesLibrary() {
		super();
	}
	

	public static long currentTime() {
		return MONITORING_CONTROLLER.getTimeSource().getTime();
	}
	
	public static String measure(String ruleName, TraceRecord traceRecord, long startTime, long endTime) {
		 final OperationExecutionRecord e = new OperationExecutionRecord(
				 ruleName,
				 OperationExecutionRecord.NO_SESSION_ID,
				 OperationExecutionRecord.NO_TRACE_ID,
				 startTime, endTime,  "myHost",
				 OperationExecutionRecord.NO_EOI_ESS,
				 OperationExecutionRecord.NO_EOI_ESS);
	    MONITORING_CONTROLLER.newMonitoringRecord(e);
	    logMonitoringData(e,endTime, startTime, traceRecord);
		return endTime-startTime+" ms";
	}

	public static String measure(String ruleName, long startTime, long endTime) {
		 final OperationExecutionRecord e = new OperationExecutionRecord(
				 ruleName,
				 OperationExecutionRecord.NO_SESSION_ID,
				 OperationExecutionRecord.NO_TRACE_ID,
				 startTime, endTime,  "myHost",
				 OperationExecutionRecord.NO_EOI_ESS,
				 OperationExecutionRecord.NO_EOI_ESS);
	    MONITORING_CONTROLLER.newMonitoringRecord(e);
	    //logMonitoringData(e);
		return endTime-startTime+" ms";
	}

	private static void logMonitoringData(OperationExecutionRecord record, long endTime, long startTime, TraceRecord traceRecord) {
	    //InfluxDataWriter.INSTANCE().inputRecord(record);
	    ProfilerElement element = new ProfilerElement();
	    element.setRuleName(record.getOperationSignature());
		double responseTime = (endTime - startTime)/1e9;

		try {
			long memoryUsed = OshiProfilerFactory.INSTANCE.record(MONITORING_CONTROLLER);
			element.setMemoryUsage(String.valueOf(memoryUsed));
		} catch (SigarException e) {
			
		}
	    element.setResponseTime(responseTime);
	    ProfilierModelProvider.INSTANCE.getProfilierMap().put(traceRecord, element);

	}
	
	public static String measureMemory() {
		/*try {
			OshiSamplerFactory.INSTANCE.createSensorMemSwapUsage().sample(MONITORING_CONTROLLER);
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return null;
	}
	
	public  void measureCountOfElements(String count) {
		List<ProfilerElement> profilerElements = new ArrayList<ProfilerElement>();
		for (ProfilerElement element : profilerElements) {
			element.setNumberofElements(count);
		}
		
		System.out.println("count is---"+count);
	}
	
	public Date createDate(String dateStr) {
		return (Date)EcoreFactory.eINSTANCE.createFromString(EcorePackage.eINSTANCE.getEDate(), dateStr);
	}
	
	@Operation(contextual=true)
	public static boolean before(Date self, Date when) {
		return self.before(when);
	}
	
	@Operation(contextual=true)
	public static List<String> split(
			String self, 
			@Parameter(name="regexp") String regexp) {
		return CollectionUtil.createNewSequence(Arrays.asList(self.split(regexp)));
	}

	@Operation(contextual=true)
	public static String getQualifiedName(EClassifier self) {
		return self.getEPackage().getName() + "::" + self.getName();
	}

	public static Set<LinkedHashSet<List<Bag<Boolean>>>> testAllCollectionTypes(boolean element) {
		final Bag<Boolean> createNewBag = CollectionUtil.createNewBag();
		createNewBag.add(element);
		final List<Bag<Boolean>> createNewSequence = CollectionUtil.createNewSequence();
		createNewSequence.add(createNewBag);
		final LinkedHashSet<List<Bag<Boolean>>> createNewOrderedSet = CollectionUtil.createNewOrderedSet();
		createNewOrderedSet.add(createNewSequence);
		final Set<LinkedHashSet<List<Bag<Boolean>>>> result = CollectionUtil.createNewSet();
		result.add(createNewOrderedSet);
		return result;
	}
}

