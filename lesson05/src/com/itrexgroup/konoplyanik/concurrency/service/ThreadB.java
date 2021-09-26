package com.itrexgroup.konoplyanik.concurrency.service;

import com.itrexgroup.konoplyanik.concurrency.model.LandRover;

public class ThreadB extends Thread {
	private LandRover landRover;
	
	public ThreadB(LandRover landRover) {
		this.landRover = landRover;
	}
	
	@Override
	public void run() {
		try {
			landRover.rover(() -> System.out.print("\"Rover\""));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
