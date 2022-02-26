package com.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Crossbrowser {
	
	WebDriver driver;
	
	@Test
	@Parameters("browser")
	public void crossbrowser(String bName)
	{
		if(bName.equalsIgnoreCase("firefox"))
				{
				System.setProperty("webdriver.gecko.driver", "C:\\Vinay\\Ranjani\\WebDriverFiles\\geckodriver.exe");
				driver= new FirefoxDriver();
				}
		else if(bName.equalsIgnoreCase("chrome"))
				{
				System.setProperty("webdriver.chrome.driver", "C:\\Vinay\\Ranjani\\WebDriverFiles\\chromedriver.exe");
			
				driver= new ChromeDriver();		
				}
		else if(bName.equalsIgnoreCase("Ie"))
				{
				System.setProperty("webdriver.ie.driver", "C:\\Vinay\\Ranjani\\WebDriverFiles\\IEDriverServer.exe");
				driver= new InternetExplorerDriver();		
				}
	
			driver.manage().window().maximize();
			driver.get("http://www.google.com");
			System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Google");
			driver.close();
}
}
