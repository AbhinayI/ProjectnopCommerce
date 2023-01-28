package com.nopCommercePOMClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.nopCommerceBase.ActionManager;

public class CartPage extends ActionManager {
	public CartPage(WebDriver driver) {
		super(driver);
	}

	private By productName = By.xpath("//td[@class=\"product\"]");
	private By productQuantity = By.xpath("//input[@class='qty-input']");
	private By updateCart = By.id("updatecart");
	private By i_Agree = By.id("termsofservice");
	private By checkoutButton = By.id("checkout");
	private By termsMessage = By.xpath("//div[@id='terms-of-service-warning-box']//p");

	public String getCartProductInfo() {
		return dogetText(productName);
	}

	public String getCartQuantity(String value) {
		return getAttributeValue(productQuantity, value);
	}

	public void getCartUpdate(String Quantity) {
		getClearField(productQuantity);
		setText(productQuantity, Quantity);
		Click(updateCart);
	}

	public boolean iAgreeSelected() {
		Click(i_Agree);
		return Selected(i_Agree);
	}

	public String iAgreeNotSelected() {
		Click(checkoutButton);
		return dogetText(termsMessage);
	}

	public CheckoutPage clickOnCheckout() {
		Click(i_Agree);
		Click(checkoutButton);
		return new CheckoutPage(driver);
	}

}
