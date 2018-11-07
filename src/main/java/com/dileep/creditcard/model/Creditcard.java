package com.dileep.creditcard.model;

/**
 * Creditcard is a POJO class
 * @author dileep
 *
 */
public class Creditcard 
{
	private String name;
	private String cardnumber;
	private int balance;
	private String limit;
	
	public Creditcard(String name, String cardnumber, String limit) 
	{
		this.name = name;
		this.cardnumber = cardnumber;
		this.balance = 0;
		this.limit = limit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}
	
	

}
