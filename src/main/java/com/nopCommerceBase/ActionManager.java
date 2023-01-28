package com.nopCommerceBase;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionManager extends TestBase {

	public ActionManager(WebDriver driver) {
		this.driver = driver;
	}

	public void Click(By locator) {
		driver.findElement(locator).click();
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public List<WebElement> ClickListElement(List<WebElement> list) {
		for (WebElement val : list) {
			val.click();
		}
		return list;
	}

	public List<WebElement> getTextListElement(List<WebElement> list) {
		for (WebElement val : list) {
			System.out.print(val.getText() + " ");
		}
		return list;
	}

	public String getWindowID() {
		String ID = driver.getWindowHandle();
		return driver.switchTo().window(ID).getTitle();
	}

	public String getWindowIDs() {
		List<String> windows = new ArrayList<String>(driver.getWindowHandles());
		String title = null;
		for (String Id : windows) {
			title = driver.switchTo().window(Id).getTitle();
			System.out.println(title);
		}
		return title;
	}

	public void setText(By locator, String Text) {
		driver.findElement(locator).sendKeys(Text);
	}

	public String dogetText(By locator) {
		return driver.findElement(locator).getText();
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void doSelectByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

	public void doselectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doselectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public void doMoveToElementHover(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).perform();
	}

	public void doMoveToElement(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).click().perform();
	}

	public boolean Displayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	public boolean Selected(By locator) {
		return driver.findElement(locator).isSelected();
	}

	public boolean Enabled(By locator) {
		return driver.findElement(locator).isEnabled();
	}

	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		String message = driver.switchTo().alert().getText();
		alert.accept();
		return message;
	}

	public void scrollByVisibilityOfElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
	}

	public void scrollByWindow() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	public String getAttributeValue(By locator, String value) {
		return driver.findElement(locator).getAttribute(value);
	}

	public void getClearField(By locator) {
		driver.findElement(locator).clear();
	}
//	public void SelectDropDownValues(By locator, String type, String value) {
//		Select select = new Select(getElement(locator));
//
//		switch (type) {
//		case "index":
//			select.selectByIndex(Integer.parseInt(value));
//			break;
//
//		case "value":
//			select.selectByValue(value);
//			break;
//
//		case "visibleText":
//			select.selectByVisibleText(value);
//			break;
//
//		default:
//			System.out.println("plz enter correct selection");
//			break;
//		}
//	}
}
