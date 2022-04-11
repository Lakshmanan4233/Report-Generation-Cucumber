package com.frameworkstep;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {
	
	
	@Before
	public void beforeScenario() {
		
		System.out.println("Scenario Started..........");
	}
	
	@After
	public void afterScenario(Scenario s) {
		
		if(s.isFailed()) {
			
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			byte[] failureCase = screenshot.getScreenshotAs(OutputType.BYTES);
			s.attach(failureCase, "Picture", "failureScaenrio.png");
		}
		
		close();
	}

}
