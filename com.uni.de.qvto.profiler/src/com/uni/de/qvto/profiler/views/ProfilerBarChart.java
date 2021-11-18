package com.uni.de.qvto.profiler.views;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.TraceViewLabelProvider;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.uni.de.qvto.profiler.views.providers.ProfilerElement;
import com.uni.de.qvto.profiler.views.providers.ProfilierModelProvider;
import com.uni.de.qvto.profiler.views.providers.ProfilierUtils;

public class ProfilerBarChart {
	private ChartPanel panel;

	 public ProfilerBarChart(String appTitle) {

		    // Create Dataset
		    CategoryDataset dataset = createDataset();
		    
		    //Create chart
		    JFreeChart chart=ChartFactory.createBarChart(
		        "QVTo Rules Execution Time", //Chart Title
		        "QVTo Rules", // Category axis
		        "Time in Sec", // Value axis
		        dataset,
		        PlotOrientation.VERTICAL,
		        true,true,false
		       );

		     panel=new ChartPanel(chart);
		  }
	 
	 public ChartPanel getPanel() {
		 return panel;
	 }

	private CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Map<TraceRecord , ProfilerElement> profilerMap = ProfilierModelProvider.INSTANCE.getProfilierMap();
		Set<TraceRecord> keySet = profilerMap.keySet();
		for (TraceRecord traceRecord : keySet) {
		    String ruleName = new TraceViewLabelProvider().getText(traceRecord);
		    String responseTime = ProfilierUtils.getReponseTime(traceRecord);
		    dataset.addValue(Double.valueOf(responseTime), "", ruleName);


			
		}
	/*    // Population in 2005
	    dataset.addValue(10, "USA", "2005");
	    dataset.addValue(15, "India", "2005");
	    dataset.addValue(20, "China", "2005");

	    // Population in 2010
	    dataset.addValue(15, "USA", "2010");
	    dataset.addValue(20, "India", "2010");
	    dataset.addValue(25, "China", "2010");

	    // Population in 2015
	    dataset.addValue(20, "USA", "2015");
	    dataset.addValue(25, "India", "2015");
	    dataset.addValue(30, "China", "2015");*/

	    return dataset;
	}
}
