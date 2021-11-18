package com.uni.de.qvto.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.TraceUtil;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.util.QVTOperationalVisitor;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.TraceViewLabelProvider;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.qvt.oml.examples.blackbox.UtilitiesLibrary;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.OCLExpression;

import com.uni.de.qvto.profiler.views.providers.ProfilerElement;
import com.uni.de.qvto.profiler.views.providers.ProfilerLabelProvider;
import com.uni.de.qvto.profiler.views.providers.ProfilierModelProvider;
import com.uni.de.qvto.uml2rdb.handler.UML2RDBHandler;


@Aspect
public class QVToEngineAspects {
	@Around("call(public void com.uni.de.qvto.uml2rdb.handler.UML2RDBHandler.printUML2RDB(..)) " +
		      "&& args(obj)")
		  public void aroundPrint(final String obj, final ProceedingJoinPoint joinPoint) throws Throwable
		  {
		 System.out.println("hitting aspect");
		    long nanoTime1 = System.nanoTime();

		    Exception ex = null;
		    try
		    {
		      joinPoint.proceed();
		    }
		    catch (Exception e)
		    {
		      ex = e;
		      throw e;
		    }
		    finally
		    {
		      long nanoTime2 = System.nanoTime();

		   
		      System.out.println(obj+" is "+(nanoTime2 - nanoTime1) / 1e9);

		
		    }
		  }
	
	/*@Around("call(Object org.eclipse.core.commands.IHandler.execute(..)) " +
   "&& args(event)")
	  public Object aroundPrint(final ExecutionEvent event, final ProceedingJoinPoint joinPoint) throws Throwable
{
System.out.println("hitting aspect");
  long nanoTime1 = System.nanoTime();

  Exception ex = null;
  try
  {
    joinPoint.proceed();
  }
  catch (Exception e)
  {
    ex = e;
    throw e;
  }
  finally
  {
    long nanoTime2 = System.nanoTime();

 
    System.out.println(event.getTrigger()+" is "+(nanoTime2 - nanoTime1) / 1e9);


  }
  return null;
}*/
	
	//@Around("call(public java.lang.Object org.eclipse.m2m.internal.qvt.oml.expressions.util.QVTOperationalVisitor.visitMappingOperation(..)) " +
	//	      "&& args(mappingOperation)")
	//	  public Object aroundCheckInConfiguration(final MappingOperation mappingOperation,final ProceedingJoinPoint joinPoint) throws Throwable
		//  {
		    /*long startTime = UtilitiesLibrary.currentTime();

		    Exception ex = null;
		    
		    try
		    {
		    	System.out.println("Object returned..."+joinPoint.proceed());
		    	 
		      return (Object) joinPoint.proceed();
		    }
		    catch (Exception e)
		    {
		      ex = e;
		      throw e;
		    }
		    finally
		    {
		      long endTime = UtilitiesLibrary.currentTime();
		      
		     ProfilerElement profileElment = ProfilierModelProvider.INSTANCE.getProfilierMap().get(mappingOperation);
		      if(profileElment!=null) {
		    	  profileElment.setResponseTime(endTime - startTime);
			      System.out.println(mappingOperation.getName()+"  "+mappingOperation.getBody().getStartPosition()+" is "+ Long.valueOf(profileElment.getResponseTime()) / 1e9);

		      } else {
		    	  profileElment = new ProfilerElement();
		    	  profileElment.setRuleName(mappingOperation.getName());
		    	  profileElment.setResponseTime(String.valueOf(endTime - startTime));
		    	  ProfilierModelProvider.INSTANCE.getProfilierMap().put(mappingOperation, profileElment);
		    	  
		      }*/
		      //UtilitiesLibrary.measure(mappingOperation.getName(), startTime, endTime);
		     // UtilitiesLibrary.measureMemory();
		     // System.out.println("in execute mapping"+mappingOperation.getName()+"  "+mappingOperation.getBody().getStartPosition()+" is "+(endTime - startTime) / 1e9);


		
		    //}
	//	  }
	 
	
	@Around("call(protected * org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl.executeMapping(..)) " +
		      "&& args(mappingOperation, evalEnv) ")
		  public Object aroundMappingExecution(final MappingOperation mappingOperation, final QvtOperationalEvaluationEnv evalEnv, final ProceedingJoinPoint joinPoint) 
		  {
		    long startTime = UtilitiesLibrary.currentTime();

		    Exception ex = null;
		    try
		    {
		    	System.out.println("Object Returned--"+joinPoint.proceed());
		      return (Object) joinPoint.proceed();
		    }
		    catch (Exception e)
		    {
		      ex = e;
		      
		    } catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    finally
		    {

		      long endTime = UtilitiesLibrary.currentTime();
		      InternalEvaluationEnv internEnv = evalEnv.getAdapter(InternalEvaluationEnv.class);    	
		      Trace trace = internEnv.getTraces();
		      ProfilierModelProvider.INSTANCE.setTraceModel(trace);
		      
		      TraceRecord record = TraceUtility.getTraceRecord(evalEnv, mappingOperation);
		      if(record!=null) {
		    	  String ruleName = new TraceViewLabelProvider().getText(record);
			      UtilitiesLibrary.measure(ruleName, record, startTime, endTime);
			      System.out.println(ruleName+"............."+mappingOperation.getName()+"  "+mappingOperation.getBody().getStartPosition()+" is "+(endTime - startTime) / 1e9);

		    	  
		      }
		    
		
		    }
			return ex;
		  }
	
	

}
