package serializationANDdeserialization;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StudentAPIwithSerialization {
	
	@Test(priority=1)
	public void createNewStudentSerialization() {
		
		ArrayList<String> courseList=new ArrayList<String>();
		
		courseList.add("Java");
		courseList.add("Selenium");
		
		Student stu=new Student();
		
		stu.setSID(102);
		stu.setFirstName("John");
		stu.setLastName("Cena");
		stu.setEmail("john@mail.com");
		stu.setProgramme("Manager");
		stu.setCourses(courseList);
		
		given()
			.contentType(ContentType.JSON)
			.body(stu)
		.when()
			.post("http://localhost:8085/student")
		.then()
			.statusCode(201)
			.assertThat()
			.body("msg",equalTo("Student added"));
	}
	
	@Test(priority=2)
	public void getStudentRecordDeserialization() {
		
		Student stu=get("http://localhost:8085/student/102").as(Student.class);
		
		System.out.println(stu.getStudentRecord());
		Assert.assertEquals(stu.getId(),102);
		
		System.out.println("ID is: "+stu.getId());
		System.out.println("First Name is: "+stu.getFirstName());
		System.out.println("Last Name is: "+stu.getLastName());
		System.out.println("Email is: "+stu.getEmail());
		System.out.println("Programme is: "+stu.getProgramme());
		System.out.println("Courses : "+stu.getcourses());
	}

}
