package com.itrexgroup.konoplyanik.concurrency.model;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class LandRover {
	private final int n = inputFromConsole();
	
	private AtomicInteger count = new AtomicInteger(1);
	
    public void land(Runnable printLand) throws InterruptedException {
    	
    	while (count.get() <= n) {
    		int i = count.get();
			if (i % 3 == 0 && i % 5 != 0) {
				printLand.run();
				if (i == n) {
					System.out.print("]");
				} else {
					System.out.print(",");
				}
				count.incrementAndGet();
			}
		}
    }

    public void rover(Runnable printRover) throws InterruptedException {
    	
    	while (count.get() <= n) {
    		int i = count.get();
			if (i % 3 != 0 && i % 5 == 0) {
				printRover.run();
				if (i == n) {
					System.out.print("]");
				} else {
					System.out.print(",");
				}
				count.incrementAndGet();
			}
		}
    }

    public void landrover(Runnable printLandRover) throws InterruptedException {
    	
    	while (count.get() <= n) {
    		int i = count.get();
			if (i % 3 == 0 && i % 5 == 0) {
				printLandRover.run();
				if (i == n) {
					System.out.print("]");
				} else {
					System.out.print(",");
				}
				count.incrementAndGet();
			}
		}
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
    	
    	while (count.get() <= n) {
    		int i = count.get();
			if (i % 3 != 0 && i % 5 != 0) {
				printNumber.accept(i);
				if (i == n) {
					System.out.print("]");
				} else {
					System.out.print(",");
				}
				count.incrementAndGet();
			}
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
