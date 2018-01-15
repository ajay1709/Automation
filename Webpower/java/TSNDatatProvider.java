package com.Webpower.Webpower;


import org.testng.annotations.DataProvider;

public class TSNDatatProvider {
	
	@DataProvider(name = "TSN_Website")

	public static Object[][] websites() {

	      return new Object[][] {  
	    	  
	    	  { "firefox", "https://acorntire.com/"} ,
//	    	  { "firefox", "http://brookshuff.com/" }
	    	  
	    	  };

	}
}

