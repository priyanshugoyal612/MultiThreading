package com.multithreading.examples;

import java.util.stream.IntStream;

public class SupervisorRunnableLamdaExample {

	public static int[] number = IntStream.rangeClosed(0, 5000).toArray();
	public static int total = IntStream.rangeClosed(0, 5000).sum();
	public static int sum = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < number.length / 2; i++) {
				add(number[i]);
			}

		});

		Thread thread2 = new Thread(() -> {
			for (int i = number.length / 2; i < number.length; i++) {
				add(number[i]);
			}

		});
		thread1.start();
		thread2.start();
		// Thread.sleep(10000);

		thread1.join();//
		thread2.join();

		System.out.println(sum);
		System.out.println(total);

	}

	public synchronized static void add(int add) {
		sum = sum + add;

	}
}
