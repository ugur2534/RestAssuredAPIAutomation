package com.http.methods;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutExample {

	@Test
	public void test1() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-type","application/json");

		JsonObject json= new JsonObject();
		json.addProperty("id", "100");
		json.addProperty("Name", "Smart tech IT Solution");
		
		
		request.body(json.toString());
		Response response = request.put("http://localhost:3000/posts/100");
		
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		
		Assert.assertTrue(statuscode==200);
	}
	
}
