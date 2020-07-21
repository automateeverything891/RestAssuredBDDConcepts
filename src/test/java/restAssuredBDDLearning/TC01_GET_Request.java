package restAssuredBDDLearning;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TC01_GET_Request {

	@Test
	public void getEmployeeDetails() {
		
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.assertThat().body("total_pages", equalTo(2))
		.header("Content-Type", "application/json; charset=utf-8");
		
	}
}
