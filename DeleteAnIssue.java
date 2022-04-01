package jira.isssues.chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteAnIssue extends JiraBase{
	
	@Test(dependsOnMethods = "jira.isssues.chaining.UpdateAnIssue.updateIssue")
	public void getAnIssue(){
		
		RequestSpecification request = RestAssured.given().log().all();
		Response response = request.delete(id);

		response.then().statusCode(204);
		System.out.println("Status code is " +response.statusCode());
		
	}

}
