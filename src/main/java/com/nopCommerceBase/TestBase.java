package com.nopCommerceBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	protected Properties prop;

	public Logger log = LogManager.getLogger();

	public TestBase() {
		prop = new Properties();
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
	}

	@Parameters("browserName")
	@BeforeMethod(alwaysRun = true)
	public void setUp(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		log.info("Browser is Opened");
		driver.manage().window().maximize();
		log.info("Browser is maximized");
		driver.get(prop.getProperty("url"));
		log.info("URL is Opened");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Browser is closed");
	}

}
