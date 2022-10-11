package com.gl.notescounter.main;

import java.util.Scanner;
import com.gl.notescounter.util.ArrayUtil;

public class NotesCounter {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter no. of denominations");
			int noOfDenominations = scan.nextInt();
			int[] denominations = new int[noOfDenominations];
			System.out.println("Enter the " + noOfDenominations + " denominations each value > 0");
			for (int i = 0; i < noOfDenominations; i++) {
				denominations[i] = scan.nextInt();
				if (denominations[i] <= 0)
					throw new IllegalArgumentException("denomination <= zero not allowed");
			}
			ArrayUtil.mergeSort(denominations);
			System.out.println("Enter amount to pay");
			int amountToPay = scan.nextInt();
			int[] counter = new int[noOfDenominations];
			int amountRemaining = countNotes(denominations, counter, 0, denominations.length - 1, amountToPay);
			if (amountRemaining > 0) {
				System.out.println("Amount cannot be paid in the given denominations");
			} else {
				for (int i = noOfDenominations - 1; i >= 0; i--) {
					if (counter[i] > 0) {
						System.out.println(
								denominations[i] + " x :" + counter[i] + " = " + denominations[i] * counter[i]);
					}
				}
			}
		}
	}

	private static int countNotes(int[] denominations, int[] counter, int low, int high, int amountRemaining) {
		if (amountRemaining == 0)
			return amountRemaining;
		if (amountRemaining < denominations[0])
			return amountRemaining;
		if (amountRemaining >= denominations[high]) {
			counter[high] = amountRemaining / denominations[high];
			amountRemaining %= denominations[high];
			return countNotes(denominations, counter, 0, high - 1, amountRemaining);
		}
		int mid = (low + high) / 2;
		if (amountRemaining < denominations[mid]) {
			return countNotes(denominations, counter, 0, mid - 1, amountRemaining);
		}
		return countNotes(denominations, counter, 0, high - 1, amountRemaining);
	}
}
