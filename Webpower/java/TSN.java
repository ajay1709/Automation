package com.Webpower.Webpower;

import org.testng.Assert;
import org.testng.annotations.Test;
public class TSN {

	
TSNUtilities util = new TSNUtilities();


@Test (dataProvider = "TSN_Website" ,  dataProviderClass = TSNDatatProvider.class)

public void rquestQuote_Size(String browser ,String site) 
{	  

  try
	  {   
		  util.loadProperties(); 
		  Thread.sleep(500);
		  util.openWebBrowser(browser , site);
		  Thread.sleep(500);
		  util.selectBySize("275","65","20");
		  Thread.sleep(500);
		  util.requestQuote();
		  Thread.sleep(500);
		  util.Appointment ("size","2017" , "Acura" ,"ILX" ,"Base");
		  Thread.sleep(500);
		  util.contactInfo("FSIZE" , "LSIZE" , "1234567890", "size@test.com");
		  Assert.assertTrue(true);
		  Thread.sleep(500);
		  util.closeWebBrowser();
    }catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace(); 
		
}
}

/* @Test 
public void rquestQuote_Vechicle()
{	  
	  try
	  {
	  
	      util.loadProperties(); 
	      Thread.sleep(500);
		  util.openWebBrowser("firefox","https://acorntire.com/");
		  Thread.sleep(500);
		  util.selectByVehicle ("2017" , "Acura" ,"ILX" ,"Base") ;
		  Thread.sleep(500);
		  util.requestQuote();
		  Thread.sleep(500);
		  util.Appointment ("vehicle","2017" , "Acura" ,"ILX" ,"Base");
		  Thread.sleep(500);
		  util.contactInfo("FVEHICLE" , "LVEHICLE" , "1234567890", "vehicle@test.com");
		  Assert.assertTrue(true);
		  //util.closeWebBrowser();
    }catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();  
}

}   
*/
}


