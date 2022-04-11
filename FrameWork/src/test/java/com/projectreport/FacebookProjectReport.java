package com.projectreport;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class FacebookProjectReport {
	
	
	public static void projectReport(String reportFile) {
		
		File file = new File("C:\\\\Users\\\\Radha\\\\eclipse-workspace\\\\FrameWork\\\\src\\\\test\\\\resources\\\\Project Report");
		
		Configuration con = new Configuration(file, "FaceBook Home Page");
		
		con.addClassifications("Test", "Home Page");
		
		List<String> a = new ArrayList();
		
		a.add(reportFile);
		
		ReportBuilder builder = new ReportBuilder(a, con);
		
		builder.generateReports();
		

	}

}
