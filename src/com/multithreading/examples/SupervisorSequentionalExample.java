package com.multithreading.examples;

//Sequentinal Threading  
public class SupervisorSequentionalExample {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		Worker1 worker1 = new Worker1();
		Worker2 worker2 = new Worker2();
		try {
			worker1.execute();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		worker2.execute();
		

	}

}

class  Worker1 {
	
	public void execute() throws InterruptedException
	{
		for(int i=0;i<10;i++)
		{
			Thread.sleep(1000);
			System.out.println("Worker 1 is  executing task  :" + i);
		}
	}
	
	
}

class Worker2 {
	
	
	public void execute() 
	{
		for(int i=0;i<10;i++)
		{
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