package com.appian.cards.utils;

import java.math.BigInteger;
import java.util.Random;

import org.apache.log4j.Logger;

public class Utils {
	private static final Logger logger = Logger.getLogger(Utils.class);	

	/**
	 * Returns true or false at random.
	 * 
	 * @return true or false randomly
	 */
	public static boolean rightOrLeft(){
		int d = (int) (Math.random() * 100);
		logger.debug("random number is: " + d);
		return ( d % 2 == 0 ) ? true : false; 
	}
	
	/**
	 * Returns a random number between a range; bounded by 0 and {@code max}.
	 * 
	 * Randomly selects a number between 0-100, and uses the number to get a large prime number.
	 * Multiplies the prime number and the random number, takes the absolute  
	 * value of the product and modulo {@code max}.   
	 * 
	 * @param max - the ceiling of randomly  
	 * @return 0 if the maximum number is 0; 
	 */
	public static int randomPostionBtwn(int max){
		if (max == 0 ){
			logger.debug("randomPostionBtwn 0-" + padLeft(max + "", 2) +"  => " + 0);
			return 0;
		}
		Random rnd = new Random();
		int randomNumber = (int) (Math.random() *(100)) ;
		int BITLENGTH = randomNumber + 2;
		int prime = (BigInteger.probablePrime(BITLENGTH, rnd)).intValue() ;
		int randomPositionBtwn = Math.abs((randomNumber * prime) % max);
		logger.debug("random number is: " + padLeft(randomNumber +"" , 2)
				+ ", the prime number:" + padLeft(prime+"", 7)
				+ ", randomPostionBtwn 0-" + padLeft(max + "", 2) +"  => " + padLeft(randomPositionBtwn + "", 2));
		return Math.abs(randomPositionBtwn);
	}
	
	
	public static String padRight(String s, int n) {
	     return String.format("%1$-" + n + "s", s);  
	}
	
	public static String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s);  
	}

}
