package com.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class SampleTestAnnotations {
 
	//Pre-conditions annotations - starting with @Before
	 @BeforeSuite
	  public void setUp()
	 	{
		 System.out.println("Setup system property for chrome");
	 	}
	 
	 @BeforeTest //Before running any test case under a particular suite execute this
	  public void launchBrowser()
	 	{
		 System.out.println("Launch browser");
	 	}
	 
	  @BeforeClass
	  public void login() 
	  	{
		  System.out.println("Login to app");
	  	}
	  
	  @BeforeMethod
	  public void enterURL() 
	  	{
		  System.out.println("Enter URL");
	  	}
	  
	 @Test  //Test cases- starting with @ Test
  public void testGoogleTitle() 
	 {
		 System.out.println("Testing the google title");
	 }

	 @Test //@AfterMethod and @BeforeMethod will get executed in pair for every @Test annotations
	  public void testGoogleSearchbox() 
		 {
			 System.out.println("Testing the google search box");
		 }

	 //Post-conditions  --starting with @After
  @AfterMethod
  public void logout()
  	{
	  System.out.println("Logout from app");
  	}

  @AfterClass
  public void closeBrowser()
  	{
	  System.out.println("Close the browser");
	  
  	}


  @AfterTest
  public void deleteAllCookies() 
  	{
	  System.out.println("Delete all the cookies");
  	}


  @AfterSuite
  public void generateReport() 
  	{
	  System.out.println("Generate test report");
  	}

}
