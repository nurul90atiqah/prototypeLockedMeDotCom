package com.appA.main;

import java.util.Scanner;

public class mainCls {

	public static void main(String[] args) {

		clsOne classOne = new clsOne();
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int option;

		while (true) {
			clsOne.showMenu();
			while (!sc.hasNextInt()) {
				sc.next();
				System.out.println("\nInvalid input. Please enter selection again.");
				clsOne.showMenu();
			}
			option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.println("\n-------- Option 1 ----------");
				classOne.displayFile();
				System.out.println();
				break;
			}
			case 2: {
//				System.out.println("\n-------- Option 2 ----------");
				mainTwo.main(args);
				System.out.println();
				break;
			}
			case 3: {
				System.out.println("\nApplication is existing. ");
				sc.close();
				sc1.close();
				System.exit(0);
				break;
			}
			default:
				System.out.println("\nInvalid selection. Please select again");
				break;
			}
		}

	}

}
