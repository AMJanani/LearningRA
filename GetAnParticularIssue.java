package jira.isssues.chaining;

import static org.hamcrest.Matchers.containsString;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAnParticularIssue extends JiraBase{
	
	@Test(dependsOnMethods = "jira.isssues.chaining.CreateAnIssue.createIssue")
	public void getAnIssue(){
		
		RequestSpecification request = RestAssured.given().log().all().accept(ContentType.JSON);
		Response response = request.get(id);

		response.then().body(containsString("id"));
		response.then().statusCode(200);
		
		response.prettyPrint();
		
	}

}
