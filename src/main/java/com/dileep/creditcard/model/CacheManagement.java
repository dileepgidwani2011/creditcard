package com.dileep.creditcard.model;

import java.util.concurrent.ConcurrentHashMap;

/**
 * CacheManagement is to store the creditcard details
 * @author dileep
 *
 */
public class CacheManagement {
	
	private static ConcurrentHashMap<String, Creditcard> map = new ConcurrentHashMap<String, Creditcard>();
	
	/**
	 * this method add the creditcard object to map
	 */
	public static boolean addCreditcard(Creditcard creditcard)
	{
		boolean flag = true;
		
		if (map.containsKey(creditcard.getCardnumber()))
		{
			flag = false;
		}
		else
		{
			map.put(creditcard.getCardnumber(), creditcard);
		}
		
		return flag;
	}
	
	/**
	 * this method return the map
	 */
	public static ConcurrentHashMap<String, Creditcard> getMap() {
		return map;
	}

	/**
	 * this method set the map
	 */
	public static void setMap(ConcurrentHashMap<String, Creditcard> map) {
		CacheManagement.map = map;
	}
	
	

}
