package com.uni.de.qvto.profiler.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.*;

import com.uni.de.qvto.profiler.views.providers.ProfilerContentProvider;
import com.uni.de.qvto.profiler.views.providers.ProfilerElement;
import com.uni.de.qvto.profiler.views.providers.ProfilerLabelProvider;
import com.uni.de.qvto.profiler.views.providers.ProfilierModelProvider;
import com.uni.de.qvto.profiler.views.providers.ProfilierUtils;

import org.eclipse.jface.viewers.*;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.TraceViewContentProvider;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.TraceViewLabelProvider;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;

import javax.inject.Inject;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class QVToProfilerTreeTableView extends ViewPart {
	private java.awt.Frame jfreeFrame;
	private Composite jFreeComp;

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "com.uni.de.qvto.profiler.views.QVToProfilerView";

	@Inject
	IWorkbench workbench;

	private TreeViewer viewer;
	private String[] COLUMN_NAMES = { "Trace Element", "Response Time", "Percentage" };
	private int[] COLUMN_WIDTHS = { 490, 150, 200 };

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);

		TraceViewContentProvider contentProvider = new TraceViewContentProvider();
		viewer.setContentProvider(contentProvider);
		viewer.setLabelProvider(new ProfilerLabelProvider());

		Tree tree = viewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		for (int i = 0; i < COLUMN_NAMES.length; i++) {
			TreeColumn tableColumn = new TreeColumn(tree, SWT.LEFT);
			tableColumn.setText(COLUMN_NAMES[i]);
			tableColumn.setWidth(COLUMN_WIDTHS[i]);
		}
		viewer.setInput(ProfilierModelProvider.INSTANCE.getTraceModel());

		tree.addListener(SWT.PaintItem, new Listener() {

			public void handleEvent(Event event) {
				if (event.index == 2) {
					GC gc = event.gc;
					TreeItem item = (TreeItem) event.item;
					double percent = Double.valueOf(ProfilierUtils.getReponseTime(item.getData()));
					Color foreground = gc.getForeground();
					Color background = gc.getBackground();
					gc.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
					gc.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_YELLOW));
					double value = (percent * 199) / ProfilierModelProvider.INSTANCE.getTotalExecutionTime();
					String percentage = String.valueOf( Math.round(value));
					//System.out.println("----Percentage---" + percentage);

					int width = Integer.parseInt(percentage);
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

		GridLayout layout = new GridLayout(1, true);
		layout.verticalSpacing = 0;
		layout.horizontalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
       

		jFreeComp = new Composite(parent, SWT.EMBEDDED);
		jFreeComp.setLayout(layout);
		jFreeComp.setLayoutData(new GridData(GridData.FILL_VERTICAL | GridData.FILL_HORIZONTAL));

	    jfreeFrame = SWT_AWT.new_Frame(jFreeComp);
		//ProfilerBarChart  chart = new ProfilerBarChart("Profiler");
		//jfreeFrame.add(chart.getPanel());

		// Create the help context id for the viewer's control
		workbench.getHelpSystem().setHelp(viewer.getControl(), "com.uni.de.qvto.profiler.viewer");
		getSite().setSelectionProvider(viewer);

	}

	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(), "QVTo Profiler", message);
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	public void addBarChart() {
		jfreeFrame = SWT_AWT.new_Frame(jFreeComp);
		ProfilerBarChart  chart = new ProfilerBarChart("Profiler");
		jfreeFrame.add(chart.getPanel());

		
	}

	public TreeViewer getViewer() {
		return viewer;
	}
}
