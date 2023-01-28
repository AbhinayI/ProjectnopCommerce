package com.nopCommerceTestClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopCommerceBase.TestBase;
import com.nopCommercePOMClasses.IndexPage;
import com.nopCommercePOMClasses.LoginPage;
import com.nopCommerceTestData.DataSupplier;

public class LoginPageTest extends TestBase {
	IndexPage index;
	LoginPage login;
	Logger log;

	@BeforeMethod(alwaysRun = true)
	public void set() {
		index = new IndexPage(driver);
		login = new LoginPage(driver);
		log = LogManager.getLogger(LoginPageTest.class.getName());
		index.clickLogIn();
	}

	@Test(groups = { "Smoke", "Sanity" })
	public void VerifyLogin() {
		log.info("=========== Test Case Start ===========");
		log.info("Test - VerifyLogin");
		log.info("Entered Login Credentials");
		login.enterLoginCredentials(prop.getProperty("userName"), prop.getProperty("password"));
		String myAccount = login.getMyAccount();
		Assert.assertEquals(myAccount, "My account");
		log.info("=========== Test Case End ===========");
	}

	@Test(groups = { "Sanity" })
	public void VerifyNewsLetterSubscription() {
		log.info("=========== Test Case Start ===========");
		log.info("Test - VerifyNewsLetterSubscription");
		log.info("Entered Login Credentials");
		login.enterLoginCredentials(prop.getProperty("userName"), prop.getProperty("password"));
		log.info("Entered email for Newsletter subscription");
		login.getNewsLetterEmails(prop.getProperty("userName"));
		log.info("=========== Test Case End ===========");
	}

	@Test(groups = { "Sanity" }, dataProvider = "SearchItems", dataProviderClass = DataSupplier.class)
	public void VerifyProductsSearchBySearchBox(String productName) {
		log.info("=========== Test Case Start ===========");
		log.info("Test - VerifyProductsSearchBySearchBox");
		log.info("Entering Login Credentials");
		login.enterLoginCredentials(prop.getProperty("userName"), prop.getProperty("password"));
		log.info("Clicked on SearchBox and entering product name");
		login.getProductBySearch(productName);
		log.info("Clicked on SearchBox button");
		String title = login.getSearchPageTitle();
		log.info("Search Page Title is:" + title);
		Assert.assertEquals(title, "nopCommerce demo store. Search");
		log.info("=========== Test Case End ===========");
	}

	@Test(groups = { "Smoke", "Sanity" })
	public void VerifyLogOut() {
		log.info("=========== Test Case Start ===========");
		log.info("Test - VerifyLogOut");
		log.info("Entering Login Credentials");
		login.enterLoginCredentials(prop.getProperty("userName"), prop.getProperty("password"));
		log.info("Clicked on LogOut");
		index = login.logOut();
		String title = index.getIndexPageTitle();
		log.info("Index Page Title is:" + title);
		Assert.assertEquals(title, "nopCommerce demo store");
		log.info("=========== Test Case End ===========");
	}
}
