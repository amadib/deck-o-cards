package com.appian.cards.utils;

import java.math.BigInteger;
import java.util.Random;

public class Utils {
	
	public static boolean rightOrLeft(){
//		int d = (int) (Math.random() * 100);
//		System.out.println("random number is: " + d);
		return ( (int) (Math.random() * 100) % 2 == 0 ) ? true : false; 
	}
	
	private static int BITLENGTH = 17;
	static Random rnd = new Random();
	static int previous = (int)Math.random() ;
	public static int randomPostionBtw(int max){
		if (max == 0 ){
			return 0;
		}
		int e = (  BigInteger.probablePrime(BITLENGTH, rnd)).intValue() ;
		int d = ( (int) (Math.random() *(100)) * e % max);
		previous = d;
//		System.out.println("random number is: " + d );
		return d;
	}
	
	public static String padRight(String s, int n) {
	     return String.format("%1$-" + n + "s", s);  
	}
}
