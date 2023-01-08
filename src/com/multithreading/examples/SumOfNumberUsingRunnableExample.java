package com.multithreading.examples;

import java.util.stream.IntStream;

public class SumOfNumberUsingRunnableExample {

	public static int[] numbers = IntStream.rangeClosed(0, 5000).toArray();
	public static int sum = 0;
	public static int total = IntStream.rangeClosed(0, 5000).sum();

	public static void main(String args[]) throws InterruptedException {
		
		WorkerRunnable1 wor = new WorkerRunnable1(numbers);

		WorkerRunnable2 wor2 = new WorkerRunnable2(numbers);
		Thread thread1 = new Thread(wor);
		Thread thread2 = new Thread(wor2);
		thread1.start();
		thread2.start();
		thread1.join();
			thread2.join();
		
		
		
		System.out.println(sum);
		System.out.println(total);
		

	}

	

	public static void addTotal(int toAdd) {
		sum = sum + toAdd;
	}

}

class WorkerRunnable1 implements Runnable {
	
	private int[] array;
	private int sum=0;

	public WorkerRunnable1(int [] array) {
		this.array=array;
	}

	@Override
	public void run() {

		for (int i = 0; i < array.length / 2; i++) {
			sum=sum+array[i];

		}

		SumOfNumberUsingRunnableExample.addTotal(sum);

	}

}

class WorkerRunnable2 implements Runnable {


	private int[] array;
	private int sum=0;

	public WorkerRunnable2(int [] array) {
		this.array=array;
	}

	@Override
	public void run() {

		for (int i = array.length / 2; i < array.length; i++) {
			sum=sum+array[i];

		}
		SumOfNumberUsingRunnableExample.addTotal(sum);

	}

}
