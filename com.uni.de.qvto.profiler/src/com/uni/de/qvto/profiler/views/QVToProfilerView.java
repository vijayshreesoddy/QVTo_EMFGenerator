package com.uni.de.qvto.profiler.views;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.*;

import com.uni.de.qvto.profiler.views.providers.ProfilerContentProvider;
import com.uni.de.qvto.profiler.views.providers.ProfilerElement;
import com.uni.de.qvto.profiler.views.providers.ProfilerLabelProvider;
import com.uni.de.qvto.profiler.views.providers.ProfilierModelProvider;

import org.eclipse.jface.viewers.*;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.TraceViewContentProvider;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.TraceViewLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.SWT;
import javax.inject.Inject;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class QVToProfilerView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "com.uni.de.qvto.profiler.views.QVToProfilerView1";

	@Inject IWorkbench workbench;
	
	private TableViewer viewer;
	private String[] COLUMN_NAMES= {"Rule Name", "Response Time", "Memory", "Number of Elements", "Percentage"};
	private int[] COLUMN_WIDTHS= {200,100,100,150, 200};

	 

	

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		
		TraceViewContentProvider contentProvider = new TraceViewContentProvider();
		viewer.setContentProvider(contentProvider);
        TraceViewLabelProvider labelProvider = new TraceViewLabelProvider();
        viewer.setLabelProvider(labelProvider);
        
		Table table = viewer.getTable(); 
		table.setHeaderVisible(true);      
		table.setLinesVisible(true);

		for (int i = 0; i < COLUMN_NAMES.length; i++) {
		  TableColumn tableColumn = new TableColumn(table, SWT.LEFT);
		  tableColumn.setText(COLUMN_NAMES[i]);
		  tableColumn.setWidth(COLUMN_WIDTHS[i]);
		}
		viewer.setContentProvider(new ProfilerContentProvider());
		//viewer.setInput(ProfilierModelProvider.INSTANCE.getProfilierList());
		viewer.setLabelProvider(new ProfilerLabelProvider());
    table.addListener(SWT.PaintItem, new Listener() {
		
		

        public void handleEvent(Event event) {
          if (event.index == 4) {
            GC gc = event.gc;
            TableItem item = (TableItem) event.item;
            int index = table.indexOf(item);
            //long percent = Long.valueOf(ProfilierModelProvider.INSTANCE.getProfilierList().get(index).getResponseTime());
            long percent =  100;
            Color foreground = gc.getForeground();
            Color background = gc.getBackground();
            gc.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
            gc.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_YELLOW));
            double value = (percent * 199) / ProfilierModelProvider.INSTANCE.getTotalExecutionTime();
            String percentage = String.valueOf(value);
          //  System.out.println("----Percentage---"+percentage);

            int width =  Integer.parseInt(percentage);
            gc.fillGradientRectangle(event.x, event.y, width, event.height, true);
            Rectangle rect2 = new Rectangle(event.x, event.y, width - 1, event.height - 1);
            gc.drawRectangle(rect2);
            gc.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_LIST_FOREGROUND));
            String text = percentage + "%";
            Point size = event.gc.textExtent(text);
            int offset = Math.max(0, (event.height - size.y) / 2);
            gc.drawText(text, event.x + 2, event.y + offset, true);
            gc.setForeground(background);
            gc.setBackground(foreground);
          }
        }
      });


		// Create the help context id for the viewer's control
		workbench.getHelpSystem().setHelp(viewer.getControl(), "com.uni.de.qvto.profiler.viewer");
		getSite().setSelectionProvider(viewer);

	}

	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"QVTo Profiler",
			message);
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	public TableViewer getViewer() {
		return viewer;
	}
}
