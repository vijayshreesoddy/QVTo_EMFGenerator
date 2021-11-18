package com.uni.de.qvto.uml2rdb.product;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	@Override	
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.setFixed(true);
		
		/*String editorArea = layout.getEditorArea();
        layout.setEditorAreaVisible(false);
        layout.setFixed(true);
        layout.addStandaloneView("com.uni.de.qvto.profiler.views.QVToProfilerView",  false, IPageLayout.LEFT, 1.0f, editorArea);	*/
}
}
	
