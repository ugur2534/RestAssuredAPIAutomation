package com.BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetExample {

	
	@Test
	public void test1() {
		
		
		RestAssured.baseURI = "http://localhost:3000/posts";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		
		
		System.out.println("Response Body is: " + response.print());

	}
	
}
