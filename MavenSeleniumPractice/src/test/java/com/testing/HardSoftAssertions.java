package com.testing;
import org.testng.Assert;
import org.testng.annotations.*;
//for running multiple class files from testng.xml
import org.testng.asserts.SoftAssert;

public class HardSoftAssertions {
	@Test
	public void set()
	{
		
		//On using hard assertion in this method on which set1 method is dependent, set1 will be skipped
		//where as on using soft assertion without assertAll, set1 will be executed but on using soft assertion with assertAll, set1 will be skipped

		//HARD ASSERTION
//		System.out.println("This is the third class");
//		Assert.assertEquals(false, true); //Lines after this won't be executed as this is hard assertion and it is failed
//		System.out.println("Hard assertion");
		
		//SOFT ASSERTION
		SoftAssert sa = new SoftAssert();
		System.out.println("This is the third class");
		sa.assertEquals(false, true); //Lines after this will be executed even if it fails as this is soft assertion
		System.out.println("Soft assertion");
		sa.assertAll("One assertion failed"); //If assertAll is not used then set1 will be marked PASS even if the assertion is FAILED

	}
	

	@Test(dependsOnMethods = "set")
	public void set1()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("This is the forth class");
		sa.assertEquals(false, false); //Lines after this will be executed even if it fails as this is soft assertion
		System.out.println("Soft assertion1");
		sa.assertAll("One assertion failed"); //If assertAll is not used then set1 will be marked PASS even if the assertion is FAILED

	}
}
