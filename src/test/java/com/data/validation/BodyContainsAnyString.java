package com.data.validation;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BodyContainsAnyString {

	
	@Test
	public void dataValidation() {
	RestAssured.baseURI = "http://localhost:3000/posts/99";
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.get();
	System.out.println("-------------");
	RestAssured.given()
	.when()
	.get()
	 .then().assertThat()
      .statusCode(200).and()
      .body("sys.country",equalTo("USA"))
    .body("City",equalTo("New York"));
}
}
