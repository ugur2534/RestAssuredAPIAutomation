package com.post.delete.put;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostExample {
	@Test
	public void test1() {

		RequestSpecification request = RestAssured.given();
		request.header("Content-type", "application/json");

		JsonObject json = new JsonObject();
		
		json.addProperty("First_name", "sarower");
		json.addProperty("last_name", "Ahmmed");
		json.addProperty("Company", "Smart Tech");
		json.addProperty("Phone", "718-913-7566");
		json.addProperty("Email", "sarowerny@gmail.com");
		json.addProperty("Job title", "QA Lead");
		
		request.body(json.toString());
		Response response = request.post("http://localhost:3000/posts");

		int statuscode = response.getStatusCode();
		System.out.println(statuscode);

		Assert.assertTrue(statuscode == 201);
	}

	

}
