package com.itrexgroup.konoplyanik.concurrency.service;

import com.itrexgroup.konoplyanik.concurrency.model.LandRover;

public class ThreadC extends Thread {
	private LandRover landRover;
	
	public ThreadC(LandRover landRover) {
		this.landRover = landRover;
	}
	
	@Override
	public void run() {
		try {
			landRover.landrover(() -> System.out.print("\"LandRover\""));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
