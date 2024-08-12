package com.project.utility;

import java.util.Random;

public class Util {

	 char[] password =null;
	public   String getOTP()
	{
		 String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
	        String numbers = "0123456789";
	        String values = Capital_chars + Small_chars +
                    numbers;
		Random r=new Random();
		  password = new char[4];
		for(int i=0;i<4;i++)
		{
			 password[i] =
		              values.charAt(r.nextInt(values.length()));
		}
		String otp="";
		for(int k=0;k<password.length;k++)
		{
			
			otp=otp+password[k];
		}
		System.out.println(otp);
		return otp;
	}
	
	
	
	public static void main(String[] args) {
		Util u=new Util();
		u.getOTP();
		
	}
	
}
