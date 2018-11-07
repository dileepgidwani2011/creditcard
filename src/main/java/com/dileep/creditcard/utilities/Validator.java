package com.dileep.creditcard.utilities;

import com.dileep.creditcard.model.CacheManagement;

/**
 * Validator is a validator utility
 * @author dileep
 *
 */
public class Validator {
	
	private static String DIGITREGEX = "\\d+";
	
	/**
	 * This method validates the card based on luhn algorithm
	 * @param cardnumber
	 * @return
	 */
	public static boolean validateCardNumber(String cardnumber)
	{
		boolean flag = true;
		
		int nDigits = cardnumber.length(); 
		  
	    int nSum = 0; 
	    boolean isSecond = false; 
	    for (int i = nDigits - 1; i >= 0; i--)  
	    { 
	  
	        int d = Integer.parseInt(cardnumber.charAt(i)+"");
	  
	        if (isSecond == true) 
	            d = d * 2; 
	        
	        nSum += d / 10; 
	        nSum += d % 10; 
	        
	        System.out.println(d);
	  
	        isSecond = !isSecond; 
	    } 
	    
	    flag = nSum % 10 == 0;
	    
	    if (!flag)
	    {
	    	System.out.println(cardnumber + "Number is not valid as per Luhn 10");
	    }
	    
	    return flag;
	}
	
	/**
	 * This method verifies the cardnumber contains only digits
	 * @param cardnumber
	 * @return
	 */
	public static boolean verifyRegex(String cardnumber)
	{
		boolean flag = true;
		
		if (!cardnumber.matches(DIGITREGEX))
		{
			System.out.println("Number doesn't match the regex");
			flag = false;
		}
		
		return flag;
	}
	
	/**
	 * This method checks if cardnumber already exists
	 * @param cardnumber
	 * @return
	 */
	public static boolean isExists(String cardnumber)
	{
		boolean flag = true;
		
		if (CacheManagement.getMap().containsKey(cardnumber))
		{
			System.out.println("Number already exist");
			flag = false;
		}
		return flag;
	}

}
