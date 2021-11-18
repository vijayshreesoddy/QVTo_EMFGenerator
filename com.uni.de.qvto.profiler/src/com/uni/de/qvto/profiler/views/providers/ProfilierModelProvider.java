package com.uni.de.qvto.profiler.views.providers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;


public enum ProfilierModelProvider {
    INSTANCE;

	Map<TraceRecord , ProfilerElement> profilerMap = new HashMap<TraceRecord, ProfilerElement>();
	private Trace trace;


    private ProfilierModelProvider() {
    	profilerMap = new HashMap<TraceRecord, ProfilerElement>();

    }
    
    public double getTotalExecutionTime() {
    	double total=0l;
    	Collection<ProfilerElement> values = profilerMap.values();
    	for (ProfilerElement profilerElement : values) {
			total+= Double.valueOf(profilerElement.getResponseTime());
		}
    	return total;
    }
    
    public Map<TraceRecord , ProfilerElement> getProfilierMap() {
        return profilerMap;
    }
    
    public ProfilerElement getProfilerElement(TraceRecord traceRecord) {
    	ProfilerElement profileElment =  profilerMap.get(traceRecord);
    	return profileElment;
    }
    
    public void setTraceModel(Trace trace) {
		this.trace = trace;
	}

	public Trace getTraceModel() {
		// TODO Auto-generated method stub
		return trace;
	}

}