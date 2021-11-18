package com.uni.de.qvto.uml2rdb.handler;

import java.io.File;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class QVToDialog  extends Dialog {

    private Text fileText;
    private Text numberText;
    private Button autoGenerateButton;
    private String configPath = "";
    private boolean generateModel = false;
    private String numberofModelElements = "500";
	protected QVToDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	  protected Control createDialogArea(Composite parent) {
		    Composite wrapper = (Composite) super.createDialogArea(parent);

		    GridLayout layout = (GridLayout) wrapper.getLayout();
		    layout.numColumns = 3;

		    Label label = null;
	        label = new Label ( wrapper, SWT.NONE );
	        label.setText ( "Select QVTo Config Property File:" );

	        this.fileText = new Text ( wrapper, SWT.SINGLE | SWT.BORDER );
	        GridData gridData = new GridData ( SWT.FILL, SWT.CENTER, true, false );

	        gridData.widthHint = 250;
	        gridData.heightHint = 20;
	        this.fileText.setLayoutData (gridData);

	        
	        final Button fileButton = new Button ( wrapper, SWT.PUSH );
	        fileButton.setText ( "..." );
	        fileButton.addSelectionListener ( new SelectionAdapter () {
	            @Override
	            public void widgetSelected ( final SelectionEvent e )
	            {
	                chooseFile ();
	            }
	        } );
	        
	        autoGenerateButton = new Button ( wrapper, SWT.CHECK );
	        autoGenerateButton.setText ( "Auto Generate Model" );
	        autoGenerateButton.addSelectionListener ( new SelectionAdapter () {
	            @Override
	            public void widgetSelected ( final SelectionEvent e )
	            {
	            	Button btn = (Button) e.getSource();
	            	if(btn.getSelection()) {
	        	        numberText.setEnabled(true);

	            		
	            	} else {
	        	        numberText.setEnabled(false);
	
	            	}
	            }
	        } );
	        new Label ( wrapper, SWT.NONE );
	        new Label ( wrapper, SWT.NONE );
	        Label number = null;
	        number = new Label ( wrapper, SWT.NONE );
	        number.setText ( "Number of Model Elements to Generate: " );
	        
	        this.numberText = new Text ( wrapper, SWT.SINGLE | SWT.BORDER );
	        this.numberText.setEnabled(false);
	        GridData gridData1 = new GridData ( SWT.FILL, SWT.CENTER, true, false );

	        gridData1.widthHint = 50;
	        gridData1.heightHint = 20;
	        this.numberText.setLayoutData (gridData1);

		    return wrapper;
		  }
	  
	  protected void chooseFile ()
	    {
	        final FileDialog dlg = new FileDialog ( getShell (), SWT.OPEN | SWT.MULTI );
	        dlg.setFilterExtensions ( new String[] { "*.properties"} );
	        dlg.setFilterNames ( new String[] { "QVTo Config Properties"} );
	        final String result = dlg.open ();
	        if ( result != null )
	        {
	            final File base = new File ( dlg.getFilterPath () );

	            for ( final String name : dlg.getFileNames () )
	            {
	                this.fileText.setText ( new File ( base, name ).getAbsolutePath () );
	            }
	        }
	    }
	  
	// override method to use "Login" as label for the OK button
	    @Override
	    protected void createButtonsForButtonBar(Composite parent) {
	        createButton(parent, IDialogConstants.OK_ID, "Transform", true);
	        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	    }
	    
	    @Override
	    protected void okPressed() {
	    	configPath = fileText.getText();
	    	generateModel = autoGenerateButton.getSelection();
	    	numberofModelElements = numberText.getText();
	        super.okPressed();
	    }
	    
	    public String getConfigFilePath() {
	    	return configPath;
	    }
	    
	    public boolean isAutoGenerate() {
	    	return generateModel;
	    }
	    
	    public String numberofModelElements() {
	    	return numberofModelElements==null?"500":numberofModelElements;
	    }
}

