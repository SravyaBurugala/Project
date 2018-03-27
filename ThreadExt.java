package com.test.thread;

public class ThreadExt 
	{	
	public static class Even extends Thread
	{
		public Object obj=null;
		public Even(Object ob) {
			this.obj=ob;
		}
		public void run()
		{
		for(int i=0;i<10;i++)
		{	
			synchronized (obj)
			{
			if(i%2==0)
			{
				System.out.println("Even number is "+i);
				try {
					obj.notify();	
					obj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} }
			}
		}
	}
	
	public static class Odd extends Thread
	{
		public Object obj=null;
		public Odd(Object ob) {
			this.obj=ob;
		}
		public void run()
		{
		for(int i=0;i<10;i++)
		{	
			synchronized (obj)
			{
			if(i%2!=0)
			{
				System.out.println("Odd number is "+i);
				try {
					obj.notify();
					obj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	 }
		}
		}
	}

	public static void main(String[] args)
		{		
		Object ob=new Object();
        		
		Even ev=new Even(ob);
        Thread t1=new Thread(ev);
        
        Thread t2=new Thread(ev);
        
      //  Odd od=new Odd(ob);
      //  Thread t2=new Thread(od);
        
        //t1.start();
        t2.start();
        t1.start();
        
        
        
	}
}
