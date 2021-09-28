package com.itrexgroup.konoplyanik.concurrency.service;

import java.util.Scanner;

public class InputService {
	private int n = inputFromConsole();
	
	public int getN() {
		return n;
	}
	
	private int inputFromConsole() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Type number from 1 to 50: ");
		int n = 0;
		while (n < 1 || n > 50) {
			while (!scanner.hasNextInt()) {
				System.out.println("Incorrect intut. Try again: ");
				scanner.nextLine();
			}
			n = scanner.nextInt();
			if (n < 1 || n > 50) {
				System.out.println("Incorrect intut. Try again: ");
			}
		}
		return n;
	}
}
