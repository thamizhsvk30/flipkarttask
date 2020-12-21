package com.flipkart.stepdefinition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.flipkart.objectrepository.FlipkartLocators;
import com.flipkart.selenium.Commonactions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlipkartStepDefinition extends Commonactions {
	Commonactions ca = new Commonactions();
	FlipkartLocators fl= new FlipkartLocators();
	ArrayList<String> ll;
	ArrayList<String> lp;
	ArrayList<Integer> pp;
	ArrayList<String> sp;
	HashMap<String,String> ss;
	ArrayList<Integer> so;
	String name;
	String price;
	Integer pricevalue;
	String pricestringvalue;


	@Given("Enter credentials for flipkart app using {string},{string}")
	public void enter_credentials_for_flipkart_app_using(String uname, String pwd) throws Throwable {

		insertText(fl.getUsername(), uname);
		insertText(fl.getPassword(), pwd);
		ca.click(fl.getLogin());
		ca.pagewait();

	}

	@When("Search mobile in the search field  {string}")
	public void search_mobile_in_the_search_field(String mobile) {
		ca.searchText(fl.getSearch(), mobile);
	}

	@And("Product name and price of the product store should be stored in the ArrayList")
	public void product_name_and_price_of_the_product_store_should_be_stored_in_the_ArrayList() throws Throwable {

		List<WebElement> mobName = driver.findElements(By.xpath("//div[@id='container']//div//div//a//div[contains(text(),'GB')]"));
		List<WebElement> mobprice =driver.findElements(By.xpath("//div[@id='container']//div//div//a//div[contains(text(),'GB')]//parent::div//following-sibling::div/div/div/div[1]"));

		ll = new ArrayList<String>();
		lp = new ArrayList<String>();
		ss=new HashMap<String, String>();
		for (int i = 0; i < mobName.size(); i++) {

			name = mobName.get(i).getText();
			price = mobprice.get(i).getText();
			ll.add(name);
			lp.add(price);
			ss.put(name, price);

		}

		ca.movetoele(fl.getNext());
		ca.click(fl.getNext());
		ca.pagewait();


		List<WebElement> mobName2 = driver.findElements(By.xpath("//div[@id='container']//div//div//a//div[contains(text(),'GB')]"));
		List<WebElement> mobprice2 =driver.findElements(By.xpath("//div[@id='container']//div//div//a//div[contains(text(),'GB')]//parent::div//following-sibling::div/div/div/div[1]"));

		for (int i = 0; i < mobName2.size(); i++) {

			name = mobName2.get(i).getText();
			price = mobprice2.get(i).getText();
			ll.add(name);
			lp.add(price);
			ss.put(name, price);
		}
		System.out.println(ll +" "+lp);
		//ss.put(name, price);
	}

	@Then("Print the lowest price product in the console")
	public void print_the_lowest_price_product_in_the_console() {

		int size = lp.size();
		pp = new ArrayList<Integer>();
		for(int i=0;i<size;i++)
		{
			for (Object oo : lp) {
				String price = oo.toString();
				String rr = price.replace("₹", "");
				String rrr = rr.replace(",", "");
				System.out.println(rrr);
				int pricing=Integer.parseInt(rrr);  
				pp.add(pricing);
			}
			Collections.sort(pp);

			System.out.println("After Sorting:");
			TreeSet<Integer> ff = new TreeSet<Integer>();
			ff.addAll(pp);
			//System.out.println(ff);
			so= new ArrayList<Integer>();
			for (Integer s : ff) 
			{
			   // System.out.println(s);
			    so.add(s);
			}
			pricevalue = so.get(1);
			pricestringvalue = Integer.toString(pricevalue);

		}

	}

	@Then("Add to cart a mobile second-lowest product.")
	public void add_to_cart_a_mobile_second_lowest_product() throws Throwable {
		Set<Entry<String, String>> entrySet = ss.entrySet();
		for (Entry<String, String> entry : entrySet) {
			String key = entry.getKey();
			String value = entry.getValue();
			
			String rr = value.replace("₹", "");
			String pricing = rr.replace(",", "");
			//System.out.println(pricing);
			
			
			if(pricing.contains(pricestringvalue))
			{
				ca.searchText(fl.getSearch(), key);
			}
		}
		
		ca.click(fl.getMobilename());
		ca.pagewait();
		ca.switchToWindow();
		ca.pagewait();
		ca.click(fl.getAddcart());
		ca.pagewait();

		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("viewcart"))
		{
			System.out.println("mobile second-lowest product has added into cart");
		}
	}



}