package com.bcsg;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;


public class TestExample 
{
	//Test if file not found it will throw an exception
	@Test(expected = FileNotFoundException.class)
	public void fileNotFound() throws FileNotFoundException
	{
		Reader file = new Reader();
		List<Account> account = new ArrayList<Account>(file.read("noFile.csv"));
	}
	
	//Test if after reading a file it will display a list of accounts
	@Test
	public void read() throws FileNotFoundException
	{
		Reader file = new Reader();
		List<Account> expected = new ArrayList<Account>(file.read("mid-test.csv"));
		
		List<Account> result = new ArrayList<Account>();
		result.add(new Account("HSBC Canada", "5601-2345-3446-5678", "Nov-2017"));
		result.add(new Account("Royal Bank of Canada", "4519-4532-4524-2456", "Oct-2017"));
		result.add(new Account("American Express", "3786-7334-8965-345", "Dec-2018"));
		
		//iterate through the list to display all accounts
		Iterator<Account> iterator = result.iterator();
		while (iterator.hasNext()) 
		{
			System.out.println(iterator.next());

		}
		
		assertEquals(expected.toString(), result.toString());
	}
	

}
