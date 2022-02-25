package com.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GoogleTest {
	
	WebDriver driver;
	String URL = "http://www.google.com";
	
	@BeforeMethod()
	public void setUp()
	{
		System.out.println("Setting up the browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Vinay\\Ranjani\\WebDriverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(URL);
	}

	@Test(description= "Verifying the google Title")
	public void googleTitleVerify()
	{
		String title = driver.getTitle();
		System.out.println("Title is "+title);
		Assert.assertEquals(title,"Google");
	}
	
	@Test(description= "Verifying the google logo")
	public void googleLogoVerify()
	{
		boolean flag = driver.findElement(By.xpath(".//*[@alt='Google']")).isDisplayed();
		Assert.assertEquals(flag, true);
		
	}
	
	@Test(description= "Verifying the Gmail link")
	public void googleGmailLinkVerify()
	{
		boolean flag = driver.findElement(By.xpath(".//*[@class='gb_d' and @data-pid='23']")).isDisplayed();
		Assert.assertEquals(flag, true);
		
	}
	@AfterMethod()
	public void closeBrowser()
	{
		System.out.println("Closing the browser");
		driver.quit();
	}
	
}
