package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTest extends BaseTest{
	
	@Parameters({"username", "password"})
	@Test
	private void loginWithCorrectCred(String username, String password) throws Exception {
	   
	   reportUtils.createTestCase("loginWithCorrectCred");
	   reportUtils.addTestLog(Status.INFO, "Performing login..");
	   loginPage.login(username, password);
	   
	   String expectedTitle = "GTPL Bank Home age";
	   String actualTitle = commonDriver.getTitle();
	   reportUtils.addTestLog(Status.INFO, "Compared Expected Vs Actual Title");
	   Assert.assertEquals(actualTitle, expectedTitle);
	}

}
