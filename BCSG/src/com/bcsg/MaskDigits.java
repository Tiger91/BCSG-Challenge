package com.bcsg;

public class MaskDigits 
{
	
	// Each card number must be masked
	
	public static String mask(String number, String mask)
	{
		int index = 0;
	    
		StringBuilder masked = new StringBuilder();
	      
	    //remove hyphen if it is there
	    if(number.contains("-"))
	    {
	    	number = number.replaceAll("-", "");
	    }
	    
	    for (int i = 0; i < mask.length(); i++) 
	    {
	    	char c = mask.charAt(i);
	    	
	        if (c == '#') 
	        {
	        	masked.append(number.charAt(index));
	            ++index;
	        } 
	        else if (c == 'x') 
	        {
	            masked.append(c);
	            index++;
	        } 
	        else 
	        {
	            masked.append(c);
	        }
	    }
	    
	    return masked.toString();
		
	}
}
