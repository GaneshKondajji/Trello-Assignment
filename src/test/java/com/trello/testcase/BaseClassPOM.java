package com.trello.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassPOM {

	public static WebDriver driver;
	public static Actions a;
	public static WebDriverWait w;

	// Launch Chrome
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// URl
	public static void loadUrl(String url) {
		driver.get(url);
	}

	// Maximize
	public static void winMax() {
		driver.manage().window().maximize();
	}

	// Title
	public static void printTitle() {
		System.out.println(driver.getTitle());
	}

	// CurrentUrl
	public static void printCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
	}

	// SendKeys
	public static void path(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	// Get Text
	public static void printText(WebElement ele) {
		String text = ele.getText();
		System.out.println(text);
	}

	// Get Attribute Name
	public static void getAttributeName(WebElement ele, String name) {
		String attributename = ele.getAttribute(name);
		System.out.println(attributename);
	}

	// DragAndDrop
	public static void dragDrop(WebElement src, WebElement des) {
		a = new Actions(driver);
		a.dragAndDrop(src, des).build().perform();
	}

	// Visibility Of All Elements Located
	public static void visibilityofAllEleLoc(By locator, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Close
	public static void toClose() {
		driver.close();
	}

}
