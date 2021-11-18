package com.uni.de.qvto.profiler.views.providers;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.TraceViewLabelProvider;
import org.eclipse.swt.graphics.Image;

public class ProfilerLabelProvider extends LabelProvider implements
        ITableLabelProvider {
	private TraceViewLabelProvider labelProvider;

	public ProfilerLabelProvider() {
         labelProvider = new TraceViewLabelProvider();

	}
    @Override
    public Image getColumnImage(Object element, int columnIndex) {
        // no image to show
    	 switch (columnIndex) {
         case 0:
             return labelProvider.getImage(element);
    	 }
        return null;
    }

    @Override
    public String getColumnText(Object element, int columnIndex) {
        // each element comes from the ContentProvider.getElements(Object)
        switch (columnIndex) {
        case 0:
            return labelProvider.getText(element);
        case 1:
            return ProfilierUtils.getReponseTime(element);
        case 4:
            return "";
        default:
            break;
        }
        return "";
    }
}