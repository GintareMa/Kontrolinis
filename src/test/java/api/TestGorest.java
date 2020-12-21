package api;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestGorest {
	private final String TOKEN = "af7bdd32e9df8a7d730659cc2edffa55e63f06aa06de28e531930e43a066198e";
	private final String pageUrl = "https://gorest.co.in/";
	
	
  @Test
  public void f() {
	  
		String userName = "Toma";
		String userEmail = "Toma" + new Random().nextInt(1000) + "@gmail.com";

		String endpointPostUser = "public-api/users";

		Map user = new HashMap<>();
		user.put("name", userName);
		user.put("email", userEmail);
		user.put("gender", "Female");
		user.put("status", "Active");


		int userID = given(). 
			auth().
			oauth2(TOKEN).
			contentType(ContentType.JSON).body(user).
			log().all().
		when().
			post(pageUrl + endpointPostUser).
		then().
			assertThat().
			statusCode(200).
			body("code", is(201)).
			log().all().
			extract(). 
			path("data.id");
	  
		
		
		String endpointUser = "public-api/users/{userId}";
		
		given().
		pathParam("userId", userID).
		log().all().
	when().	
		get(pageUrl + endpointUser).
	then().
		assertThat().
		body("data.name", is(userName)).
		log().all();
  }
  
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
