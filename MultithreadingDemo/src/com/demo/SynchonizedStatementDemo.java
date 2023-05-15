package com.demo;

import java.lang.reflect.Constructor;

class callMe{
	void call(String s) {
		System.out.print("["+s);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("]");
	}
}

class Caller implements Runnable{
	
	callMe target;String s; Thread t;
	
	public Caller(callMe target, String s) {
		this.target = target;
		this.s = s;
		t = new Thread(this);
		t.start();
	}
	public void run() {
		synchronized (target) {
			target.call(s);
		}
	}
	
	void a() {
		int i = 'l';
		short s = 28;
	}
}
public class SynchonizedStatementDemo {

	public static void main(String[] args) throws InterruptedException {
		
		callMe ob1 = new callMe();
		Caller c1 = new Caller(ob1, "Hello");
		Caller c2 = new Caller(ob1, "Parthajeet");
		Caller c3 = new Caller(ob1, "Saikia");
		
		c1.t.join();c2.t.join();c3.t.join();
		
		Class<Caller> cls = Caller.class;
		Constructor<?>[] con = cls.getConstructors();
		
		System.out.println(con.getClass().getClassLoader());
		
		
		
		 
		
		
		
		
	}

}
