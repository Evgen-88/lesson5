package com.itrexgroup.konoplyanik.concurrency.service;

import com.itrexgroup.konoplyanik.concurrency.model.LandRover;

public class ThreadD extends Thread {
	private LandRover landRover;
	
	public ThreadD(LandRover landRover) {
		this.landRover = landRover;
	}

	@Override
	public void run() {
		try {
			landRover.number(System.out::print);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
