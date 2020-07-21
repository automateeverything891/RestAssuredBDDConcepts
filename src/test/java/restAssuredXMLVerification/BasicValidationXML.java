package restAssuredXMLVerification;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicValidationXML {

//1.Verifying Single context in XML Response
	@Test(priority=1)
	public void testSingleContent() {
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
			
		.then()
			.body("CUSTOMOER.ID",equalTo("15"))
			.log().all();
			
	}
	
	
//2.Verify multiple contents from the XML Response
	@Test(priority=2)
	public void testMultipleContent() {
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
			
		.then()
			.body("CUSTOMOER.ID",equalTo("15"))
			.body("CUSTOMOER.FIRSTNAME",equalTo("Bill"))
			.body("CUSTOMOER.LASTNAME",equalTo("Clancy"))
			.body("CUSTOMOER.STREET",equalTo("319 Upland pl."))
			.body("CUSTOMOER.CITY",equalTo("Seattle`"));
	}

	//3.Verify multiple contents from the XML Response in one go & use of Xpath text() function
		@Test(priority=3)
		public void testMultipleContentInOneGo() {
			
			given()
			
			.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
				
			.then()
			// ".text()" method is used to convert the XML response of CUSTOMER into Text format
			//All the text of the response body of all headers are added continuously in the equalTo()
				.body("CUSTOMOER.text()",equalTo("15BillClancy319 Upland pl.Seattle"));
		}

	//4.Find Values using XML Path in XML Response
		@Test(priority=4)
		public void getUsingXPath() {
			given()
			.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
			.then()
			//Use the hasXPath() & specify the path if the attribute in the XML tree
			//Use contains() methods to check the XML response
				.body(hasXPath("/CUSTOMER/FIRSTNAME"), containsString("Bill"));
		}
		
		@Test(priority=5)
		public void getUsingXPath2() {
			given()
			.when()
				.get("http://thomas-bayer.com/sqlrest/INVOICE/")
			.then()
			
			//Write the XPath to the Element wgich you want to verify in the XML Tree
				.body(hasXPath("/CUSTOMER/INVOICE[text()='30]"));
		}
}
