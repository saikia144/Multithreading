/*In the context of threads in Java, "spawned" refers to the process of creating a new thread of execution.

When you create a new thread in Java by instantiating the Thread class and calling its start() method, 
a new thread of execution is spawned. This new thread runs independently from the main thread of the program, 
allowing multiple sections of code to be executed concurrently.

The Thread instance that was used to create the new thread is responsible for managing the new thread. 
It provides methods to start, stop, and wait for the new thread to complete its execution, 
as well as methods to communicate with the new thread and change its behavior.

Thread t = new Thread(a);

Thread.currentThread() will give a reference to the currently executing thread, in this case will be 't' which was used
to create and manage the current thread of execution
 */


package com.demo;

public class Demo extends Thread{
	
	void demoThread() {
		System.out.println(Thread.currentThread());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = Thread.currentThread();
		System.out.println("Before name change: "+t);

		t.setName("NewThreadOrder");
		System.out.println("After name change: "+t);

		try {
			for(int i=5;i>=0;i--) {
				System.out.println(i);
				Thread.sleep(1000,300);}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Main Thread Interrupted");
		}
		
		Demo d = new Demo();
		Thread t1 = new Thread(d);
		System.out.println(t1.getName() );
		d.demoThread();

	}

}
