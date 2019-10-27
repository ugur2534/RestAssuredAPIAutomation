package com.BDD;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class BDD_AproachDataValidation {
	
	@Test
	public void test1() {

		RestAssured.baseURI = "http://localhost:3000/posts/3";
		JsonPath jp= RestAssured.given().get().jsonPath();
		
		RestAssured.given()
		.when()
		.get()
		 .then().assertThat()
	      .statusCode(200).and()
	      .body("title", equalTo("Smart tech"))
	      .body("author", equalTo("280.32"));
	}

}
