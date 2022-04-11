package com.framework;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.projectreport.FacebookProjectReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",glue="com.frameworkstep",dryRun=false,monochrome=true,
plugin= {"pretty","html:src/test/resources/ReportFormat/HTML.html",
		"json:src/test/resources/ReportFormat/JSON.json",
		"junit:src/test/resources/ReportFormat/JUNITFILE.xml"})
public class FrameWorkTestRunner {
	
	@AfterClass
	public static void afterClass() {
		
		FacebookProjectReport.projectReport("C:\\\\Users\\\\Radha\\\\eclipse-workspace\\\\FrameWork\\\\src\\\\test\\\\resources\\\\ReportFormat\\\\JSON.json");
		
	}

}
