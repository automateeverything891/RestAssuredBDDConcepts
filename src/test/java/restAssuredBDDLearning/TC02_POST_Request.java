package restAssuredBDDLearning;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Rest.Utils.RestUtils;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class TC02_POST_Request {
	
	public static HashMap map=new HashMap();
	
	@BeforeClass
	public void postData() {
		
		map.put("name",RestUtils.empName());
		map.put("job", RestUtils.empJob());
		
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users";
	}
	
	@Test
	public void setPostData() {
		
		given().contentType("application/json; charset=utf-8")
		.body(map)
		
		.when()
			.post()
		
		.then()
			.statusCode(201)
			.statusLine("HTTP/1.1 201 Created")
			.body("id",notNullValue() )
			.body("createdAt", notNullValue());
	}
	
}
