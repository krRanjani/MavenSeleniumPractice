package com.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.*;
//some selenium webdriver programs with testNG
public class GoogleTest {
	
	 static WebDriver driver;
	String URL = "http://www.google.com";
	
	@BeforeMethod()
	public void setUp()
	{
		System.out.println("Setting up the browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Vinay\\Ranjani\\WebDriverFiles\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Vinay\\Ranjani\\WebDriverFiles\\geckodriver.exe");
		//System.setProperty("webdriver.ie.driver", "C:\\Vinay\\Ranjani\\WebDriverFiles\\IEDriverServer.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(URL);
	}

	//@Test(priority=2,description= "Verifying the google Title")
	@Test(priority=2,groups="title")
	public void googleTitleVerify() throws InterruptedException
	{
		Thread.sleep(6000);
		String title = driver.getTitle();
		System.out.println("Title is "+title);
		Assert.assertEquals(title,"Google","Google title is expected");
	}
	
	//@Test(priority=1,description= "Verifying the google logo")
	@Test(priority=1,groups="logo")
	public void googleLogoVerify()
	{
		boolean flag = driver.findElement(By.xpath(".//*[@alt='Google']")).isDisplayed();
		System.out.println("Google logo verified");
		Assert.assertTrue(flag);
		//Assert.assertEquals(flag, true,"Google logo is not displayed");
		
	}
	
	//@Test(priority=3,description= "Verifying the Gmail link")
	@Test(priority=3,groups="link")
	public void googleGmailLinkVerify()
	{
		boolean flag = driver.findElement(By.xpath(".//*[@class='gb_d' and @data-pid='23']")).isDisplayed();
		System.out.println("Gmail link verified");
		Assert.assertTrue(flag);
		//Assert.assertEquals(flag, true,"Gmail link is not displayed");
		
	}
	@Test(priority=4,groups="testset")
	public void method1()
	{
		System.out.println("This is test1");
	}
	@Test(priority=5,groups="testset")
	public void method2()
	{
		System.out.println("This is test2");
	}
	
	@Test(priority=6,groups="testset")
	public void method3()
	{
		System.out.println("This is test3");
	}
	
	@Test(priority=7,groups="testset")
	public void method4()
	{
		System.out.println("This is test4");
	}
	
	
	@AfterMethod()
	public void closeBrowser()
	{
		System.out.println("Closing the browser");
		driver.quit();
	}
	
}
