package restAssuredBDDLearning;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Rest.Utils.RestUtils;

import io.restassured.RestAssured;

public class TC03_PUT_Request {
	
	public static HashMap map=new HashMap();
	
	@BeforeClass
	public void putData() {
		
		map.put("name",RestUtils.empName());
		map.put("job", RestUtils.empJob());
		
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users/2";
	}
	
	@Test
	public void setPutData() {

	given()
		.contentType("application/json; charset=utf-8")
		.body(map)
	.when()
		.put()
	.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.body("updatedAt", notNullValue())
		
		//log().all() will give the complete data received as part of the response in the console
		.log().all();
	
	}
}
