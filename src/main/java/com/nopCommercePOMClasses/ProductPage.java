package com.nopCommercePOMClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.nopCommerceBase.ActionManager;

public class ProductPage extends ActionManager {
	public ProductPage(WebDriver driver) {
		super(driver);
	}

//	private By clickProduct = By.xpath("//a[text()='HP Envy 6-1180ca 15.6-Inch Sleekbook']");
	private By clickProduct = By.xpath("(//a[@href='/hp-envy-6-1180ca-156-inch-sleekbook'])[4]");
	private By addTocart = By.id("add-to-cart-button-8");
//	private By cartQuantity = By.xpath("//span[@class='cart-qty']");
	private By cart = By.xpath("//span[text()='Shopping cart']");

	public String getTitle() {
		return driver.getTitle();
	}

	public void clickProduct() {
		Click(clickProduct);
	}

	public void clickAddToCart() {
		Click(addTocart);
	}

	public void scrollToElement() {
		scrollByWindow();
	}

	public CartPage clickCart() {
		Click(cart);
		return new CartPage(driver);
	}
}
