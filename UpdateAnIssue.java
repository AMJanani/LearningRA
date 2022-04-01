package jira.isssues.chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateAnIssue extends JiraBase {

	@Test(dependsOnMethods = "jira.isssues.chaining.GetAnParticularIssue.getAnIssue")
	public void updateIssue(){
		
				
		RequestSpecification request = RestAssured.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\r\n" + 
						"    \"fields\": {\r\n" + 
						"       \r\n" + 
						"        \"description\": \"Issue updated via RestAssured\"\r\n" + 
						"\r\n" + 
						"    }\r\n" + 
						"}\r\n" + 
						"")
				;
		
		Response response = request.put(id);
		response.then().statusCode(204);

		response.prettyPrint();
		System.out.println("Status code is " +response.statusCode());
	}
}
