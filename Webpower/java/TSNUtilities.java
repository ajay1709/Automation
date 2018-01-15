package com.Webpower.Webpower;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

public class TSNUtilities extends Utilities {
	

	
	public void selectBySize (String width , String ratio , String rim) throws InterruptedException
	{
		  
		  driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS) ;
		  WebElement SelectSize = locateElement("BY_SIZE");
	      // //*[@id="tires_by_size"]/a/span
		  
	      SelectSize.click();
	      selectDropdown("Width_dropdown",width);
	      selectDropdown("Ratio_dropdown" ,ratio);
	      selectDropdown("Rim_dropdown" ,rim);
	      clickButton("SEE_RESULTS_Size");
	      		
	}
	
	
	public void selectByVehicle (String year , String make , String model ,String option) throws InterruptedException
	{
		  driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS) ;
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
			clickButton("GET_INSTANT_TOTAL_QUOTE");
		
						 	     
	}
	
	public void selectLocation() throws InterruptedException
	{
		waitForLoad(driver); 
	    clickButton("Select_Location");
			      	      
	     
	}
	
	
	public void sizeAppointmentSelectVehicle (String year , String make , String model ,String option) throws InterruptedException 
	{
		 
		//driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS) ;
		waitForLoad(driver); 
          if (locateElement("Vehicle_Expand").getText().equalsIgnoreCase("+ Vehicle, Tire and Service"))
        	  clickButton("Vehicle_Expand");
          Thread.sleep(100); 
          selectDropdown("Year_dropdown",year);
	      Thread.sleep(5); 
	      selectDropdown("Make_dropdown" ,make);
	      Thread.sleep(5); 
	      selectDropdown("Model_dropdown" ,model);
	      Thread.sleep(5); 
	      selectDropdown("Option_dropdown" ,option);
	      clickButton("Continue");
	   
	
	}
	
	public void Appointment(String type ,String year , String make , String model ,String option ) throws InterruptedException
	{		  
		  
		  driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS) ;
		  selectLocation();
		  Thread.sleep(500);
		  if (type.equalsIgnoreCase("size"))
			  sizeAppointmentSelectVehicle (year,make,model ,option);
	      Thread.sleep(500);
	      if (existsElement("Appointment_Expand"))
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
	      clickButton("continue");
	      }
	      else {
	    	  Thread.sleep(500);
	    	  
	      }
	      
		  
	      	    
	}
	

	

	public void contactInfo(String FName , String LName , String Mob ,String email)
	{

		waitForLoad(driver); 
		textBoxData("FName" , FName);
		textBoxData("LName" , LName);
		textBoxData("Phone" , Mob);
		textBoxData("Email" , email);
				
	}
	
	
}
	
