package com.appA.main;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class clsTwo {

	static String currentDir = System.getProperty("user.dir");
	static boolean isFound = false;

	public static void showMenuOpt2() {
		System.out.println("\n-------- Option 2 ----------");
		System.out.println("1. Add file");
		System.out.println("2. Delete file");
		System.out.println("3. Search file");
		System.out.println("4. Back to Main");
		System.out.print("Please enter an option : ");
	}

	// 1. Add files
	protected void addfile(String infilePath) throws Exception {

		Path path = Paths.get(infilePath);
		Path f1 = path.getFileName();
		String f2 = currentDir.concat("\\") + f1.toString();
		FileInputStream inF = null;
		FileOutputStream outF = null;
		BufferedOutputStream bufferStream = null;
		try {
			if (!path.isAbsolute()) {
				System.out.println("Incorrect path!");
				return;
			} else {
				File infile = new File(infilePath);
				File outfile = new File(f2);
				inF = new FileInputStream(infile);
				outF = new FileOutputStream(outfile);
				bufferStream = new BufferedOutputStream(outF);
				byte[] buffer = new byte[1024];
				int length;
				while ((length = inF.read(buffer)) > 0) {
					bufferStream.write(buffer, 0, length);
				}
				System.out.println("Files successfully added");
			}
			bufferStream.flush();
			bufferStream.close();
			inF.close();
			outF.close();
		} catch (FileNotFoundException e1) {
			System.out.println("File not found!");
			return;
		} catch (IOException e2) {
			System.out.println("Invalid permissions.");
			return;
		}
	}

	// 2. Delete file
	protected static void deleteFile(String fileName) {
		// check case sensitive
		File dir = new File(currentDir);
		File[] files = dir.listFiles();
		String delF;
		try {
			if (!dir.exists()) {
				System.out.println("Directory not existed." + dir.getName());
			} else {
				// add files to array to check, check case sensitive
				System.out.println("Directory : " + currentDir);
				for (File eachFile : files) {
					if (eachFile.getName().equals(fileName)) {
						if (eachFile.isDirectory()) {
							System.out.println("Not allowed. ");
							return;
						} else {
							isFound = true;
							delF = eachFile.getName();
							Path fileToDeletePath = Paths.get(delF);
							Files.delete(fileToDeletePath);
							if (Files.notExists(eachFile.toPath())) {
								System.out.println(delF + " : File deleted successfully! ");
							} else {
								System.out.println(delF + " : Failed to delete the file. ");
							}
						}
					}
				}
				if (!isFound) {
					System.out.println("File not found! ");
				}
				isFound = false;
			}

			return;
		} catch (NoSuchFileException e) {
			System.out.println("No such file/directory exists");
			return;
		} catch (DirectoryNotEmptyException e) {
			System.out.println("Directory is not empty.");
			return;
		} catch (IOException e) {
			System.out.println("Invalid permissions.");
			return;
		}
	}

	// 3. Search/retrieved file
	protected static void searchFile(String fileName) throws Exception {
		// check case sensitive
		File dir = new File(currentDir);
		File[] files = dir.listFiles();
		try {
			if (!dir.exists()) {
				System.out.println("Directory not existed." + dir.getName());
			} else {
				// add files to array to check, check case sensitive
				System.out.println("Directory : " + currentDir);
				for (File eachFile : files) {
					if (eachFile.getName().equals(fileName)) {
						isFound = true;
						System.out.println("File found : " + eachFile.getName());
						//return;
					}
				}
				if (!isFound) {
					System.out.println(fileName + " file not found" + "\n");
					isFound = false;
				}
				isFound = false;
			}
			return;
		} catch (Exception e) {
			System.out.println("Invalid permissions.");
			return;
		}
	}
}
