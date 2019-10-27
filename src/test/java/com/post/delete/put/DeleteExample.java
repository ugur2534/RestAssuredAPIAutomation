package com.post.delete.put;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteExample {
	
	@Test
	public void test1() {
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.delete("http://localhost:3000/posts/1");
		
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		
		Assert.assertTrue(statuscode==200);
	}
	

}
