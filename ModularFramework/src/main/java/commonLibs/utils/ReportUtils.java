package commonLibs.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtils {
	
	ExtentSparkReporter htmlReport;
	ExtentReports extentReport;
	ExtentTest extentTest;

	public ReportUtils(String htmlReportFilename) {
	   htmlReportFilename = htmlReportFilename.trim();
	   htmlReport = new ExtentSparkReporter(htmlReportFilename);
	   extentReport = new ExtentReports();
	   extentReport.attachReporter(htmlReport);
	}

	public void createTestCase(String testName) {
	   extentTest = extentReport.createTest(testName);
	}
	
	public void addTestLog(Status status, String message) {
		   extentTest.log(status, message);
		}

	public void flushReports() {
		   extentReport.flush();
		}

	public void attachScreenshotToReport(String filename) throws Exception{
        System.out.println("Attempting to attach: " + filename);
        extentTest.addScreenCaptureFromPath(filename);
        
		/*
		 * // Convert absolute path to a relative path from the report location File
		 * reportFile = new File(htmlReport.getFile()); File screenshotFile = new
		 * File(filename);
		 * 
		 * String relativePath = new File(reportFile.getParent()).toURI()
		 * .relativize(screenshotFile.toURI()).getPath();
		 * 
		 * extentTest.addScreenCaptureFromPath(relativePath);
		 */
        
		}

}
