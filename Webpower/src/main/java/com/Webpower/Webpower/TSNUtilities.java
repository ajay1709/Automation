package com.Webpower.Webpower;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TSNUtilities extends Utilities {
	

	
	public void selectBySize (String width , String ratio , String rim) throws InterruptedException
	{
		  
		  
		  waitForLoad(driver);
		  WebElement SelectSize = locateElement("BY_SIZE");
	      // //*[@id="tires_by_size"]/a/span
		  
	      SelectSize.click();
	      waitTillElement("Width_dropdown");
	      selectDropdown("Width_dropdown",width);
	      waitTillElement("Ratio_dropdown");
	      selectDropdown("Ratio_dropdown" ,ratio);
	      waitTillElement("Rim_dropdown");	      
	      selectDropdown("Rim_dropdown" ,rim);
	      waitTillElement("SEE_RESULTS_Size");	
	      clickButton("SEE_RESULTS_Size");
	      		
	}
	
	
	public void selectByVehicle (String year , String make , String model ,String option) throws InterruptedException
	{
		  waitForLoad(driver);
		 // waitForLoad(driver); 
	      WebElement SelectSize = locateElement("BY_VEHICLE");
	      SelectSize.click();
	      Thread.sleep(10); 
	      selectDropdown("Year_dropdown",year);
	      Thread.sleep(10); 
	      selectDropdown("Make_dropdown" ,make);
	      Thread.sleep(10);  
	      selectDropdown("Model_dropdown" ,model);
	      Thread.sleep(10);  
	      selectDropdown("Option_dropdown" ,option);
	      Thread.sleep(10);  
	      clickButton("SEE_RESULTS_Vehicle");
	     		
	}
	
	
	
	public void requestQuote() throws InterruptedException
	{
		    waitForLoad(driver); 
		    waitTillElement ("GET_INSTANT_TOTAL_QUOTE");
			Thread.sleep(50);
			clickButton("GET_INSTANT_TOTAL_QUOTE");
				
	}

	public void appointmentPanel() throws InterruptedException
	{
		  waitForLoad(driver);
		  
		  if ((existsElement ("Location_Expand")) && (existsElement ("Appointment_Expand")))
				  {
			       
			         if (locateElement("Location_Expand").getText().equalsIgnoreCase("- LOCATION"))
		                 clickButton("Select_Location");
			         else if (locateElement("Location_Expand").getText().equalsIgnoreCase("+ LOCATION"))
			              {
			        	    clickButton("Location_Expand");
							clickButton("Select_Location");
			               }
			         else if (locateElement("Select_Location_Message").getText().contains("Please"))
						  clickButton("Select_Location");		  
					
			         Thread.sleep(500);
			         
			              if (locateElement("Appointment_Expand").getText().equalsIgnoreCase("+ Appointment Date and Time"))
			              clickButton("Appointment_Expand");
			        	datePicker ("Day_Pick1", "Select_date");
			    	    Thread.sleep(500);
			    	    selectDropdown("Pick_time1","02:30 pm");
			    	    Thread.sleep(500);
			    	    datePicker ("Day_Pick2","Select_date");
			    	    Thread.sleep(500);
			    	    selectDropdown("Pick_time2" , "04:30 pm");
			    	    Thread.sleep(500);
			    	    clickButton("continue_withAppoint");
			    	   
		        }
		  
		  if (!(existsElement ("Location_Expand")) && !(existsElement ("Appointment_Expand")))
		  {
			  clickButton("continue_withoutAppoint");
			 
		  }
		  
		  if (!(existsElement ("Location_Expand")) && (existsElement ("Appointment_Expand")))
		  {
			  if (locateElement("Appointment_Expand").getText().equalsIgnoreCase("+ Appointment Date and Time"))
	              clickButton("Appointment_Expand");
	        	datePicker ("Day_Pick1", "Select_date");
	    	    Thread.sleep(500);
	    	    selectDropdown("Pick_time1","02:30 pm");
	    	    Thread.sleep(500);
	    	    datePicker ("Day_Pick2","Select_date");
	    	    Thread.sleep(500);
	    	    selectDropdown("Pick_time2" , "04:30 pm");
	    	    Thread.sleep(500);
	    	    clickButton("continue_withAppoint");
		  }
		  
		  if ((existsElement ("Location_Expand")) &&  !(existsElement ("Appointment_Expand")))
		  {
			  if (locateElement("Location_Expand").getText().equalsIgnoreCase("- LOCATION"))
	                 clickButton("Select_Location");
		         else if (locateElement("Location_Expand").getText().equalsIgnoreCase("+ LOCATION"))
		              {
		        	    clickButton("Location_Expand");
						clickButton("Select_Location");
		               }
		         else if (locateElement("Select_Location_Message").getText().contains("Please"))
					  clickButton("Select_Location");
			  
			  Thread.sleep(500);
			  clickButton("continue_withoutAppoint");
			  
		  }
		  
	}
			         
        
		  
	public void contactInfo(String FName , String LName , String Mob ,String email)
	{

		waitForLoad(driver); 
		waitTillElement ("FName");
		textBoxData("FName" , FName);
		textBoxData("LName" , LName);
		textBoxData("Phone" , Mob);
		textBoxData("Email" , email);
				
	}
	
	
}
	
