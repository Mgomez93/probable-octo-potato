package stepDefenition;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import Util.BaseClass;
import Util.TestContextSetUp;
import io.cucumber.java.en.Then;

public class OfferPage_stepDefenition {
	
	TestContextSetUp testContextSetUp;
	
	//PageObjectManager pageObjectManager;
	//Single responsibilty Principle
	//loosly coupled
	//Factory Design Pattern

	
	public OfferPage_stepDefenition (TestContextSetUp testContextSetUp) {
		
		this.testContextSetUp=testContextSetUp;
		
	}
	
	@Then("User search in offerPage shortName of product {string} and extract actual name of product")
	public void user_search_in_offer_page_short_name_of_product_and_extract_actual_name_of_product(String shortName) {

		BaseClass.driver.findElement(By.xpath("//a[contains(text(),'Top Deals')]")).click();
		
		// It will return the parent window name as a String
		String parent=BaseClass.driver.getWindowHandle();

		// This will return the number of windows opened by Webdriver and will return Set of St//rings
		Set<String>s1=BaseClass.driver.getWindowHandles();

		// Now we will iterate using Iterator
		Iterator<String> I1= s1.iterator();
		
		String parentWindow = I1.next();
		String childWindow =  I1.next();
		
		BaseClass.driver.switchTo().window(childWindow);
		
		System.out.println(BaseClass.driver.getCurrentUrl());
		
		BaseClass.driver.findElement(By.id("search-field")).sendKeys(shortName);
		
		testContextSetUp.offerPageProductName = BaseClass.driver.findElement(By.xpath("//td[normalize-space()='Tomato']")).getText();
		
		
		System.out.println(testContextSetUp.offerPageProductName + " is a product on sale");
	}
	

	
	@Then("Validate homePage shortName & offerPage shortName is a match.")
	public void validate_home_page_short_name_offer_page_short_name_is_a_match() {

	Assert.assertEquals(testContextSetUp.offerPageProductName,testContextSetUp.landingproductName); 
	    

}

}
