package com.uni.de.qvto.aspect;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.internal.qvt.oml.evaluator.TraceUtil;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.internal.qvt.oml.trace.VarParameterValue;
import org.eclipse.ocl.Environment;

public class TraceUtility {
	
	static TraceRecord getTraceRecord(QvtOperationalEvaluationEnv evalEnv, MappingOperation mappingOperation) {
		InternalEvaluationEnv internEnv = evalEnv.getAdapter(InternalEvaluationEnv.class);
		Trace trace = internEnv.getTraces();

		Object selfObj = evalEnv.getValueOf(Environment.SELF_VARIABLE_NAME);

		Object key = createKey(selfObj, evalEnv, mappingOperation);
		if (key != null) {
			TraceRecord record = trace.getRecordBySource(mappingOperation, key);
			if (record != null && Boolean.TRUE.equals(checkResultMatch(record, evalEnv))) {
				return record;
			}
			// nothing found, mapping executed for the first time on the given
			// source
			return null;
		}

		// Fall back on 'original' TraceUtil
		return getTraceRecordDefault(evalEnv, mappingOperation);
	}
	
	 private static boolean isOclEqual(Object candidateObject, Object traceObject, DirectionKind directionKind, QvtOperationalEvaluationEnv evalEnv) {
	    	if (directionKind == DirectionKind.OUT) {
	    		if (candidateObject == null) {
	    			// yet not bound 'out' parameter, suit for any
	    			return true;
	    		}
	    	}
	        if (candidateObject == traceObject) {
	            return true;
	        }
	        if (QvtOperationalUtil.isUndefined(candidateObject, evalEnv)) {
	            return QvtOperationalUtil.isUndefined(traceObject, evalEnv);
	        }
	        if ((candidateObject == null) || (traceObject == null)) {
	            return false;
	        }
	        return candidateObject.equals(traceObject); // Overridden equals() is implied
	    }
	
	 private static Boolean checkResultMatch(TraceRecord nextRecord, QvtOperationalEvaluationEnv evalEnv) {
	        // check result parameters
	        Object resultValue = evalEnv.getValueOf(Environment.RESULT_VARIABLE_NAME);
	        if (resultValue != null) {
	            List<Object> resultValues = new ArrayList<Object>(1); 
	           	resultValues.add(resultValue);

	            if (nextRecord.getResult().getResult().size() != resultValues.size()) {
	                return null;
	            }
	            for (int i = 0, n = resultValues.size(); i < n; i++) {
	                Object paramValue = resultValues.get(i);
	                VarParameterValue traceParamVal = (VarParameterValue) nextRecord.getResult().getResult().get(i);
	                if (!isOclEqual(paramValue, traceParamVal.getValue().getOclObject(), DirectionKind.OUT, evalEnv)) {
	                    return Boolean.FALSE;
	                }
	            }
	        }    	
	        
	        return Boolean.TRUE;
	    }
	/**
	 * Creates a key for mapping operations, based on the context (if available)
	 * and all parameters (if any).
	 */
	private static Object createKey(Object selfObj, QvtOperationalEvaluationEnv evalEnv, MappingOperation mappingOperation) {
		EList<EParameter> eParameters = mappingOperation.getEParameters();
		if (eParameters.isEmpty()) {
			// Backwards compatible for isParameterLessContextual
			return selfObj;
		}

		ArrayList<Object> key = new ArrayList<Object>(eParameters.size() + 1);
		key.add(selfObj);
		for (EParameter param : eParameters) {
			VarParameter varParam = (VarParameter) param;
			if (varParam.getKind() == DirectionKind.OUT) {
				continue;
			}
			key.add(evalEnv.getValueOf(param.getName()));
		}

		return key;
	}


    private static TraceRecord getTraceRecordDefault(QvtOperationalEvaluationEnv evalEnv, MappingOperation mappingOperation) {
    	InternalEvaluationEnv internEnv = evalEnv.getAdapter(InternalEvaluationEnv.class);    	
    	Trace trace = internEnv.getTraces();
        Object selfObj = evalEnv.getValueOf(Environment.SELF_VARIABLE_NAME);
    	
    	// the direct fetch by the contextual source object
    	if(selfObj != null && isParameterLessContextual(mappingOperation)) {
	    	TraceRecord record = trace.getRecordBySource(mappingOperation, selfObj);
	    	if(record != null && Boolean.TRUE.equals(checkResultMatch(record, evalEnv))) {
	    		return record;
	    	}
	    	// nothing found, mapping executed for the first time on the given source
	    	return null;
    	}

        EMap<MappingOperation, EList<TraceRecord>> allTraceRecordMap = trace.getTraceRecordMap();
        EList<TraceRecord> traceRecords = allTraceRecordMap.get(mappingOperation);
        if (traceRecords == null) {
            return null;
        }
        
        // Section [8.2.1.15]
        // After call resolution, all the parameters of the mapping are passed as a tuple. 
        // The parameters include, in this order: the context parameter (if any), the owned 
        // parameters (from Operation::ownedParameter), and the parameters declared as result.

        traceCheckCycle:
            for (TraceRecord nextRecord : traceRecords) {
            	// check context parameter
                if (QvtOperationalParserUtil.isContextual(mappingOperation)) {
                    VarParameterValue nextContext = nextRecord.getContext().getContext();
					if (nextContext == null) {
                        continue;
                    }
                    if (!isOclEqual(selfObj, nextContext.getValue().getOclObject(), mappingOperation.getContext().getKind(), evalEnv)) {
                        continue;
                    }
                }
                // check owned parameters
                int candidateParamSize = mappingOperation.getEParameters().size();
                if (nextRecord.getParameters().getParameters().size() != candidateParamSize) {
                    continue;
                }
                for (int i = 0; i < candidateParamSize; i++) {
                    EParameter param = mappingOperation.getEParameters().get(i);
                    Object paramValue = evalEnv.getValueOf(param.getName());
                    VarParameterValue traceParamVal = (VarParameterValue) nextRecord.getParameters().getParameters().get(i);
                    DirectionKind paramKind = DirectionKind.IN;
                    if (param instanceof VarParameter) {
                    	paramKind = ((VarParameter) param).getKind();
                    }
                    if (paramKind != DirectionKind.OUT
                    		&& !isOclEqual(paramValue, traceParamVal.getValue().getOclObject(), paramKind, evalEnv)) {
                        continue traceCheckCycle;
                    }
                }
                
                // check result parameters                
                Boolean checkResult = checkResultMatch(nextRecord, evalEnv);
                if(checkResult == null) {
                	continue;
                } else if(Boolean.FALSE.equals(checkResult)) {
                	continue traceCheckCycle;
                }
                
                return nextRecord;
            }
        return null;
    }
    
    private static boolean isParameterLessContextual(MappingOperation mappingOperation) {
		return QvtOperationalParserUtil.isContextual(mappingOperation) && mappingOperation.getEParameters().isEmpty();
	}


}
