package com.multithreading.examples;

public class MultithreadingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread("Thread 1");

		Thread t2 = new Thread("Thread 2");
		
		t1.start();
		t2.start();
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		

	}

}
