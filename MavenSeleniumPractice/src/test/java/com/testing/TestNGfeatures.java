package com.testing;

import org.testng.annotations.Test;

// dependsOnMethods,invocationCount, invocationTimeOut, expectedExceptions keywords
public class TestNGfeatures {

	@Test(invocationCount = 2)
	public void loginTest()
	{
		System.out.println("login test");
		//int i=8/0;
	}
//	@Test(dependsOnMethods ="loginTest")
//	public void homePageTest()
//	{
//		System.out.println("Home Page test");
//	}
//	@Test(dependsOnMethods ="loginTest")
//	public void searchPageTest()
//	{
//		System.out.println("Search page test");
//	}
	@Test(dependsOnMethods ="loginTest")
	public void registerPage()
	{
		System.out.println("Register page test");
	}
	
//	@Test(invocationTimeOut=2)
//	public void infinteLoop()
//	
//	{
//		int i=1;
//				while(i==1)
//				{
//					System.out.println("Running in infinte loop");
//				}
//			}
	@Test(expectedExceptions=NumberFormatException.class)
	public void testExpected()
	{
		String s= "A123";
		Integer.parseInt(s);
	}
}
