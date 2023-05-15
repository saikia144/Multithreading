package com.demo;

public class JoinAndIsAliveDemo implements Runnable{
	Thread t; String name;
	
	public JoinAndIsAliveDemo(String threadName) {
		name = threadName;
		t = new Thread(this, name);
		System.out.println("New Thread: "+t);
		t.start();
	}
	@Override
	public void run() {
		try {
			for(int i=5;i>0;i--) {
				System.out.println(name+" : "+i);
				//Thread.sleep(1000);
				Thread.yield();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(name+" exiting");
	}

	public static void main(String[] args) {
		
		JoinAndIsAliveDemo o1 =new JoinAndIsAliveDemo("one");
		JoinAndIsAliveDemo o2 = new JoinAndIsAliveDemo("two");
		JoinAndIsAliveDemo o3 = new JoinAndIsAliveDemo("three");
		
		System.out.println(o1.t.isAlive());
		System.out.println(o2.t.isAlive());
		System.out.println(o3.t.isAlive());
		System.out.println(Thread.currentThread().isAlive());
		
		//Waiting for the child threads to finish execution and after execution join the calling thread(i.e. main)
		try {
			o1.t.join();
			o2.t.join();
			o3.t.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exiting main");

	}

}
