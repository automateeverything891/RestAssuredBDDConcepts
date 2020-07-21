package serializationANDdeserialization;

import java.sql.Timestamp;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class VideoGameAPISerialization {

	@Test(priority=1)
	public void postVideoGameSerializationXML() {
		
		VideoGame vg=new VideoGame();
		vg.setSID(13);
		vg.setName("PUBG");
		vg.setReleaseDate("2020-03-23");
		vg.setRating("Violent");
		vg.setReviewScore(5);
		vg.setCategory("PvP");
		
		given()
			.contentType("application/xml")
//			For JSON Response Validation
//			.contentType("application/json")
			.body(vg)
		.when()
			.post("http://localhost:8080/app/videogames")
		.then()
			.log().all()
			.body(equalTo("{\"status\": \"Record Added Successfully\"}"));
	}
	
	@Test(priority=2)
	public void getVideoGameSerializationXML() {
		VideoGame vg=get("http://localhost:8080/app/videogames/13").as(VideoGame.class);
		System.out.println(vg.getVideoGameDetails());
	}
}
