package com.data.validation;

import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CheckAttributeValue {

	@Test
	public void dataValidation() {

		RestAssured.baseURI = "http://localhost:3000/posts/99";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		System.out.println("Coord received from Response:: " + jsonPathEvaluator.get("coord"));

		System.out.println("Wind received from Response:: " + jsonPathEvaluator.get("wind"));
		System.out.println("Temp received from Response:: " + jsonPathEvaluator.get("main.temp"));
		System.out.println("Country received from Response:: " + jsonPathEvaluator.get("City"));

	}

}
