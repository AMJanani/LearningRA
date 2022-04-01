package jira.isssues.chaining;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class CreateAnIssue extends JiraBase {

	@Test
	public void createIssue(){
		
				
		RequestSpecification request = RestAssured.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\r\n" + 
						"    \"fields\": {\r\n" + 
						"    \"project\":\r\n" + 
						"                {\r\n" + 
						"                    \"key\": \"RA\"\r\n" + 
						"                },\r\n" + 
						"    \"summary\": \"create issue in RA project RestAssured\",\r\n" + 
						"    \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
						"    \"issuetype\": {\r\n" + 
						"                    \"name\": \"Bug\"\r\n" + 
						"                }\r\n" + 
						"    }\r\n" + 
						"}")
				;
		
		Response response = request.post();
		response.then().body(containsString("id"));
		response.then().statusCode(201);
		id = response.jsonPath().getJsonObject("id");
		System.out.println(id);
		
		System.out.println("Status code is " +response.statusCode());
	}
}
