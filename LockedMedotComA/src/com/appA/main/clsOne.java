package com.appA.main;

import java.io.File;
import java.util.Arrays;

public class clsOne {

	static String str1 = "*************** MAIN ****************";
	static String str2 = "Welcome to LockedMedotCom application";
	static String str3 = "Developer: Nurul 'Atiqah";
	static String str4 = "*************************************";

	public static void showMenu() {
		System.out.println();
		System.out.println(str1 + "\n" + str2 + "\n" + str3 + "\n" + str4 + "\n");
		System.out.println("1. Display current files");
		System.out.println("2. Add, Delete and Search files");
		System.out.println("3. Close application");
		System.out.println("*************************************");
		System.out.print("Please enter an option : ");
	}

	File dir() {
		return new File("").getAbsoluteFile();
	}
 
	public void displayFile() {
		File[] files = dir().listFiles();
		Arrays.sort(files);
		try { 	
			if (!dir().exists()) {
				System.out.println("Directory does not exist.");
				System.out.println(dir().getAbsolutePath());
			} else {
				System.out.println("Current no. of files : " + files.length);			
				for (File eachFile : files) { 
					if (eachFile.isDirectory()) {
						System.out.println(eachFile.getName());
					} else
						System.out.println(eachFile.getName());
				}
			}
		} catch (Exception e) {
			System.out.println("File path not exist!");
			System.out.println("Directory is created " + dir().mkdirs());
			return;
		}
	}

	
}
