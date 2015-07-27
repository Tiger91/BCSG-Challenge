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
		setBank(bank);
		setAccount(bank, account);
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
	
	public void setBank(String bank)
	{
		//if in csv file bank name has a more than single space, trim into single space
		this.bank = bank.trim().replaceAll(" +"," ");
	}
	
	public void setAccount(String bank, String account)
	{
		//different banks mask account number differently
		//if new bank is added only last four digits will be masked by default,
		//unless otherwise required
		
		//if in csv file bank name has a more than single space, trim into single space
		bank = bank.trim().replaceAll(" +"," ");
		
		if(account.length() == 19) //length of digits including hyphen(-)
		{
		 this.account = MaskDigits.mask(account, "xxxx-xxxx-xxxx-####");
		}
		if(bank.equals("HSBC Canada"))
		{
			
			this.account = MaskDigits.mask(account, "##xx-xxxx-xxxx-xxxx");
		}
		
		if(bank.equals("Royal Bank of Canada"))
		{
			this.account = MaskDigits.mask(account, "####-xxxx-xxxx-xxxx");
		}
		
		if(bank.equals("American Express"))
		{
			this.account = MaskDigits.mask(account, "xxxx-xxxx-xxxx-###");
		}
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
