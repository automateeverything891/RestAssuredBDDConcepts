package restAssuredBDDLearning;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

/* 1.Test Status Code
2.Log Response
3.Verifying single content in response body
4.Verifying Multiple content in Response Body
5.Setting Parameters and Headers
*/
public class TC06_Basic_Validation {
	
//	1.Test Status Code
	@Test(priority=1)
	public void testStatusCode() {
		
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/5")
		
		.then()
			.statusCode(200);
		
		//given() is optional, but when you start without given() , "." is not required before when()
	/*	when()
		.get("https://jsonplaceholder.typicode.com/posts/5")
	
		.then()
		.statusCode(200);
		
	*/
		//writing above code in single line
//		given().when().get("https://jsonplaceholder.typicode.com/posts/5").then().statusCode(200);
		
	}
	
//	2.Log Response
	@Test(priority=2)
	public void testLogresponse() {
		
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/users/1")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
//	3.Verifying single content in response body
	@Test(priority=3)
	public void verifySingleElement() {
		
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/users/1")
		
		.then()
			.statusCode(200)
			//use JSON path chrome extension to get the json path for complex elements
			//.body(JSON PATH,Expected Result)
			.body("address.city", equalTo("Gwenborough"));
	}
	
//	4.Verifying Multiple content in Response Body
	@Test(priority=4)
	public void verifyMultipleElement() {
		
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/users")
		
		.then()
			.statusCode(200)
			//use JSON path chrome extension to get the json path for complex elements
			//IN this case same json path refers to multiple records with same header
			//Here every user has a header called as city under address
			//.body(JSON PATH,hasItems("Item1","Item2","Item3")
			.body("address.city", hasItems("Gwenborough","Wisokyburgh","McKenziehaven","South Elvis"));
	}
	
//	5.Setting Parameters and Headers
	@Test(priority=5)
	public void passingParamsANDHeaders() {
		
		given()
			.param("email","eve.holt@reqres.in")
			.param("password", "cityslicka")
			.headers("Contennt-Type","application/json; charset=utf-8")
		
		.when()
			.get("https://reqres.in/api/login")
		
		.then()
			.statusCode(200)
			.log().all();
	}
}