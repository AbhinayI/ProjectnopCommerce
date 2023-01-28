package com.nopCommerceTestClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopCommerceBase.TestBase;
import com.nopCommercePOMClasses.IndexPage;
import com.nopCommercePOMClasses.LoginPage;
import com.nopCommercePOMClasses.ProductPage;

public class ProductPageTest extends TestBase {
	IndexPage index;
	LoginPage login;
	ProductPage product;
	Logger log;

	@BeforeMethod(alwaysRun = true)
	public void set() {
		index = new IndexPage(driver);
		login = new LoginPage(driver);
		product = new ProductPage(driver);
		log = LogManager.getLogger(ProductPageTest.class.getName());
		index.clickLogIn();
		login.enterLoginCredentials(prop.getProperty("userName"), prop.getProperty("password"));
	}

	@Test(groups = { "Regression" })
	public void verifyClickOnproductMenu() {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyClickOnproductMenu");
		log.info("Hover the product menu and clicked");
		product = login.clickOnProduct();
		String title = product.getTitle();
		log.info("Product menu title is:" + title);
		Assert.assertEquals(title, "nopCommerce demo store. Notebooks");
		log.info("=========== Test Case End ===========");
	}

	@Test(groups = { "Regression" })
	public void verifyclickOnProduct() {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyclickOnProduct");
		log.info("Hover the product menu and clicked");
		product = login.clickOnProduct();
		log.info("Product clicked");
		product.clickProduct();
		String title = product.getTitle();
		log.info("Product page title is:" + title);
		Assert.assertEquals(title, "nopCommerce demo store. HP Envy 6-1180ca 15.6-Inch Sleekbook");
		log.info("=========== Test Case End ===========");
	}

	@Test(groups = { "Regression" })
	public void verifyProductAddToCart() {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyProductAddToCart");
		log.info("Hover the product menu and clicked");
		product = login.clickOnProduct();
		product.scrollByWindow();
		log.info("Product clicked");
		product.clickProduct();
		log.info("Product added to cart");
		product.clickAddToCart();
		log.info("=========== Test Case End ===========");
	}
}
