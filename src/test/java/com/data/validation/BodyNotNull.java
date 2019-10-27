package com.data.validation;

import static io.restassured.RestAssured.get;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.url.BaseURL;

import io.restassured.path.json.JsonPath;

public class BodyNotNull {

	@Test
	public void dataValidation() {
		new BaseURL().loadApiUrl();
		String bodyAsString = get().getBody().asString();
		System.out.println(bodyAsString);
		Assert.assertTrue(!bodyAsString.isEmpty());
		
		int sizeOfRecords = get().body().path("coord.size()");
		int sizeOfName = get().body().path("weather.size()");
		// System.out.println(sizeOfName+"::Total Name");
		Assert.assertEquals(sizeOfRecords, sizeOfName, "Planet name count matched with record number");

		
	
}
}

