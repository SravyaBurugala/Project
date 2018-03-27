package com.test.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.test.thread.ThreadExt.Even;
import com.test.thread.ThreadExt.Odd;

public class ThreadEventExec {
	
//	public static boolean eventFlag=false;
	/*public static class Even 
	{
		public Object obj=null;
		public Even(Object ob) {
			this.obj=ob;
		}
		public void run()
		{
			
		for(int i=0;i<10;i++)
		{	
		//	while(!eventFlag)	{
			synchronized (obj)
			{
			if(i%2==0)
			{
				System.out.println("Even number is "+i);
				 System.out.println(Thread.currentThread().getName()+ "Current value is"+ i);
				// System.out.println(eventFlag);
				 obj.notify();
					
                 try {
					obj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}	}
			}//eventFlag=false;}
		}
	}
	
	public static class Odd 
	{
		public Object obj=null;
		public Odd(Object ob) {
			this.obj=ob;
		}
		public void run()
		{
		//	while(eventFlag)			{
		for(int i=0;i<10;i++)
		{	
			synchronized (obj)
			{
			if(i%2!=0)
			{
				System.out.println("Odd number is "+i);
				 System.out.println(Thread.currentThread().getName()+ "Current value is"+ i);
				// System.out.println(eventFlag);
				 obj.notify();
					
				try {
					obj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	}
		}//eventFlag=true;}
		}
	}*/

	public static void main(String[] args)
		{		
		Object ob=new Object();
        		
		Runnable ev=() ->{
			for(int i=0;i<10;i++)
			{	
			//	while(!eventFlag)	{
				synchronized (ob)
				{
				if(i%2==0)
				{
					System.out.println("Even number is "+i);
					 System.out.println(Thread.currentThread().getName()+ "Current value is"+ i);
					// System.out.println(eventFlag);
					 ob.notify();
						
	                 try {
						ob.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}	}
				}
		};        
        Runnable od=()->{
        	for(int i=0;i<10;i++)
    		{	
    			synchronized (ob)
    			{
    			if(i%2!=0)
    			{
    				System.out.println("Odd number is "+i);
    				 System.out.println(Thread.currentThread().getName()+ "Current value is"+ i);
    				// System.out.println(eventFlag);
    				 ob.notify();
    					
    				try {
    					ob.wait();
    				} catch (InterruptedException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}	}
    		}
        };
        
       // Executor ex = Executors.newFixedThreadPool(2);
        ExecutorService es = Executors.newFixedThreadPool(2);
		        
        es.execute(od);
        es.execute(ev);
       
       es.shutdown();
        
	}
}
