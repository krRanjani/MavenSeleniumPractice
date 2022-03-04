package com.testing;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SampleExtentReport {
	
	//create ExtentReports and attach report(s)
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");

	//extent.attachReporter(spark);
	
	  @BeforeTest
	  public void beforeTest() {
		 System.out.println("Sample program for extent reports"); 
		 extent.attachReporter(spark);
	  }
	
  @Test
  public void f1() {
	  ExtentTest test = extent.createTest("Launch browser and website").assignAuthor("Nancy").assignCategory("Smoke").assignDevice("Chrome");    //create is an implementation method
	  test.log(Status.PASS, "Website launched!");
	  test.pass("Launch f1 completed");
	  }
  
  @Test
  public void f2() {
	  ExtentTest test = extent.createTest("Provide login credentials").assignAuthor("Nancy").assignCategory("Regression").assignDevice("IE");    //create is an implementation method
	  test.info("Displaying alerts");
	  test.pass("Login f2 completed");
	  test.warning("Reset password alert displayed");
	  }
  
  @Test
  public void f3() {
	  ExtentTest test = extent.createTest("Verify the home page").assignAuthor("Amritha").assignCategory("System").assignDevice("safari");    //create is an implementation method
	  test.skip("Home page verification f3 skipped");
	  }
  
  @Test
  public void f4() {
	  ExtentTest test = extent.createTest("Verify dashboard").assignAuthor("Nancy").assignCategory("Regression").assignDevice("chrome");    //create is an implementation method
	  test.fail("f4 - Unable to view the dashboard as it is not loading due to some backend errot");
	  }
  
  @Test
  public void f5() {
	  ExtentTest test = extent.createTest("Verify create user page").assignAuthor("Amritha").assignCategory("UAT").assignDevice("IE");    //create is an implementation method
	  test.fail("f5- Unable to create users");
	  }
  
  @Test
  public void f6() {
	  ExtentTest test = extent.createTest("Verify create group page").assignAuthor("Amritha").assignCategory("UAT").assignDevice("chrome");    //create is an implementation method
	  test.pass("f6 - Group created successfully"); 
  }
  
  @Test
  public void f7() {
	  ExtentTest test = extent.createTest("Verify email functionality").assignAuthor("Kiran").assignCategory("System").assignDevice("chrome");    //create is an implementation method
	  test.pass("f7 - Email functionality working as expected");
  }
  
  @Test
  public void f8() {
	  ExtentTest test = extent.createTest("Verify job scheduling featutre").assignAuthor("Nancy").assignCategory("System").assignDevice("IE");    //create is an implementation method
	  test.fail("f8- Unable to schedule job");  
  }
  
  @Test
  public void f9() {
	  ExtentTest test = extent.createTest("Verify logout feature").assignAuthor("Deepti").assignCategory("System").assignDevice("firefox");    //create is an implementation method
	  test.pass("f9- User logged out successfully"); 
	  test.info("User is redirected to login page");
  }
  


  @AfterTest
  public void afterTest() {
	  //For putting these tests to sparker extent report
	  extent.flush();
  }

}
