package com.test.thread;

public class ThreadImpl {

	public static class Even implements Runnable {

	    public Object mutex=null;
	    public Even(Object mutex) {
	        this.mutex=mutex;
	    }

	    @Override
	    public void run() {
	        synchronized (mutex) {
	            for (int i = 1; i <= 10; i++) {
	                if(i%2==0){
	                    System.out.println("Even: "+i);
	                    try {
	                        mutex.notify();
	                        mutex.wait();
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	    }
	}

	public static class OddThread implements Runnable{

	    public Object mutex=null;
	    public OddThread(Object mutex) {
	        this.mutex=mutex;
	    }

	    @Override
	    public void run() {
	        synchronized (mutex) {
	            for (int i = 1; i <= 10; i++) {
	                if(i%2==1){
	                    System.out.println("Odd: "+i);
	                    try {
	                        mutex.notify();
	                        mutex.wait();
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	    }
	}


	public static void main(String[] args) {
	        
	        Object mutex=new Object();
	        
	        Even et=new Even(mutex);
	        Thread t1=new Thread(et);
	        
	        OddThread ot=new OddThread(mutex);
	        Thread t2=new Thread(ot);
	        
	        t2.start();
	        t1.start();
	        
	    }

}
