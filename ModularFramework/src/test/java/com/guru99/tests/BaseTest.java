package com.guru99.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;
import com.guru99.pages.LoginPage;

import commonLibs.implementation.CommonDriver;
import commonLibs.utils.ConfigUtils;
import commonLibs.utils.ReportUtils;
import commonLibs.utils.ScreenshotUtils;

public class BaseTest {
	
	CommonDriver commonDriver;
	String url;
	WebDriver driver;
	LoginPage loginPage;
	
	String configFilename;
	String currentWorkingDirectory;
	Properties configProperty;
	
	String reportFilename;
	ReportUtils reportUtils;
	
	ScreenshotUtils screenshot;
	
	@BeforeSuite
	public void preSetUp() throws Exception{

	    currentWorkingDirectory = System.getProperty("user.dir");
	    configFilename = currentWorkingDirectory + "/config/config.properties";
	    reportFilename = currentWorkingDirectory + "/reports/guru99TestReport.html";
	    configProperty = ConfigUtils.readProps(configFilename);
	    reportUtils = new ReportUtils(reportFilename);
	}

	@BeforeClass
	public void setUp() throws Exception {

	    url = configProperty.getProperty("baseUrl");
	    String browserType = configProperty.getProperty("browserType");
	    //url = "https://demo.guru99.com/V1/index.php";
	    commonDriver = new CommonDriver(browserType);
	    driver = commonDriver.getDriver();
	    loginPage = new LoginPage(driver);
	    
	    screenshot = new ScreenshotUtils(driver);
	    commonDriver.navigateToUrl(url);

	    }

	    @AfterMethod
	    public void postTestAction(ITestResult result) throws Exception {
	        String testCaseName = result.getName();
	        long executionTime = System.currentTimeMillis();
	        String screenshotFileName = currentWorkingDirectory + "/screenshots/" + testCaseName + executionTime + ".png";

	        if(result.getStatus() == ITestResult.FAILURE) {
	            reportUtils.addTestLog(Status.FAIL, "One or More steps Failed");
	            screenshot.captureScreenshot(screenshotFileName);
	            reportUtils.attachScreenshotToReport(screenshotFileName);
	        }
	    }
	    
	    @AfterClass
	    public void tearDown() {
	        commonDriver.closeBrowser();
	    }

	    @AfterSuite
	    public void postTearDown() {
	        reportUtils.flushReports();
	    }

	}


