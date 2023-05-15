package com.demo;

class Q {
	int n; 
	
	synchronized int get() {
		System.out.println("GOT: "+n);
		return n;
	}
	
	synchronized void put(int n) {
		this.n = n;
		System.out.println("PUT: "+n);
	}
}

class Producer implements Runnable {
	Q q;
	
	Producer(Q q){
		this.q = q;
		new Thread(this,"Producer").start();
	}

	@Override
	public void run() {
		int i = 0;
		while(true) {
			q.put(i++);
		}
	}
	
}

class Consumer implements Runnable {
	Q q;
	Consumer(Q q) {
		this.q = q;
		new Thread(this,"Consumer").start();
	}
	
	@Override
	public void run() {
		q.get();
	}
	
}

public class InterthreadComm {

	public static void main(String[] args) {
		Q q = new Q();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		
	}

}
