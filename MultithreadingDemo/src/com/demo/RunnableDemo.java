package com.demo;

public class RunnableDemo implements Runnable{
	public RunnableDemo() {
		Thread t = new Thread(this, "Child Thread");
		t.start();
	}
	 
	@Override
	public void run() {
		try {
			for(int i=5;i>=0;i--) {
				System.out.println(Thread.currentThread().getName()+": "+i);
				System.out.println(Thread.currentThread().isAlive());
				//Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Child Exiting");
	}
	
	public static void main(String[] args) {
		RunnableDemo r =new RunnableDemo();
		
		try {
			for(int i=5;i>=0;i--) {
				System.out.println(Thread.currentThread().getName()+": "+i);
				//Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Main Exiting");
	
	}
}
