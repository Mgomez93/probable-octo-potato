package stepDefenition;

import org.openqa.selenium.By;
import Util.BaseClass;
import Util.TestContextSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LandingPage_stepDefenition {
	
	public String landingproductName;
	public String offerPageProductName;
	
	TestContextSetUp testContextSetUp;

	
	public LandingPage_stepDefenition (TestContextSetUp testContextSetUp) {
		
		this.testContextSetUp=testContextSetUp;
		
	}

@Given("User is on GreenKart landing page")
public void user_is_on_green_kart_landing_page() {
	
	BaseClass.getDriver();
	
}

@When("^User search in homePage shortName of product {string} and extract actual name of product$")
public void user_search_in_home_page_short_name_of_product_and_extract_actual_name_of_product(String shortName) {
 
	BaseClass.driver.findElement(By.className("search-keyword")).sendKeys(shortName);
	testContextSetUp.landingproductName = BaseClass.driver.findElement(By.xpath("//h4[contains(text(),'Tomato')]")).getText().split("-")[0].trim();
	
	System.out.println("Product " +  landingproductName + " is extracted from home page");
}




}
