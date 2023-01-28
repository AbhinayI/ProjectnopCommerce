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
import com.nopCommerceTestData.DataSupplier;

public class CheckoutPageTest extends TestBase {

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
		log = LogManager.getLogger(CheckoutPageTest.class.getName());
		index.clickLogIn();
		login.enterLoginCredentials(prop.getProperty("userName"), prop.getProperty("password"));
		product = login.clickOnProduct();
		product.scrollByWindow();
		product.clickProduct();
		product.clickAddToCart();
		cart = product.clickCart();
		checkout = cart.clickOnCheckout();
	}

	@Test(groups = { "Regression" }, dataProvider = "UserBillingDetails", dataProviderClass = DataSupplier.class)
	public void verifyEnteringUserBillingDetails(String fName, String lName, String compName, String countryName,
			String stateName, String cityName, String address1, String address2, String zipCode, String phoneNo,
			String faxNo) {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyEnteringUserBillingDetails");
		log.info("User is Login and product added to cart");
		log.info("User is filled Billing details");
		checkout.userBillingAddress(fName, lName, compName, countryName, stateName, cityName, address1, address2,
				zipCode, phoneNo, faxNo);
		log.info("=========== Test Case End ===========");
	}

	@Test(groups = { "Regression" }, dataProvider = "UserBillingDetails", dataProviderClass = DataSupplier.class)
	public void verifyShippingMethod(String fName, String lName, String compName, String countryName, String stateName,
			String cityName, String address1, String address2, String zipCode, String phoneNo, String faxNo) {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyShippingMethod");
		log.info("User is Login and product added to cart");
		log.info("User is filled Billing details");
		checkout.userBillingAddress(fName, lName, compName, countryName, stateName, cityName, address1, address2,
				zipCode, phoneNo, faxNo);
		log.info("User is selecting shipping method");
		boolean value = checkout.shippingMethod();
		Assert.assertTrue(value);
		log.info("User selected shipping method");
		checkout.submitshippingMethod();
		log.info("=========== Test Case End ===========");
	}

	@Test(groups = { "Regression" }, dataProvider = "UserBillingDetails", dataProviderClass = DataSupplier.class)
	public void verifyPaymentMethod(String fName, String lName, String compName, String countryName, String stateName,
			String cityName, String address1, String address2, String zipCode, String phoneNo, String faxNo) {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyPaymentMethod");
		log.info("User is Login and product added to cart");
		log.info("User is filled Billing details");
		checkout.userBillingAddress(fName, lName, compName, countryName, stateName, cityName, address1, address2,
				zipCode, phoneNo, faxNo);
		checkout.shippingMethod();
		log.info("User selected shipping method");
		checkout.submitshippingMethod();
		log.info("User is selecting payment method");
		boolean value = checkout.paymentMethod();
		Assert.assertTrue(value);
		log.info("User selected payment method");
		checkout.submitpaymentMethod();
		log.info("=========== Test Case End ===========");
	}

	@Test(groups = { "Regression" }, dataProvider = "UserBillingDetails", dataProviderClass = DataSupplier.class)
	public void verifyDetailsAndConfirmOrder(String fName, String lName, String compName, String countryName,
			String stateName, String cityName, String address1, String address2, String zipCode, String phoneNo,
			String faxNo) {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyDetailsAndConfirmOrder");
		log.info("User is Login and product added to cart");
		log.info("User is filled Billing details");
		checkout.userBillingAddress(fName, lName, compName, countryName, stateName, cityName, address1, address2,
				zipCode, phoneNo, faxNo);
		checkout.shippingMethod();
		log.info("User selected shipping method");
		checkout.submitshippingMethod();
		checkout.paymentMethod();
		log.info("User selected payment method");
		checkout.submitpaymentMethod();
		log.info("Order summary:");
		checkout.orderInfo();
		checkout.ConfirmOrder();
		log.info("User order confirmed");
		log.info("Continue to shop more...!");
		String title = checkout.clickContinueToShop();
		Assert.assertEquals(title, "nopCommerce demo store");
		log.info("=========== Test Case End ===========");
	}
}
