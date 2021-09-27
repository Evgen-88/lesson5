package com.itrexgroup.konoplyanik.concurrency.service;

import java.util.Scanner;
import java.util.function.IntConsumer;

public class LandRover {
	private final int n = inputFromConsole();
	private boolean isRunning = true;
	private volatile int count = 1;

	public void land(Runnable printLand) throws InterruptedException {

		while (isReady()) {
			if (count % 3 == 0 && count % 5 != 0) {
				printLand.run();
				if (count == n) {
					System.out.print("]");
				} else {
					System.out.print(",");
				}
				synchronized (this) {
					count++;
				}
			}
		}
	}

	public void rover(Runnable printRover) throws InterruptedException {

		while (isReady()) {
			if (count % 3 != 0 && count % 5 == 0) {
				printRover.run();
				if (count == n) {
					System.out.print("]");
				} else {
					System.out.print(",");
				}
				synchronized (this) {
					count++;
				}
			}
		}
	}

	public void landrover(Runnable printLandRover) throws InterruptedException {

		while (isReady()) {
			if (count % 3 == 0 && count % 5 == 0) {
				printLandRover.run();
				if (count == n) {
					System.out.print("]");
				} else {
					System.out.print(",");
				}
				synchronized (this) {
					count++;
				}
			}
		}
	}

	public void number(IntConsumer printNumber) throws InterruptedException {

		while (isReady()) {
			if (count % 3 != 0 && count % 5 != 0) {
				printNumber.accept(count);
				if (count == n) {
					System.out.print("]");
				} else {
					System.out.print(",");
				}
				synchronized (this) {
					count++;
				}
			}
		}
	}
	
	private synchronized boolean isReady() {
		if (count > n) {
			return isRunning =  false;
		} else {
			return isRunning;
		}
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
