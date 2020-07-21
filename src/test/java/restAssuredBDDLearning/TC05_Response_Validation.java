package restAssuredBDDLearning;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Rest.Utils.RestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC05_Response_Validation {

public static HashMap map=new HashMap();
	
	@BeforeClass
	public void postData() {
		
		map.put("name",RestUtils.email());
		
		
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/register";
	}
	
	@Test
	public void setPostData() {
		
		//Create a Variable of "Response" to store the complete response received after Request 
		Response response=
		
		given().contentType("application/json; charset=utf-8")
		.body(map)
		
		.when()
			.post()
		
		.then()
			.statusCode(400)
			.statusLine("HTTP/1.1 400 Bad Request")
			
			//Extract and store the response in the variable created above
			.extract().response();
		
			//Convert received JSON response into String 
			String jsonrespAsString = response.asString();
			
			//Assert for the Expected Message in the Body
			Assert.assertEquals(jsonrespAsString.contains("Missing email or username"),true);
			
	}
			
}
