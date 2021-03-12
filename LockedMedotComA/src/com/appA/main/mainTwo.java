package com.appA.main;

import java.util.Scanner;

public class mainTwo {

	static clsTwo classTwo = new clsTwo();
	static clsOne classOne = new clsOne();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		int option;

		try {
			while (true) {
				clsTwo.showMenuOpt2();
				while (!sc.hasNextInt()) {
					sc.next();
					System.out.println("\nInvalid input. Please enter selection again.");
					clsTwo.showMenuOpt2();
				}
				option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("\n-------- Add file ---------");
					System.out.println("Enter file location: ");
					String f1 = sc1.nextLine();
					classTwo.addfile(f1);
					System.out.println();
					break;
				case 2:
					System.out.println("\n-------- Delete file ---------");
					System.out.println("Enter fileName : ");
					String f2 = sc2.nextLine();
					clsTwo.deleteFile(f2);
					// classOne.displayFile();
					System.out.println();
					break;
				case 3:
					System.out.println("\n-------- Search file ---------");
					System.out.println("Enter fileName : ");
					String f3 = sc3.nextLine();
					clsTwo.searchFile(f3);
					System.out.println();
					break;
				case 4:
					System.out.println("\n-------- Back to Main ---------");
					mainCls.main(args);
					break;
				default:
					System.out.println("\nInvalid selection.");
					System.out.println();
				}
			}
		} catch (Exception e) {
			return;
		} finally {
			sc.close();
			sc1.close();
			sc2.close();
			sc3.close();
		}

	}

}
