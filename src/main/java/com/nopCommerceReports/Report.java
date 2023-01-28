package com.nopCommerceReports;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static Properties prop;

	public static ExtentReports initialiseExtentReports() {
		String path_All = ".\\ExtentReport\\ExtentAllTests.html";
		String path_Fail = ".\\ExtentReport\\ExtentFailedTests.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path_All);
		ExtentSparkReporter sparkReporter_Fail = new ExtentSparkReporter(path_Fail);
		sparkReporter.config().setReportName("Web Automation nopCommerce Reports");
		sparkReporter.config().setDocumentTitle("nopCommerce Test Results");

		sparkReporter_Fail.filter().statusFilter().as(new Status[] { Status.FAIL }).apply();
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter, sparkReporter_Fail);

		try {
			prop = new Properties();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileInputStream ip = null;
		try {
			ip = new FileInputStream(".\\src\\main\\java\\com\\nopCommerceConfig\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentReports.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReports.setSystemInfo("browesr", prop.getProperty("browesr"));
		extentReports.setSystemInfo("ID", prop.getProperty("userName"));
		extentReports.setSystemInfo("Password", prop.getProperty("password"));
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		return extentReports;
	}

}
