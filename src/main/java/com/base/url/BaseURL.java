package com.base.url;

import io.restassured.RestAssured;


public class BaseURL {

	public void loadApiUrl() {
		RestAssured.baseURI = "http://localhost:3000/posts";
	}

	

}
