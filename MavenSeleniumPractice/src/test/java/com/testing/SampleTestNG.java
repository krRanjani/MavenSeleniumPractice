package com.testing;

import org.testng.annotations.*;

public class SampleTestNG {
	
	@Test (priority=1,description = "First method running")
	public void first()
	{
		System.out.println("This is the first method");
	}
	@Test(priority=4,description = "Second method running")
	public void second()
	{
		System.out.println("This is the second method");
	}

	@Test(priority=2,description = "Third method running")
	public void third()
	{
		System.out.println("This is the third method");
	}

	@Test(priority=3,description = "Fourth method running")
	public void fourth()
	{
		System.out.println("This is the fourth method");
	}


}
