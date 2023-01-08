package com.multithreading.examples;

public class FastFoodRestaurentSynchronizedBlock {

	private String lastClientName;
	private int numberOfBurger;

	public void byBurger(String clientName) {
		alongRunningProcess();
		System.out.println("Client name who bought a number " + clientName);
		
		synchronized (this) {
			this.setLastClientName(clientName);
			setNumberOfBurger(getNumberOfBurger() + 1);
			
		}
		
		
		
	}

	public void alongRunningProcess() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getLastClientName() {
		return lastClientName;
	}

	public void setLastClientName(String lastClientName) {
		this.lastClientName = lastClientName;
	}

	public int getNumberOfBurger() {
		return numberOfBurger;
	}

	public void setNumberOfBurger(int numberOfBurger) {
		this.numberOfBurger = numberOfBurger;
	}

	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		FastFoodRestaurentSynchronizedBlock fastFoodRestaurent = new FastFoodRestaurentSynchronizedBlock();
		Thread t1 = new Thread(() -> {
			fastFoodRestaurent.byBurger("Priyanshu");
		});
		Thread t2 = new Thread(() -> {
			fastFoodRestaurent.byBurger("Shivanshu");
		});
		Thread t3 = new Thread(() -> {
			fastFoodRestaurent.byBurger("Atharv");
		});
		Thread t4 = new Thread(() -> {
			fastFoodRestaurent.byBurger("Apoorva");
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
		System.out.println("Total Number of burger sold " + fastFoodRestaurent.getNumberOfBurger());
		System.out.println("The last name of client " +fastFoodRestaurent.getLastClientName() );
		System.out.println("The execution time" + (System.currentTimeMillis()-startTime) + "in millisecond ");
	}

}
