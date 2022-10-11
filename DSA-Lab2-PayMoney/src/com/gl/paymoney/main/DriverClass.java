package com.gl.paymoney.main;

import java.util.Scanner;

public class DriverClass {

	private static int getNoOfTransactions(int[] transArray, int target) {
		int sum = 0;
		for (int i = 0; i < transArray.length; i++) {
			sum += transArray[i];
			if (sum >= target) {
				return i + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter number of transactions");
		int noOfTrans = scan.nextInt();
		int[] transArray = new int[noOfTrans];
		System.out.println("Enter the transaction values");
		for (int i = 0; i < noOfTrans; i++) {
			transArray[i] = scan.nextInt();
		}
		System.out.println("Enter the number of targets");
		int noOfTargets = scan.nextInt();

		for (int i = 0; i < noOfTargets; i++) {
			System.out.println("Enter the target " + (i + 1) + ": ");
			int target = scan.nextInt();
			int transCount = getNoOfTransactions(transArray, target);
			if (transCount < 0) {
				System.out.println("Target not achieved");
			} else {
				System.out.println("Target achieved in " + transCount + " transactions");
			}

		}
	}
}
