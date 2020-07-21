package serializationANDdeserialization;

import java.util.ArrayList;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class StudentAPIwithoutSerialization {

	public HashMap map=new HashMap();
	
	@Test(priority=1)
	public void createNewStudent() {
		
		map.put("id",101);
		map.put("firstName","Richard");
		map.put("lastName","Thomson");
		map.put("email","richard@mail.com");
		map.put("programme","Manager");
		
		ArrayList<String> courseList=new ArrayList<String>();
		courseList.add("Rest Assured");
		courseList.add("BDD");
		
		map.put("courses",courseList);
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post("http://localhost:8085/student")
		.then()
			.statusCode(201)
			.assertThat()
			.body("msg",equalTo("Student added"));
	}
	
	@Test(priority=2)
	public void getStudentDetails() {
		given()
			.when()
				.get("http://localhost:8085/student/101")
			.then()
				.statusCode(200)
				.assertThat()
				.body("lastName",equalTo("Thomson"))
				.log().all();
	}
}
