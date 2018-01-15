package com.Webpower.Webpower;



import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
 

 
public class XSLT{
	
	TSNUtilities util = new TSNUtilities();

//========================*****Test Cases*****====================================================	

//Test Case 1
	
@Test (priority = 1  , dataProvider = "TSN_Website" ,  dataProviderClass = TSNDatatProvider.class)
public void Request_A_QUOTE__Size_FLOW (String browser ,String site) 
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
          util.appointmentPanel();
		  Thread.sleep(500);
		  util.contactInfo("FSIZE" , "LSIZE" , "1234567890", "size@test.com");		  
		  Reporter.log("User is on Contact Info Button " );
		  Assert.assertTrue(util.existsElement("Submit_button"));
		  util.driver.close();
			   		  		  
    }catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
        
}
	}

//================================*****END OF TESTCASE 1*****==================================	
	
// Test Case 2
	@Test  (priority = 2 , dataProvider = "TSN_Website" ,  dataProviderClass = TSNDatatProvider.class )
	public void Request_A_QUOTE__Vechicle_FLOW (String browser ,String site)
	{	  
	  try
		  {
		  
		      util.loadProperties(); 
		      Thread.sleep(500);
		      util.openWebBrowser(browser , site);
		     
			  Thread.sleep(500);
			  util.selectByVehicle ("2017" , "Acura" ,"ILX" ,"Base") ;
			  Thread.sleep(500);
			  util.requestQuote();
			  Thread.sleep(500);
			  util.appointmentPanel();
			  Thread.sleep(500);
			  util.contactInfo("FVEHICLE" , "LVEHICLE" , "1234567890", "vehicle@test.com");
			  Reporter.log("User is on Contact Info Button " );
			  Assert.assertTrue(util.existsElement("Submit_button"));
			  util.driver.close();
			  		  

	    }catch (Exception e) {
			
			e.printStackTrace();
	}

	}
//=============================================*****END OF TESTCASE 2*****=========================	
	
}