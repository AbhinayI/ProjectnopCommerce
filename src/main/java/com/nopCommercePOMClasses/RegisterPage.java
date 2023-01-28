package com.nopCommercePOMClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.nopCommerceBase.ActionManager;

public class RegisterPage extends ActionManager {
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	private By gender = By.id("gender-male");
	private By firstName = By.id("FirstName");
	private By lastName = By.id("LastName");
	private By dateOfBirthDay = By.xpath("//select[@name='DateOfBirthDay']");
	private By dateOfBirthMonth = By.xpath("//select[@name='DateOfBirthMonth']");
	private By dateOfBirthYear = By.xpath("//select[@name='DateOfBirthYear']");
	private By email = By.id("Email");
	private By companyName = By.id("Company");
	private By password = By.id("Password");
	private By confirmPassword = By.id("ConfirmPassword");
	private By registerButton = By.id("register-button");
	private By registerMessage = By.xpath("//div[@class='result']");

	public String getRegisterPageTitle() {
		return driver.getTitle();
	}

	public void userRegistrationDetails(String fName, String lName, String day, String month, String emailId,
			String company, String pass, String confiPass) {
		Click(gender);
		setText(firstName, fName);
		setText(lastName, lName);
		doSelectByVisibleText(dateOfBirthDay, day);
		doSelectByVisibleText(dateOfBirthMonth, month);
		doSelectByVisibleText(dateOfBirthYear, "2006");
		setText(email, emailId);
		setText(companyName, company);
		setText(password, pass);
		setText(confirmPassword, confiPass);

	}

	public void clickRegisterButton() {
		Click(registerButton);
	}

	public String getRegistrationSuccess() {
		return dogetText(registerMessage);
	}
}
