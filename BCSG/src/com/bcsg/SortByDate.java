package com.bcsg;

import java.util.Comparator;

public class SortByDate implements Comparator<Account>
{
	//Sort the data by Expiry date in descending order
	
	 public int compare(Account a1, Account a2) 
	 {
	        return a2.getDate().compareTo(a1.getDate());
	 }
}