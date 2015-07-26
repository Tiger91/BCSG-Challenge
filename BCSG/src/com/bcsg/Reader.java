package com.bcsg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Write a program that read the data from the supplied CSV file and output
//This class reads a csv file and returns contents as list of accounts
public class Reader 
{
	
	public List<Account> read(String fileName) throws FileNotFoundException
	{
		String line = ""; //declare line
		
		List<Account> account = new ArrayList<Account>();

		try 
		{
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			

			while( (line = file.readLine()) != null)
			{
				String[] row = line.split(",");
				
				//each line in csv file should have
				//3 values which are bank, account and expiry date
				//if less or more it's ignored
				if(row.length == 3)
				{
					//add values to list
					account.add(new Account(row[0], row[1], row[2]));
				}
				
			}//end while
			
			//close file to prevent leak
			file.close();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			System.out.println("File Not Found: " + fileName);
			
			throw e;
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return account;
	}
}
