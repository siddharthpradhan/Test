package com.siddharth.test.QuickTest;

import java.util.Date;
import java.util.Random;

public class RoughWork {
	
	public long fileName;

	public long random()
	{
		long randomText = new Date().getTime(); 
		return this.fileName = randomText;
	}
	
	public static void main(String[] args) {
		
		RoughWork obj = new RoughWork();
		obj.random();
		

		System.out.println(Random.class+".txt");
	}

}
