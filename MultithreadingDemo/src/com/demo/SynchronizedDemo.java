package com.demo;

public class SynchronizedDemo implements Runnable{
	synchronized void call(String msg) {
		System.out.print("["+msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("]");
	}
	
	@Override
	public void run() {
		this.call("Hello");
		
	}

	public static void main(String[] args) {
		SynchronizedDemo obj = new SynchronizedDemo();
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		Thread t3 = new Thread(obj);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main Thread exited");
	}

}
