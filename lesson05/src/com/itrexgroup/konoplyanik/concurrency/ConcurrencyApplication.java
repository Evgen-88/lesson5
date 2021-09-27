package com.itrexgroup.konoplyanik.concurrency;

import com.itrexgroup.konoplyanik.concurrency.service.LandRover;
import com.itrexgroup.konoplyanik.concurrency.service.ThreadA;
import com.itrexgroup.konoplyanik.concurrency.service.ThreadB;
import com.itrexgroup.konoplyanik.concurrency.service.ThreadC;
import com.itrexgroup.konoplyanik.concurrency.service.ThreadD;

public class ConcurrencyApplication {

	public static void main(String[] args) throws InterruptedException {
		LandRover landRover = new LandRover();

		Thread threadA = new ThreadA(landRover);
		Thread threadB = new ThreadB(landRover);
		Thread threadC = new ThreadC(landRover);
		Thread threadD = new ThreadD(landRover);
		
		System.out.print("[");
		
		threadA.start();
		threadB.start();
		threadC.start();
		threadD.start();

	}

}
