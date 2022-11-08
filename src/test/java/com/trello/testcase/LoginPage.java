package com.trello.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseClassPOM {

	public static void main(String[] args) throws InterruptedException {
		
		// System Property for chrome driver & Launch Website
		launchChrome();
		loadUrl("https://trello.com/home");
		winMax();

		// Login
		WebElement login = driver.findElement(By.xpath("(//a[text()='Log in'])[1]"));
		printText(login);
		login.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Username or Email
		WebElement username = driver.findElement(By.id("user"));
		username.getText();
		username.sendKeys("keganesh03@gmail.com");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		// Password
		visibilityofAllEleLoc(By.id("password"), 20);
		WebElement pass = driver.findElement(By.id("password"));
		pass.getText();
		pass.sendKeys("Ganesh@03");
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		Thread.sleep(5000);

		// Ceate a New Board
		WebElement newBoard = driver.findElement(By.xpath("//div[@class='board-tile mod-add']"));
		newBoard.click();

		visibilityofAllEleLoc(By.xpath("//input[@type='text']"), 20);
		WebElement boardtitle = driver.findElement(By.xpath("//input[@type='text']"));
		boardtitle.sendKeys("assignment2");

		visibilityofAllEleLoc(By.xpath("//button[text()='Create']"), 20);
		WebElement create = driver.findElement(By.xpath("//button[text()='Create']"));
		create.click();

		
		// list A
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement listA = driver.findElement(By.xpath("//input[@placeholder='Enter list title…']"));
		js.executeScript("arguments[0].click();", listA);
		listA.sendKeys("List A");
		System.out.println(listA.getText());
		listA.getTagName();
		driver.findElement(By.xpath("//input[@value='Add list']")).click();

		// list B
		visibilityofAllEleLoc(By.xpath("//input[@placeholder='Enter list title…']"), 20);
		WebElement listB = driver.findElement(By.xpath("//input[@placeholder='Enter list title…']"));
		listB.sendKeys("List B");
		driver.findElement(By.xpath("//input[@value='Add list']")).click();

		// Add a Card
		WebElement addList = driver.findElement(By.xpath("(//span[text()='Add a card'])[1]"));
		addList.click();

		// Card Title
		WebElement titleCard = driver.findElement(By.xpath("(//textarea[@dir='auto'])[2]"));
		titleCard.sendKeys("WELCOME");
		String att = titleCard.getAttribute("class");
		System.out.println(att);
		driver.findElement(By.xpath("//input[@value='Add card']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Performing the Drag and Drop Action
		WebElement from = driver.findElement(By.xpath("//span[text()='WELCOME']"));
		WebElement to = driver.findElement(By.xpath("(//span[text()='Add a card'])[2]"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dragDrop(from, to);
		
		String textTo = to.getText();
		if (textTo.equals("Add a card")) {
			System.out.println("PASS: File is dropped to target as expected");
		} else {
			System.out.println("FAIL: File couldn't be dropped to target as expected");
		}
		
		// Get the x and y coordinates of the card that you moved
		Point location = to.getLocation();
		System.out.println("The X Coordinate is :"+location.getX());
		System.out.println("The Y Coordinate is :"+location.getY());
		
		// LogOut
		visibilityofAllEleLoc(By.xpath("//span[@title='Ganesh K E (keganesh03)']"), 20);
		WebElement profile = driver.findElement(By.xpath("//span[@title='Ganesh K E (keganesh03)']"));
		profile.click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement logout = driver.findElement(By.xpath("//span[text()='Log out']"));
		logout.click();

		driver.close();

	}

}
