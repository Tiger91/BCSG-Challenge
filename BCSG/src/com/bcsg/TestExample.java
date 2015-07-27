package com.bcsg;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;


public class TestExample 
{	
	public static void main(String[] args) 
	{
		Reader file = new Reader();
		
		//copy values from the file that are read and returned as List<Account> 
		//into new List<Account>
		List<Account> account = new ArrayList<Account>(file.read("mid-test.csv"));
		
		//sort in descending order by date
		Collections.sort(account, new SortByDate());
		
		
		//iterate through the list to display all accounts
		Iterator<Account> iterator = account.iterator();
		while (iterator.hasNext()) 
		{
			System.out.println(iterator.next());
		}
	}
	
	@Test//1
	public void read() throws FileNotFoundException
	{
		//Test if after reading a file it will display a list of accounts
		System.out.println("\nTest 1");
		
		//expectation
		List<Account> expected = new ArrayList<Account>();
		expected.add(new Account("HSBC Canada", "56xx-xxxx-xxxx-xxxx", "Nov-2017"));
		expected.add(new Account("Royal Bank of Canada", "4519-xxxx-xxxx-xxxx", "Oct-2017"));
		expected.add(new Account("American Express", "xxxx-xxxx-xxxx-345", "Dec-2018"));
		
		//actual result
		Reader file = new Reader();
		List<Account> result = new ArrayList<Account>(file.read("mid-test.csv"));
		
		//iterate through the list to display all accounts
		Iterator<Account> iterator = result.iterator();
		
		while (iterator.hasNext()) 
		{
			System.out.println(iterator.next());

		}
		
		assertEquals(expected.toString(), result.toString());
	}
	
	@Test//2
	public void testMaskedAccount()
	{
		//Test if account number is masked differently for different banks
		
		System.out.println("\nTest 2");
		
		Account a1 = new Account("HSBC Canada", "5601-2345-3446-5678", "Nov-2017");
		Account a2 = new Account("Royal Bank of Canada", "4519-4532-4524-2456", "Oct-2017");
		Account a3 = new Account("American Express", "3786-7334-8965-345", "Dec-2018");
		
		//expectations, account numbers to be masked
		String expected1 = "56xx-xxxx-xxxx-xxxx";
		String expected2 = "4519-xxxx-xxxx-xxxx";
		String expected3 = "xxxx-xxxx-xxxx-345";
		
		//results
		String result1 = a1.getAccount();
		String result2 = a2.getAccount();
		String result3 = a3.getAccount();
		
		System.out.println(result1 + "\n" + result2 + "\n" + result3);
		
		//Test HSBC Canada
		assertEquals(expected1, result1);
		assertEquals(expected2, result2);
		assertEquals(expected3, result3);
	}
	
	@Test//3
	public void testWithNewBank()
	{
		//Test if account number is masked when another bank name is given, apart from
		//those three specified in Account class
		
		System.out.println("\nTest3");
		
		Account account = new Account("HSBC UK", "5601-2345-3446-1234", "Nov-2017");
				
		String expected = "xxxx-xxxx-xxxx-1234"; //only last four digits displayed in this case
				
		String result = account.getAccount();
		
		System.out.println(result);
				
		assertEquals(expected, result);
	}
	
	@Test//4
	public void ifBankHasMultipleSpaces()
	{
		Account account = new Account("HSBC         Canada", "5601-2345-3446-5678", "Nov-2017");
		
		String expected = "HSBC Canada";
		String result = account.getBank();
		
		System.out.println("\nTest4\n" + result);
		
		assertEquals(expected, result);
	}
	
	@Test//5
	public void orderByDateDescending()
	{
		//Test if after reading csv file it will sort the data by expiry date in descending order
		System.out.println("Test 5");
		
		//expectation
		List<Account> expected = new ArrayList<Account>();
		expected.add(new Account("American Express", "xxxx-xxxx-xxxx-345", "Dec-2018"));
		expected.add(new Account("HSBC Canada", "56xx-xxxx-xxxx-xxxx", "Nov-2017"));
		expected.add(new Account("Royal Bank of Canada", "4519-xxxx-xxxx-xxxx", "Oct-2017"));
		
		//actual result
		Reader file = new Reader();
		List<Account> result = new ArrayList<Account>(file.read("mid-test.csv"));
		
		//sort in descending order by date
		Collections.sort(result, new SortByDate());
		
		//iterate through the list of result variable to display all accounts
		Iterator<Account> iterator = result.iterator();
		
		while (iterator.hasNext()) 
		{
			System.out.println(iterator.next());

		}
		
		assertEquals(expected.toString(), result.toString());
	}

}
