package com.demo;

class B{}

public class NewThread implements Runnable{
	Thread t;
	
	public NewThread() {
		System.out.println("Inside constructor---> "+Thread.currentThread());
		t = new Thread(this, "Child Thread");
		System.out.println("Child Thread: "+t);
		t.start();
	}
	@Override
	public void run() {
		System.out.println("Inside run---> "+Thread.currentThread());
		try {
			for(int i=5;i>=0;i--) {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(100);}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Main Thread Interrupted");
		}
	}
	public static void main(String[] args) {
		new NewThread();
		System.out.println("Inside Main----> "+Thread.currentThread());
		try {
			for(int i=5;i>=0;i--) {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(1000,300);}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Main Thread Interrupted");
		}
	}
}
