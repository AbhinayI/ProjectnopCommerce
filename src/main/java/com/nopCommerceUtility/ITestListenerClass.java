package com.nopCommerceUtility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.nopCommerceReports.Report;

public class ITestListenerClass extends Report implements ITestListener {

	ExtentReports extentReports = Report.initialiseExtentReports();
	Utility_ScreenShot screen = new Utility_ScreenShot();

	public void onTestStart(ITestResult result) {

		extentTest = extentReports.createTest(result.getName());
		extentTest.assignCategory(result.getMethod().getGroups());
	}

	public void onTestSuccess(ITestResult result) {

		extentTest.log(Status.PASS, "<b>Test Passed</b>");
	}

	public void onTestFailure(ITestResult result) {
//
		extentTest.fail(result.getThrowable());
//		extentTest.info(MarkupHelper.createLabel("fail", ExtentColor.RED));
		try {
//			Attaching screenshots to extent reports at Test Level
			extentTest.addScreenCaptureFromPath(screen.ScreenShots(result.getName()), result.getName());

//			Attaching screenshots to extent reports at Log Level
			extentTest.log(Status.INFO, MediaEntityBuilder
					.createScreenCaptureFromPath(screen.ScreenShots(result.getName()), result.getName()).build());
		} catch (IOException e) {
			e.printStackTrace();
		}

//		screen.ScreenShot(result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, "Skipped Test case is: " + result.getName());

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
		try {
			Desktop.getDesktop().browse(new File("ExtentReport\\ExtentAllTests.html").toURI());
			Desktop.getDesktop().browse(new File("ExtentReport\\ExtentFailedTests.html").toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
