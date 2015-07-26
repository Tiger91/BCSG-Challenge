package com.bcsg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Account 
{
	private String bank;
	private String account;
	private Date date;

	public Account(String bank, String account, String date)
	{
		this.bank = bank;
		this.account = account;
		this.date = stringToDate(date);
	}
	
	public String getAccount() {
		return account;
	}
	
	public String getBank() {
		return bank;
	}

	
	public Date getDate() {
		return date;
	}
	


	//convert from String to Date
	public Date stringToDate(String d)
	{
		SimpleDateFormat format = new SimpleDateFormat("MMM-yyyy");
		
		Date date = new Date();
		
		try 
		{
			date = format.parse(d);
		} 
		catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
	}

	public String toString()
	{
		//display date back to initially given format, i.e., month and year
		SimpleDateFormat format = new SimpleDateFormat("MMM-yyyy");
		
		return getBank() + " " + getAccount() + " " + format.format(getDate());
	}
	

}
