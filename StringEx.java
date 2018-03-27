package com.test.thread;

public class StringEx {

	public static void main(String[] args) {

		String s1="abc";
		String s2="abc";

		System.out.println(s1==s2);
		
		String s3=s1.concat("hai");		
		System.out.println("s3 is "+s3);
		
		String s4=new String("abc");
		String s5=new String("abc");
		
		System.out.println("s4 is equal to s5"+(s4==s5));
		System.out.println("s4 is equal to s5"+(s4==s1));
		s4.concat("How r u");
		//System.out.println("s4 is "+s4);
	
	}

}
