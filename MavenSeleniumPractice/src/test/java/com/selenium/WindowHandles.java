package com.selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandles {
	
	WebDriver driver;
	String URL="https://demoqa.com/browser-windows";
	
	 @BeforeTest
  public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Vinay\\Ranjani\\WebDriverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
	}
	 
	 @Test
	 public void wHandleNewTab() {
		 
		 System.out.println("Verifying Click on New Tab");
		 String before = driver.getWindowHandle();
		 System.out.println("Beofre click window is "+ before);
		 driver.findElement(By.id("tabButton")).click();
		 String current = driver.getWindowHandle();
		 System.out.println("After click window is "+ current);
		 		Set <String> windows = driver.getWindowHandles();
		 		Iterator<String> i = windows.iterator();
		 
		 while(i.hasNext())
		 {
			 String Child = i.next();
			 if(!Child.equalsIgnoreCase(current))
			 {
				 System.out.println("child window is "+ Child);
				 driver.switchTo().window(Child);
				 System.out.println("Child URL is "+driver.getCurrentUrl());
				 System.out.println("Text in new tab is "+ driver.findElement(By.id("sampleHeading")).getText());
			 }
		 }
		
		 driver.switchTo().window(current);
		 System.out.println("Window after return is "+ driver.getWindowHandle());
		 System.out.println("*******************************************");
  }
	 @Test
public void wHandleNewWindow()
{
		 System.out.println("Verifying Click on New window");
		 String before = driver.getWindowHandle();
		 System.out.println("Beofre click window is "+ before);
		 driver.findElement(By.id("windowButton")).click();
		 String current = driver.getWindowHandle();
		 System.out.println("After click window is "+ current);
		 		Set <String> windows = driver.getWindowHandles();
		 		Iterator<String> i = windows.iterator();
		 
		 while(i.hasNext())
		 {
			 String Child = i.next();
			 if(!Child.equalsIgnoreCase(current))
			 {
				 System.out.println("child window is "+ Child);
				 driver.switchTo().window(Child);
				 System.out.println("Child URL is "+driver.getCurrentUrl());
				 System.out.println("Text in new window is "+ driver.findElement(By.id("sampleHeading")).getText());
			 }
		 }
		
		 driver.switchTo().window(current);
		 System.out.println("Window after return is "+ driver.getWindowHandle());
		 System.out.println("*******************************************");

}
	 @Test
	 public void wHandleNewWindowMessage()  // This will fail as current URL can not obtained for new message window
	 {
		 System.out.println("Verifying Click on New window message");

	 		 String before = driver.getWindowHandle();
	 		 System.out.println("Beofre click window is "+ before);
	 		 driver.findElement(By.id("messageWindowButton")).click();
	 		 String current = driver.getWindowHandle();
	 		 System.out.println("After click window is "+ current);
	 		 		Set <String> windows = driver.getWindowHandles();
	 		 		Iterator<String> i = windows.iterator();
	 		 
	 		 while(i.hasNext())
	 		 {
	 			 String Child = i.next();
	 			 if(!Child.equalsIgnoreCase(current))
	 			 {
	 				 System.out.println("child window is "+ Child);
	 				 driver.switchTo().window(Child);
	 				 System.out.println("Child URL is "+driver.getCurrentUrl());
	 				 System.out.println("Text in new window is "+ driver.findElement(By.id("sampleHeading")).getText());
	 			 }
	 		 }
	 		
	 		 driver.switchTo().window(current);
	 		 System.out.println("Window after return is "+ driver.getWindowHandle());
	 }
	 	
	 
	 @AfterTest()
	 public void closeBrowser()
	 {
		 
		driver.quit();
	 }
}
