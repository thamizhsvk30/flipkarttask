package com.flipkart.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class Commonactions{

	public static  WebDriver driver;
	private static String homeWindow = null;

	public WebDriver launch(String url) throws Throwable {

		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.addArguments("start-maximized");
		driver = new ChromeDriver(chromeOptions);
		driver.get(url);
		pagewait();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}


	public void insertText(WebElement element, String value) {
		try{
			try{
				element.clear();
			}catch(Exception e1){
				element.sendKeys(Keys.DELETE);
			}
		}catch (Exception e) {

		}
		element.sendKeys(value);

	}


	public void click(WebElement element) {

		element.click();

	}

	public void pagewait() throws Throwable {

		Thread.sleep(5000);

	}


	public void searchText(WebElement element, String value) {
		try{
			try{
				element.clear();
			}catch(Exception e1){
				element.sendKeys(Keys.DELETE);
			}
		}catch (Exception e) {

		}
		element.sendKeys(value +Keys.ENTER);

	}
	public static void movetoele(WebElement element) 
	{
		try{
		Actions aa = new Actions(driver);
		aa.moveToElement(element).build().perform();
		}
		catch (Exception e) {	}
	}
	public static void accept_Alert() {
		try {
			Alert alert = driver.switchTo().alert();
			try{
				String text = alert.getText();
				System.out.println("alert text :"+text);
			}catch(Exception e){	
			}
			alert.accept();
		} catch (Exception e) {
		}
	}




	public static void closeBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
		}
	}



	public static void selectByValue(WebElement element, String value) {
		try {
			Select obj_select = new Select(element);
			obj_select.selectByValue(value);
		} catch (Exception e) {
		}
	}


	public static void selectByText(WebElement element, String text) {
		try {
			Select obj_select = new Select(element);
			obj_select.selectByVisibleText(text);
		} catch (Exception e) {
		}
	}


	public static void waitForElementVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void switchToWindow() {
		homeWindow = driver.getWindowHandle();
		for (String window : driver.getWindowHandles()) {
			if(!homeWindow.equals(window))
			{
			driver.switchTo().window(window);
			}}
	}

	public void jsScrollPagedowntoEnd() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
		catch (Exception e) {
		}
	}

	public void jsScrollPageUp(WebElement element) {
		try {
			int yScrollPosition = element.getLocation().getY();
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("window.scrollBy(0, " + -yScrollPosition + ")", "");
		} catch (Exception e) {
		}
	}
}