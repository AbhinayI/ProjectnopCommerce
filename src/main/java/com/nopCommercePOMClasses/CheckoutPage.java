package com.nopCommercePOMClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nopCommerceBase.ActionManager;

public class CheckoutPage extends ActionManager {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	private By firstName = By.id("BillingNewAddress_FirstName");
	private By lastName = By.id("BillingNewAddress_LastName");
	private By email = By.id("BillingNewAddress_Email");
	private By company = By.id("BillingNewAddress_Company");
	private By country = By.id("BillingNewAddress_CountryId");
	private By state = By.id("BillingNewAddress_StateProvinceId");
	private By city = By.id("BillingNewAddress_City");
	private By add1 = By.id("BillingNewAddress_Address1");
	private By add2 = By.id("BillingNewAddress_Address2");
	private By zip = By.id("BillingNewAddress_ZipPostalCode");
	private By phone = By.id("BillingNewAddress_PhoneNumber");
	private By fax = By.id("BillingNewAddress_FaxNumber");
	private By billingContinueButton = By.xpath("(//button[@class='button-1 new-address-next-step-button'])[1]");
	private By shippingOption = By.id("shippingoption_1");
	private By shippingContinueButton = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
	private By payment = By.id("paymentmethod_0");
	private By paymentContinueButton = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
//	private By paymentInfo = By.xpath("//p//b");
	private By paymentInfoContinueButton = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
	private By confirmOrder = By.xpath("(//tbody//tr//td)[7]//following::td");
	private By confirmOrderContinueButton = By.xpath("//button[@class='button-1 confirm-order-next-step-button']");
	private By ContinueButton = By.xpath("//button[@class='button-1 order-completed-continue-button']");

	public String getCheckoutPageTitle() {
		return driver.getTitle();
	}

	public void userBillingAddress(String fName, String lName, String compName, String countryName, String stateName,
			String cityName, String address1, String address2, String zipCode, String phoneNo, String faxNo) {
		setText(firstName, fName);
		setText(lastName, lName);
//		SendKeys(email, emailId);
		setText(company, compName);
		doSelectByVisibleText(country, countryName);
		setText(state, stateName);
		setText(city, cityName);
		setText(add1, address1);
		setText(add2, address2);
		setText(zip, zipCode);
		setText(phone, phoneNo);
		setText(fax, faxNo);
		Click(billingContinueButton);
	}

	public boolean shippingMethod() {
		Click(shippingOption);
		return Selected(shippingOption);
	}

	public void submitshippingMethod() {
		Click(shippingContinueButton);
	}

	public boolean paymentMethod() {
		Click(payment);
		return Selected(payment);
	}

	public void submitpaymentMethod() {
		Click(paymentContinueButton);
		Click(paymentInfoContinueButton);
	}

	public List<WebElement> orderInfo() {
		return getTextListElement(getElements(confirmOrder));
	}

	public void ConfirmOrder() {
		Click(confirmOrderContinueButton);
	}

	public String clickContinueToShop() {
		Click(ContinueButton);
		return driver.getTitle();
	}

}
