package com.uni.de.qvto.headless.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ShellExecutor {

	private final static String BAT_NAME = "modelGenerator.cmd";
 	private final static String SHELL_NAME = "modelGenerator.sh";
 	
	public static void executeShellScript(String modelExectorPath) {
        String operSys = System.getProperty("os.name").toLowerCase();
        if (operSys.contains("win")) {
        	executeCmd(modelExectorPath);
        } else if (operSys.contains("mac")) {
        	executeScript(modelExectorPath);
        } 

	}
	
	public static void executeCmd(String modelExectorPath) {
		Process p;

		try {
			List<String> cmdList = new ArrayList<String>();
			// adding command and args to the list

			cmdList.add("cmd");
			cmdList.add("/c");
			cmdList.add(BAT_NAME);
			ProcessBuilder pb = new ProcessBuilder();
			pb.command(cmdList).directory(new File(modelExectorPath));
			p = pb.start();
			// p.waitFor();

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException /* | InterruptedException */ e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		//executeShellScript("");
	}

	public static void executeScript(String modelExectorPath) {
		Process p;

		try {
			List<String> cmdList = new ArrayList<String>();
			// adding command and args to the list

			cmdList.add("sh");
			cmdList.add(SHELL_NAME);
			ProcessBuilder pb = new ProcessBuilder();
			pb.command(cmdList).directory(new File(modelExectorPath));
			p = pb.start();
			// p.waitFor();

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException /* | InterruptedException */ e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
