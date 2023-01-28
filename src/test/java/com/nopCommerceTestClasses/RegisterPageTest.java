package com.nopCommerceTestClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopCommerceBase.TestBase;
import com.nopCommercePOMClasses.IndexPage;
import com.nopCommercePOMClasses.RegisterPage;
import com.nopCommerceTestData.DataSupplier;

public class RegisterPageTest extends TestBase {
	IndexPage index;
	RegisterPage register;
	Logger log;

	@BeforeMethod(alwaysRun = true)
	public void set() {
		index = new IndexPage(driver);
		register = new RegisterPage(driver);
		log = LogManager.getLogger(RegisterPageTest.class.getName());
		index.clickRegister();
	}

	@Test(groups = { "Smoke", "Sanity" })
	public void verifyRegisterPageTitle() {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyRegisterPageTitle");
		String title = register.getRegisterPageTitle();
		log.info("Register Page Title is:" + title);
		Assert.assertEquals(title, "nopCommerce demo store. Register");
		log.info("=========== Test Case End ===========");
	}

	@Test(groups = { "Sanity" }, dataProvider = "UserDetails", dataProviderClass = DataSupplier.class)
	public void createUserTest(String fName, String lName, String day, String month, String emailId, String company,
			String pass, String confiPass) {
		log.info("=========== Test Case Start ===========");
		log.info("Test - createUserTest");
		log.info("User details entered");
		register.userRegistrationDetails(fName, lName, day, month, emailId, company, pass, confiPass);
		register.clickRegisterButton();
		String message = register.getRegistrationSuccess();
		Assert.assertEquals(message, "Your registration completed");
		log.info("User registration completed");
		log.info("=========== Test Case End ===========");
	}

}
