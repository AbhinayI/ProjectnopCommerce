package com.nopCommercePOMClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.nopCommerceBase.ActionManager;

public class LoginPage extends ActionManager {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private By email = By.id("Email");
	private By password = By.id("Password");
	private By logInButton = By.xpath("//button[text()='Log in']");
	private By myAccount = By.xpath("(//a[text()='My account'])[1]");
	private By newsLetter = By.id("newsletter-email");
	private By confirmnewsLetter = By.xpath("//div[@class='newsletter-result']");
	private By newsLetterButton = By.id("newsletter-subscribe-button");
	private By logOut = By.xpath("//a[text()='Log out']");
	private By menuProduct1 = By.xpath("(//a[text()='Computers '])[1]");
	private By menuProduct = By.xpath("(//a[text()='Notebooks '])[1]");
	private By searchBox = By.id("small-searchterms");
	private By searchButton = By.xpath("//button[@class='button-1 search-box-button']");

	public void enterLoginCredentials(String userId, String passWord) {
		setText(email, userId);
		setText(password, passWord);
		Click(logInButton);
	}

	public String getMyAccount() {
		return dogetText(myAccount);
	}

	public void getNewsLetterEmails(String email) {
		setText(newsLetter, email);
		Click(newsLetterButton);
	}

	public String getConfirmNewsLetter() {
		return dogetText(confirmnewsLetter);
	}

	public ProductPage clickOnProduct() {
		doMoveToElementHover(menuProduct1);
		doMoveToElement(menuProduct);
		return new ProductPage(driver);
	}

	public void getProductBySearch(String item) {
		setText(searchBox, item);
		Click(searchButton);
	}

	public String getSearchPageTitle() {
		return driver.getTitle();
	}

	public IndexPage logOut() {
		Click(logOut);
		return new IndexPage(driver);
	}
}
