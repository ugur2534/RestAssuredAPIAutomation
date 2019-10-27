package com.data.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CheckAttributePresentOrNot {

	@Test
	public void dataValidation() {

		RestAssured.baseURI = "http://localhost:3000/posts/99";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		Assert.assertTrue(jsonPathEvaluator.get("coord").toString() != null);
		Assert.assertTrue(jsonPathEvaluator.get("wind").toString() != null);
		Assert.assertTrue(jsonPathEvaluator.get("main.temp").toString() != null);
		Assert.assertTrue(jsonPathEvaluator.get("City").toString() != null);
	

		System.out.println("Passed");
	}

}
