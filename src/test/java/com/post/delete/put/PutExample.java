package com.post.delete.put;

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
		json.addProperty("id", "3");
		json.addProperty("title", "Smart tech IT Solution");
		json.addProperty("author", "Sarower");
		
		request.body(json.toString());
		Response response = request.put("http://localhost:3000/posts/3");
		
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		
		Assert.assertTrue(statuscode==200);
	}
	
}
