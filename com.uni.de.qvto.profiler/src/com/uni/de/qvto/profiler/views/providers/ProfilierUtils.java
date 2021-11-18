package com.uni.de.qvto.profiler.views.providers;

import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;

public class ProfilierUtils {
	
	public static String getReponseTime(Object record) {
		if(record instanceof TraceRecord) {
			ProfilerElement element = ProfilierModelProvider.INSTANCE.getProfilerElement((TraceRecord) record);
			if(element!=null) {
				return String.valueOf(element.getResponseTime());
			}
		}
		return  "";
		
	}

}
