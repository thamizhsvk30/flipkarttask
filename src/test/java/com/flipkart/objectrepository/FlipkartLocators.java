package com.flipkart.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.selenium.Commonactions;

public class FlipkartLocators extends Commonactions {

	public FlipkartLocators() {
		PageFactory.initElements(Commonactions.driver, this);
	}


	@FindBy(xpath="//span[contains(text(),'Email')]//parent::label//parent::div/input")
	private WebElement username;

	@FindBy(xpath="//span[contains(text(),'Password')]//parent::label//parent::div/input")
	private WebElement password;

	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement Login;

	@FindBy(xpath="//input[@type='text']")
	private WebElement search;

	@FindBy(xpath="//div[@id='container']//div//div//a//div[contains(text(),'GB')]")
	private WebElement mobilename;

	@FindBy(xpath="//span[text()='Next']")
	private WebElement Next;

	@FindBy(xpath="//button[text()='ADD TO CART']")
	private WebElement Addcart;
	
	@FindBy(xpath="//div[@id='container']//div//div//a//div[contains(text(),'GB')]//parent::div//following-sibling::div/div/div/div[1]")
	private WebElement price;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return Login;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getMobilename() {
		return mobilename;
	}

	public WebElement getNext() {
		return Next;
	}

	public WebElement getAddcart() {
		return Addcart;
	}

	public WebElement getPrice() {
		return price;
	}

	

}
