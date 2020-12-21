package com.flipkart.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.flipkart.selenium.Commonactions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends Commonactions {

	Commonactions ca = new Commonactions();


	@Before()
	public void before() throws Throwable 
	{
		ca.launch("https://www.flipkart.com/");
		System.out.println("User launches application");
	}

	@After()
	public void after(Scenario scenario)  
	{
		ca.closeBrowser();
	}

}
