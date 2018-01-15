package com.Webpower.Webpower;
 
import java.io.File;
 
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 
public class NewTest{
	
	TSNUtilities util = new TSNUtilities();
	ExtentReports extent;
	ExtentTest logger;
	
//========================BEFORE TEST============================================================
	@BeforeTest 
	public void startReport(){
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
		     extent
                .addSystemInfo("Host Name", "Webpower")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Ajay");
             extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	} 
//=========================END OF BEFORE TEST========================================================================	

//========================*****TSN TEST CASES*****==============================================================

	// TEST 1
	@Test (priority = 1  , dataProvider = "TSN_Website" ,  dataProviderClass = TSNDatatProvider.class)
	public void rquestQuote_Size(String browser ,String site) {
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
	     logger = extent.startTest("To Verify the TSN : " +  site + " 'BY  SIZE  FLOW '" + "on browser : " + browser );
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
		  if (!util.existsElement("Submit_button"))
		 	  logger.log(LogStatus.FAIL, "The Submit button is not enabled");
		  else 
			  logger.log(LogStatus.PASS, "This flow is working as expected");
		  
 		  		  
    }catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
        logger.log(LogStatus.FAIL, "Test Case Failed due to exception : " + e.getMessage());		
		
}
	}
//------------------------*****END of TEST CASE 1*****--------------------------------------------

	// TEST CASE 2
	
	@Test  (priority = 2 , dataProvider = "TSN_Website" ,  dataProviderClass = TSNDatatProvider.class )
	public void rquestQuote_Vechicle (String browser ,String site)
	{	  
	logger = extent.startTest("To Verify the TSN : " + site + " 'BY VEHICLE  FLOW '" + "on browser : " + browser );
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
			  if (!util.existsElement("Submit_button"))
			 	  logger.log(LogStatus.FAIL, "The Submit button is not enabled");
			  else 
				  logger.log(LogStatus.PASS, "This flow is working as expected");
			  

	    }catch (Exception e) {
			
			e.printStackTrace(); 
			logger.log(LogStatus.FAIL, "Test Case Failed due to exception : " + e.getMessage());	
	}

	}
	

//-------------------------*****END OF TEST CASE 2*****---------------------------------------------

// TestCase 3 
	
	
	
	
	
	
//==============================AFTER METHOD=======================================================	
	@AfterMethod 
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is   "  +   result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is  "   +   result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is   " +     result.getName());
		}else if(result.getStatus() == ITestResult.SUCCESS){
			logger.log(LogStatus.PASS, "Test Case Passed is "+result.getName());
		}
		
		extent.endTest(logger);
     	try {
			util.closeWebBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	} 
//=============================END OF AFTER METHOD=================================================

//============================AFTER TEST==========================================================
	
	@AfterTest 
	public void endReport(){
		
                extent.flush();
                extent.close();
                
    }
	
//=================================END OF AFTER TEST================================================

}