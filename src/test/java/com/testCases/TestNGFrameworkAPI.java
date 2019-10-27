package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.extentreport.ExtendsReport;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestNGFrameworkAPI extends ExtendsReport{

	
	@Test
	public void getTest() {
		RestAssured.baseURI = "http://localhost:3000/posts";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		
		
		System.out.println("Response Body is: " + response.print());
		
		

	}
	@Test(dependsOnMethods = { "getTest" })
	public void posttest() {
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-type","application/json");

		JsonObject json= new JsonObject();
		json.addProperty("id", "22");
		json.addProperty("title", "Smart tech");
		json.addProperty("author", "sarower");
		
		request.body(json.toString());
		Response response = request.post("http://localhost:3000/posts");
		
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		
		Assert.assertTrue(statuscode==201);
	}
	@Test(dependsOnMethods = { "posttest" })
	public void putTest() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-type","application/json");

		JsonObject json= new JsonObject();
		json.addProperty("id", "22");
		json.addProperty("title", "Smart tech IT Solution");
		json.addProperty("author", "Ahmmed");
		
		request.body(json.toString());
		Response response = request.put("http://localhost:3000/posts/22");
		
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		
		Assert.assertTrue(statuscode==200);
	}
	
	@Test(dependsOnMethods = { "putTest" })
	public void patchTest() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-type","application/json");

		JsonObject json= new JsonObject();
		json.addProperty("id", "22");
		json.addProperty("title", "Automation API");
		json.addProperty("author", "Ahmmed");
		
		request.body(json.toString());
		Response response = request.patch("http://localhost:3000/posts/22");
		
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		
		Assert.assertTrue(statuscode==200);
	}
	@Test(dependsOnMethods = { "patchTest" })
	public void deleteTest() {
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.delete("http://localhost:3000/posts/22");
		
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		
		Assert.assertTrue(statuscode==200);
	}
	
}
