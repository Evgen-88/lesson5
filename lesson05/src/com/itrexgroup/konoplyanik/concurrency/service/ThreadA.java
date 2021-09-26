package com.itrexgroup.konoplyanik.concurrency.service;

import com.itrexgroup.konoplyanik.concurrency.model.LandRover;

public class ThreadA extends Thread {
	private LandRover landRover;
	
	public ThreadA(LandRover landRover) {
		this.landRover = landRover;
	}
	
	@Override
	public void run() {
		try {
			landRover.land(() -> System.out.print("\"Land\""));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
