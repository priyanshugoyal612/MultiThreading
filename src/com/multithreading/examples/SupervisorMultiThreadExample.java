package com.multithreading.examples;

//Multi thread Threading  
public class SupervisorMultiThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MultiWorker1 worker1 = new MultiWorker1();
		MultiWorker2 worker2 = new MultiWorker2();
		worker1.start();
		worker2.start();

	}

}

class MultiWorker1 extends Thread {

	@Override
	public void run() {
	
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Worker 1 is  executing task  :" + i);
		}
	}

	
}

class MultiWorker2 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Worker 2 is  executing task  :" + i);
		}
		
	}

}