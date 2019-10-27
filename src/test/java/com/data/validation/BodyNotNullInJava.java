package com.data.validation;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BodyNotNullInJava {

	
	@Test
	public void dataValidation() {
	RestAssured.baseURI = "http://localhost:3000/posts/99";
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.get();
	
		
	List<String> list = new ArrayList<String>();
	list.add(response.getBody().toString()); 
	
	if(list.size()>0){
		  System.out.println("Body not null");
		}
	
	
	JsonPath jsonResponse = new JsonPath(response.asString());
	
	List<String> list1 = new ArrayList<String>();
	list1.add(jsonResponse.get("sys.country")); 
	
	for(String country : list1){
		  if(country.contains("UK")){
			  System.out.println("Found UK");
		  }else {
			  
			  System.out.println("UK not found");  
		  }
		}
	  
	
	}
	
	
	
	
}
