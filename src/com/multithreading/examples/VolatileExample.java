package com.multithreading.examples;

public class VolatileExample {

	public static  volatile boolean flag = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 2000; i++) {
				System.out.println("Value of i" + i);

			}
			flag = true;
			System.out.println("Falg Value is  " + flag);
		}

		);
		Thread t2 = new Thread(() -> {

			int i = 1;
			while (!flag) {
				++i;

			}
			System.out.println("The value of i in the second thread is " + i);

		}

		);

		t1.start();
		t2.start();

	}

}
