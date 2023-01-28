package com.nopCommercePOMClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.nopCommerceBase.ActionManager;

public class IndexPage extends ActionManager {

	public IndexPage(WebDriver driver) {
		super(driver);
	}

	private By logo = By.xpath("//img[@alt='nopCommerce demo store']");
	private By registerLink = By.xpath("//a[text()='Register']");
	private By logIn = By.xpath("//a[@class='ico-login']");
//	private By followUsLinks = By.xpath("//div[@class='social']//following::li//a");
	private By followUsLinks = By.xpath("//li[@class='rss']//preceding-sibling::li//a");

	public String getIndexPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogo() {
		return Displayed(logo);
	}

	public RegisterPage clickRegister() {
		Click(registerLink);
		return new RegisterPage(driver);
	}

	public LoginPage clickLogIn() {
		Click(logIn);
		return new LoginPage(driver);
	}

	public String getClickOnFollowLinks() {
		ClickListElement(getElements(followUsLinks));
		return getWindowIDs();
	}
}
