package com.Webpower.Webpower;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Ajay.Upadhyay
 * This class contains common methods which are used across the application
 *
 */
public class Utilities {
	

	  Properties prop = new Properties();
	  WebDriver driver;


	
	//Loading OR.properties
	
	public void loadProperties()
	{
			  FileInputStream objfile;
	        	try {
	        		
	        		objfile = new FileInputStream(System.getProperty("user.dir")+"\\Config\\OR.properties");
		            prop.load(objfile);
	                } catch (FileNotFoundException e) 
	        	       {
		              // TODO Auto-generated catch block
		                 e.printStackTrace();
	                    }
	                     catch (IOException e) {
	                    	// TODO Auto-generated catch block
	                 		e.printStackTrace();
	                 	}
	}
	    
	
	// Locate Element by Xpath	
	public WebElement locateElement (String element )
	
	{  

		return	driver.findElement(By.xpath(prop.getProperty(element)));
}
	
		
	
	
	//Open Web Browser
	public void openWebBrowser(String browser ,String URL) 
	{
		try
		{
		
		//Check if parameter = 'firefox' then launch FireFox 
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			String Path = "D:\\Eclipse\\eclipse\\gecko\\geckodriver-v0.19.1-win64\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",Path);
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			
			driver.navigate().to(URL);			
		}
		} catch (WebDriverException e) {
		
			System.out.println("URL is not opening" + e);
			
		}
		
	}

		
	
	//Closing Web Driver

	public void closeWebBrowser() throws Exception
	{
		try
		{
			driver.manage().deleteAllCookies();
			driver.quit();
		}catch (Exception e)
		{
			System.out.println("No open Browser");
		
	}
	}
	
	//Entering value in a Text Box
	
	public void textBoxData(String path , String value)
	{
		waitForLoad(driver) ;
		driver.findElement(By.xpath(prop.getProperty(path))).sendKeys(value);
			
	}
	
	//Selecting value from DropDown
	public void selectDropdown(String path , String value) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    Select dropdown =new Select( driver.findElement(By.xpath(prop.getProperty(path))));
		dropdown.selectByVisibleText(value);		
	}
	
	// Click Button
	public void clickButton(String path)
	{
		waitTillElement (path);
		locateElement(path ).click();
			
	}
	
	//maximize Window
	public void maximizeWindow ()
	{
		driver.manage().window().maximize();
		
	}
    
	public String getText (String path)
	{
		return locateElement(path ).getText();
		
		
	}
	
	public void datePicker (String dateclick, String datedisplay) throws InterruptedException
	{
		   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;  
		   WebElement selectDate = locateElement(dateclick );
		   selectDate.click();
		  
		  List <WebElement> columns = driver.findElements(By.xpath(prop.getProperty(datedisplay)));
		   

		  for (WebElement cell: columns)
		   {		
			  
			 if (!cell.getText().equalsIgnoreCase("Prev")  && !cell.getText().equalsIgnoreCase("Next") && cell.isEnabled() )
			 {
				 Thread.sleep(500);
				 cell.click();
				 Thread.sleep(500);
				 break;
			 
					   }
		   }

			
			 
	}
	         


	public void waitTillElement (String element)
	{
		try
		{
		 WebDriverWait wait = new WebDriverWait(driver, 10000);
		 wait.until(ExpectedConditions.visibilityOf(locateElement(element))); 
		 
		}catch (NoSuchElementException e) {
			 System.out.println("Time out . Element not found");
			 }
		 

     } 
     
	
	public boolean existsElement(String path) throws InterruptedException {
		Thread.sleep(500);
		 try {
			 locateElement(path );
			 return true;
		 } catch (NoSuchElementException e) {
		 return false;
		 }
		 
		}

	public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new  ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(pageLoadCondition);
    } 
	
	public void doit()
	{
		System.out.println("Ajay");
	}
	
	
	//End
	
	
}
	



