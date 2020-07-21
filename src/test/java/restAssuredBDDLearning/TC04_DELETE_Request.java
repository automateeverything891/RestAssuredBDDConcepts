package restAssuredBDDLearning;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC04_DELETE_Request {

	
	@BeforeClass
	public void setDeleteData() {
	
	RestAssured.baseURI="https://reqres.in";
	RestAssured.basePath="/api/users/2";
	
	}

	@Test
	public void deleteData() {
		
		given()
		
		.when()
			.delete()
		.then()
			.statusCode(204)
			.statusLine("HTTP/1.1 204 No Content")
			.log().all();
	}
}
