package com.frameworkstep;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FworkStepDefn extends BaseClass{
	
	@Given("User should lanuch the browser")
	public void user_should_lanuch_the_browser() {
	   
		getDriver(); getUrl("https://www.facebook.com/"); implicitywaits(30);
	}

	@When("User is on the Facebook Home page")
	public void user_is_on_the_facebook_home_page() {
	    
		System.out.println("This is the Facebook Home Page");
	}

	@Then("Check the field are enabled or not")
	public void check_the_field_are_enabled_or_not() {
	    
		Assert.assertTrue("Verify the username field is enabled", elementById("email").isEnabled());
		Assert.assertTrue("Verify the Password field is enabled", elementById("pass").isEnabled());
		
		System.out.println("The fields are enabled");
	}

	@When("user should enter the data")
	public void user_should_enter_the_data() {
	   
		sendkeys(elementById("email"), "Test1"); sendkeys(elementById("pass"), "Test1");
	}

	@Then("Check the field is accepted the value or not")
	public void check_the_field_is_accepted_the_value_or_not() {
	    
		Assert.assertEquals("Test1", elementById("email").getAttribute("value"));
		Assert.assertEquals("Test", elementById("pass").getAttribute("value"));
	}
	

}
