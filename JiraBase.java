package jira.isssues.chaining;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class JiraBase {
	
	public static String id;
	
	@BeforeMethod
	public void baseSetUp() {
		RestAssured.baseURI = "https://amjanani.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication=RestAssured.preemptive().basic("amjanani1@gmail.com", "BYuMvdMJiPQ2C7mE5uOI86C7");
		
		
	}

}