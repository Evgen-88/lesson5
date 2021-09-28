package com.itrexgroup.konoplyanik.concurrency.service;

import java.util.function.IntConsumer;

public class LandRover {
	private final int n;
	private boolean isRunning = true;
	private volatile int count = 1;
	
	public LandRover(int n) {
		this.n = n;
	}

	public void land(Runnable printLand) throws InterruptedException {

		while (isReady()) {
			if (count % 3 == 0 && count % 5 != 0) {
				printLand.run();
				addDelimiter();
				incrementCount();
			}
		}
	}

	public void rover(Runnable printRover) throws InterruptedException {

		while (isReady()) {
			if (count % 3 != 0 && count % 5 == 0) {
				printRover.run();
				addDelimiter();
				incrementCount();
			}
		}
	}

	public void landrover(Runnable printLandRover) throws InterruptedException {

		while (isReady()) {
			if (count % 3 == 0 && count % 5 == 0) {
				printLandRover.run();
				addDelimiter();
				incrementCount();
			}
		}
	}

	public void number(IntConsumer printNumber) throws InterruptedException {

		while (isReady()) {
			if (count % 3 != 0 && count % 5 != 0) {
				printNumber.accept(count);
				addDelimiter();
				incrementCount();
			}
		}
	}
	
	// гарантирует завершение циклов по достижении предельного значения каунтера (чтобы потоки не захватывали значения сверх лимита)
	private synchronized boolean isReady() {
		if (count > n) {
			return isRunning =  false;
		} else {
			return isRunning;
		}
	}
	
	private void addDelimiter() {
		if (count == n) {
			System.out.print("]");
		} else {
			System.out.print(",");
		}
	}
	
	// в связке с volatile гарантирует последовательное приращение каунтера
	private synchronized void incrementCount() {
		count++;
	}

}
