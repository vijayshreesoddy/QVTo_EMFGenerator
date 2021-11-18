package com.uni.de.qvto.headless.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

public class QVToCommandLine {
	
	private static final String QVTO_PROP_LOCATION = File.separator+"QVTo"+File.separator;
	private static final String QVTO_FILE_NAME = "config.properties";
	private static final String EMFMODEL_PROP_NAME = "configuration.properties";
	//private static final String INPUT_MODEL  = File.separator+"output1"+File.separator+"1.xmi";
	private static final String INPUT_MODEL  = "genModel.xmi";



	public static void executeModelGenerator() {
		String installationPath = getDefaultLocation()+QVTO_PROP_LOCATION;

		Properties prop = loadPropertiesFile(installationPath+QVTO_FILE_NAME);
		
		ShellExecutor.executeShellScript(installationPath+prop.getProperty("ModelGenerator"));
		executeQVToScripts(prop, installationPath, generateRandomNumbers());
	}
	
	/*public static void executeQVToScripts(String configFilePath, String numberofModelElements) {
		Properties prop = loadPropertiesFile(configFilePath);
		String parentPath = new File(configFilePath).getParentFile().getAbsolutePath()+File.separator;
		writeNumberofNodes(parentPath+prop.getProperty("ModelGenerator"), numberofModelElements);
		ShellExecutor.executeShellScript(parentPath+prop.getProperty("ModelGenerator"));
		String inputMM = parentPath+prop.getProperty("ModelGenerator")+INPUT_MODEL;
		if(new File(inputMM).exists()) {
			executeQVToScripts(prop, parentPath, inputMM);
		}

	}*/
	
	public static void executeQVToScripts(String configFilePath, String numberofModelElements) {
		Properties prop = loadPropertiesFile(configFilePath);
		String parentPath = new File(configFilePath).getParentFile().getAbsolutePath()+File.separator;
		executeQVToScripts(prop, parentPath, numberofModelElements);
	}
	
	public static void executeQVToScripts(String configFilePath) {
		Properties prop = loadPropertiesFile(configFilePath);
		String parentPath = new File(configFilePath).getParentFile().getAbsolutePath()+File.separator;
		executeQVToScripts(prop, parentPath, null);
	}
	private static void executeQVToScripts(Properties prop, String installationPath, String numberofModelElements) {
	    //ProfilierModelProvider.INSTANCE.getProfilierList().clear();

		// Refer to an existing transformation via URI
		URI transformationURI = URI.createFileURI(installationPath+prop.getProperty("QVToRules"));
		// create executor for the given transformation
		TransformationExecutor executor = new TransformationExecutor(transformationURI);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		
		// define the transformation input
		// Remark: we take the objects from a resource, however
		// a list of arbitrary in-memory EObjects may be passed
		ExecutionContextImpl context = new ExecutionContextImpl();
		
		ResourceSet resourceSet = new ResourceSetImpl();
		EPackage rdbMM = (EPackage) resourceSet.getResource(URI.createFileURI(installationPath+prop.getProperty("OutputMM")), true).getContents().get(0);
		EPackage simpleuml = (EPackage) resourceSet.getResource(URI.createFileURI(installationPath+prop.getProperty("InputMM")), true).getContents().get(0);
        EPackage.Registry.INSTANCE.put(rdbMM.getNsURI(), rdbMM);
        EPackage.Registry.INSTANCE.put(simpleuml.getNsURI(), simpleuml);

		Resource inResource = resourceSet.getResource(
				URI.createFileURI(installationPath+prop.getProperty("InputModel")), true);	
		if(numberofModelElements!=null) {
			inResource = ModelCreater.createModel(resourceSet, inResource, installationPath+INPUT_MODEL, numberofModelElements, prop.getProperty("EClasses"));
		}
		EList<EObject> inObjects = inResource.getContents();

		// create the input extent with its initial contents
		ModelExtent input = new BasicModelExtent(inObjects);		
		// create an empty extent to catch the output
		ModelExtent output = new BasicModelExtent();

		// setup the execution environment details -> 
		// configuration properties, logger, monitor object etc.
		
		context.setConfigProperty("keepModeling", true);

		// run the transformation assigned to the executor with the given 
		// input and output and execution context -> ChangeTheWorld(in, out)
		// Remark: variable arguments count is supported
		ExecutionDiagnostic result = executor.execute(context, input, output);

		// check the result for success
		if(result.getSeverity() == Diagnostic.OK) {
			// the output objects got captured in the output extent
			List<EObject> outObjects = output.getContents();
			// let's persist them using a resource 
			Resource outResource = resourceSet.createResource(
					URI.createFileURI(installationPath+prop.getProperty("OutputModel")));
			outResource.getContents().addAll(outObjects);
			try {
				outResource.save(Collections.emptyMap());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// turn the result diagnostic into status and send it to error log			
			IStatus status = BasicDiagnostic.toIStatus(result);
			
		}
		
	}
	
	public static void main(String[] args) {
		String propertiesFile = "C:\\Src\\QVToProfiler\\com.uni.de.qvto.mice.product\\target\\products\\com.uni.de.qvto.product\\win32\\win32\\x86_64\\QVTo\\";
	    Properties prop = loadPropertiesFile(propertiesFile);
	 // load a properties file
	    
			
			System.out.println("QVTo File---"+prop.getProperty("QVToRules"));
			System.out.println("InputMM File---"+prop.getProperty("InputMM"));

			System.out.println("OutputMM File---"+prop.getProperty("OutputMM"));
			System.out.println("InputModel File---"+prop.getProperty("InputModel"));
			System.out.println("OutputModel File---"+prop.getProperty("OutputModel"));
			System.out.println("Script File---"+prop.getProperty("ModelGenerator"));

	

		
	}
	
	private static Properties loadPropertiesFile(String installationPath) {
		System.out.println("QVTo Headless...Path..."+installationPath);
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(installationPath));

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return prop;
	}
	
	public static String getDefaultLocation() {
		  if (Platform.getInstallLocation() != null) {
		    URL url = Platform.getInstallLocation().getURL();
		    IPath path = new org.eclipse.core.runtime.Path(url.getFile()).removeTrailingSeparator();
		    return path.toOSString();
		  }
		  return ""; //$NON-NLS-1$
		}

	private static void writeNumberofNodes(String parentPath, String numberofModelElements)  {
	    String file=parentPath+File.separator+EMFMODEL_PROP_NAME;     
	    Path path = Paths.get(file);
	    Charset charset = StandardCharsets.UTF_8;
	    try {
	    String content = new String(Files.readAllBytes(path), charset);
	    content = content.replaceAll("Node_Count = [0-9]+", "Node_Count = "+numberofModelElements);
	    Files.write(path, content.getBytes(charset), StandardOpenOption.WRITE);
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/*private static void generateRandomNumbers (String parentPath) {
		int upperBound = 1499;
		int lowerBound = 500;
		int number = lowerBound + (int)(Math.random() * ((upperBound - lowerBound) + 1));
		writeNumberofNodes(parentPath, String.valueOf(number));
		
	}*/
	
	private static String generateRandomNumbers () {
	int upperBound = 1499;
	int lowerBound = 500;
	int number = lowerBound + (int)(Math.random() * ((upperBound - lowerBound) + 1));
    return String.valueOf(number);
	}
}
