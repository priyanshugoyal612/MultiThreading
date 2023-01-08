package com.multithreading.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;

public class BoundCollection {

	private final Semaphore semaphore;

	private List<Integer> arrayList;

	public BoundCollection(int limit) {
		semaphore = new Semaphore(limit);
		this.arrayList = Collections.synchronizedList(new ArrayList<Integer>());
	}

	public boolean add(Integer i) throws InterruptedException {
		boolean added = false;
		semaphore.acquire();
		added = arrayList.add(i);
		if (!added) {
			semaphore.release();
		}
		return added;

	}

	public boolean remove(Integer i) throws InterruptedException {
		boolean removed = arrayList.remove(i);
		if (removed) {
			semaphore.release();
		}
		return removed;
	}

	public static void main(String[] args) {
		final BoundCollection boundCollection = new BoundCollection(10);

		new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				try {
					if(boundCollection.add(i))
					System.out.println(Thread.currentThread().getName() + " adding value " + i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		).start();
		
		new Thread(() -> {
			try {
				Thread.sleep(1000);
			
			for (int i = 0; i < 20; i++) {
					if(boundCollection.remove(i))
					System.out.println(Thread.currentThread().getName() + " removing value " + i);
				
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		).start();


	}

}
