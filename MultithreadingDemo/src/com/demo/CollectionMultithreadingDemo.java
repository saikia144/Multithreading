/*
 * Make the C class more flexible: The C class in this program is tightly
 * coupled to the ArrayList<Integer> data structure. You could make the class
 * more flexible by allowing the user to specify the type of the list when
 * creating an instance of C.
 * 
 * Use a BlockingQueue instead of a List: Using a BlockingQueue instead of an
 * ArrayList would simplify the code and make it more efficient. BlockingQueue
 * provides thread-safe methods for adding and removing elements, and
 * automatically blocks the threads when the queue is empty or full.
 * 
 * Use lambdas instead of Runnable: Instead of implementing the Runnable
 * interface, you could use lambda expressions to create instances of D and E.
 * This would make the code more concise and easier to read.
 * 
 * Use try-with-resources to handle exceptions: When using the wait() method,
 * it's important to properly handle InterruptedException. You could use a
 * try-with-resources block to ensure that the lock is released even if an
 * exception occurs.
 * 
 * Improve error handling: Currently, if an exception occurs in the dispValue()
 * or insertValue() methods, the stack trace is printed and the program
 * continues. It would be better to handle exceptions more gracefully, for
 * example by logging them or displaying an error message to the user.
 * 
 * These are just a few examples of how the program could be improved. There are
 * many other possible improvements depending on the specific requirements and
 * goals of the program.
 */



package com.demo;

import java.util.ArrayList;

class C {
	ArrayList<Integer> list;boolean setValue = false;
	int i_index = 0;int d_index = 0;
	C(ArrayList<Integer> list){
		this.list = list;
	}

	synchronized void dispValue() {
		while(!setValue) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(list.get(d_index));
		setValue = false;
		notify();
		d_index++;
	}

	synchronized void insertValue(int i) {
		while(setValue) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		list.add(i);
		System.out.println(list.get(i_index));
		setValue=true;
		notify();
		i_index++;
	}
}

//class D implements Runnable{
//	C c;
//	D(C c){
//		this.c = c;
//		new Thread(this).start();
//	}
//	@Override
//	public void run() {
//		int i = 0;
//		while( i < 5) {
//			c.insertValue(i++);
//		}
//	}
//}

class E implements Runnable{
	C c;

	E(C c){
		this.c =c;
		new Thread(this).start();
	}
	@Override
	public void run() {
		int i = 0;
		while(i<5) {
			c.dispValue();
		}
	}
}
public class CollectionMultithreadingDemo {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		//list.add(1);list.add(2);list.add(3);list.add(4);
		C c = new C(list);
		//D d = new D(c);
		new Thread(()->{
			int i = 0;
			while(i<5) {
				c.insertValue(i++);
			}
		}).start();
		E e = new E(c);
	}
}



