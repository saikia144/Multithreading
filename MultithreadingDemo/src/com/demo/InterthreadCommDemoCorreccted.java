package com.demo;

class Qu {
	int n;
	boolean valueSet = false;
	
	synchronized int get() {
		System.out.println(Thread.currentThread());
		while(!valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("GET: "+n);
		valueSet = false;
		notify();
		return n;
		
	}
	
	synchronized void put(int n) {
		System.out.println(Thread.currentThread());
		while(valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.n = n;
		valueSet = true;
		System.out.println("PUT: "+n);
		notify();	
	}
}

class Producer1 implements Runnable{
	Qu q;
	
	Producer1(Qu q){
		this.q = q;
		new Thread(this,"Producer").start();
	}
	
	@Override
	public void run() {
		int i = 0;
		while(i<5) {q.put(i++);}
	}
	
}

class Consumer1 implements Runnable{
	Qu q;
	
	Consumer1(Qu q){
		
		this.q = q;
		new Thread(this,"Consumer").start();
	}
	
	@Override
	public void run() {
		while(true) {
			q.get();
		}
	}
		
}

public class InterthreadCommDemoCorreccted {
	public static void main(String[] args) {
		Qu q = new Qu();
		
		Consumer1 c = new Consumer1(q);
		Producer1 p = new Producer1(q);
		
		//System.out.println(q instanceof Runnable);
	}
}
