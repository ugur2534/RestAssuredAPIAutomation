package com.BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BDDApproachLogs {

	@Test
	public void test1() {

		//RestAssured.baseURI = "http://localhost:3000/posts";

		RestAssured.given()
		.log()
		.all()
		.when()
		.get("http://localhost:3000/posts")
		.then()
		.log()
		.all();

		

	}

}
