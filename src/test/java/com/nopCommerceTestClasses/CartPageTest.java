package com.nopCommerceTestClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopCommerceBase.TestBase;
import com.nopCommercePOMClasses.CartPage;
import com.nopCommercePOMClasses.CheckoutPage;
import com.nopCommercePOMClasses.IndexPage;
import com.nopCommercePOMClasses.LoginPage;
import com.nopCommercePOMClasses.ProductPage;

public class CartPageTest extends TestBase {
	IndexPage index;
	LoginPage login;
	ProductPage product;
	CartPage cart;
	CheckoutPage checkout;
	Logger log;

	@BeforeMethod(alwaysRun = true)
	public void set() {
		index = new IndexPage(driver);
		login = new LoginPage(driver);
		product = new ProductPage(driver);
		cart = new CartPage(driver);
		checkout = new CheckoutPage(driver);
		log = LogManager.getLogger(CartPageTest.class.getName());
		index.clickLogIn();
		login.enterLoginCredentials(prop.getProperty("userName"), prop.getProperty("password"));
		product = login.clickOnProduct();
		product.scrollByWindow();
		product.clickProduct();
		product.clickAddToCart();
	}

	@Test(groups = { "Regression" })
	public void verifyCartPageProductInfo() {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyCartPageProductInfo");
		cart = product.clickCart();
		log.info("Clicked on Cart");
		String prodName = cart.getCartProductInfo();
		log.info("Cart page product name is:" + prodName);
		String prodQuant = cart.getCartQuantity("value");
		log.info("Cart product quantity is:" + prodQuant);
		log.info("=========== Test Case End ===========");
	}

	@Test(groups = { "Regression" })
	public void verifyCartDetailsUpdated() {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyCartDetailsUpdated");
		cart = product.clickCart();
		log.info("Clicked on Cart");
		String prodName = cart.getCartProductInfo();
		log.info("Cart page product name is:" + prodName);
		String prodQuantBefore = cart.getCartQuantity("value");
		log.info("Cart product quantity before update is:" + prodQuantBefore);
		cart.getCartUpdate("5");
		String prodQuantAfter = cart.getCartQuantity("value");
		log.info("Cart product quantity after update is:" + prodQuantAfter);
		Assert.assertNotEquals(prodQuantBefore, prodQuantAfter, "Cart is updated successfully");
		log.info("=========== Test Case End ===========");
	}

	@Test(groups = { "Regression" })
	public void verifyI_AgreeSelected() {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyI_AgreeSelected");
		cart = product.clickCart();
		log.info("Clicked on Cart");
		log.info("Clicking on I Agree checkbox");
		boolean checkBox = cart.iAgreeSelected();
		Assert.assertTrue(checkBox);
		log.info("I_Agree clicked");
		log.info("=========== Test Case End ===========");
	}

	@Test(groups = { "Regression" })
	public void verifyI_AgreeNotSelected() {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyI_AgreeNotSelected");
		cart = product.clickCart();
		log.info("Clicked on Cart");
		log.info("I Agree checkbox Not clicked");
		String message = cart.iAgreeNotSelected();
		Assert.assertEquals(message, "Please accept the terms of service before the next step.");
		log.info("=========== Test Case End ===========");
	}

	@Test(groups = { "Regression" })
	public void verifyCartCheckout() {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyCartCheckout");
		cart = product.clickCart();
		log.info("Clicked on Cart");
		String prodName = cart.getCartProductInfo();
		log.info("Cart page product name is:" + prodName);
		String prodQuant = cart.getCartQuantity("value");
		log.info("Cart product quantity is:" + prodQuant);
		checkout = cart.clickOnCheckout();
		String title = checkout.getCheckoutPageTitle();
		log.info("Checkout page title is:" + title);
		Assert.assertEquals(title, "nopCommerce demo store. Checkout");
		log.info("=========== Test Case End ===========");
	}

}
