package com.cucumber.framework;

import org.testng.Assert;

import com.google.gson.JsonObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDef {

	Response response;
	int statuscode;

	@Given("User able to go {string}")
	public void user_able_to_go(String URL) {

		response = RestAssured.get(URL);
	}

	@Given("Post the weather json to server")
	public void post_the_weather_json_to_server() {

		RequestSpecification request = RestAssured.given();
		request.header("Content-type", "application/json");

		JsonObject json = new JsonObject();

		json.addProperty("First_name", "sarower");
		json.addProperty("last_name", "Ahmmed");
		json.addProperty("Company", "Smart Tech");
		json.addProperty("Phone", "718-913-7566");
		json.addProperty("Email", "sarowerny@gmail.com");
		json.addProperty("Job title", "QA Lead");
		json.addProperty("id", "33");
		request.body(json.toString());
		Response response = request.post("http://localhost:3000/posts");

		statuscode = response.getStatusCode();
		System.out.println(statuscode);

	}

	@Then("User able to validate status code is {int}")
	public void user_able_to_validate_status_code_is(Integer code) {
		Assert.assertTrue(statuscode == code);

	}

	@When("get json body response from the server {string}")
	public void get_json_body_response_from_the_server(String string) {

		// Response response = RestAssured.given().get();

		System.out.println("Response Body is: " + response.print());
	}

	@Then("Verify that following {string} are available in resonse body coord, weather,  main, visibility, wind ,clouds, sys")
	public void verify_that_following_are_available_in_resonse_body_coord_weather_main_visibility_wind_clouds_sys(
			String string) {

		RestAssured.baseURI = "http://localhost:3000/posts/99";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		Assert.assertTrue(jsonPathEvaluator.get("coord").toString() != null);
		Assert.assertTrue(jsonPathEvaluator.get("wind").toString() != null);
		Assert.assertTrue(jsonPathEvaluator.get("main.temp").toString() != null);
		Assert.assertTrue(jsonPathEvaluator.get("City").toString() != null);

	}

	@Then("verify id contains {int}")
	public void verify_id_contains(Integer int1) {

	}

	@Then("verify id {int} not present")
	public void verify_id_not_present(Integer int1) {
		
		
	}

	@Then("verify the context type in json format")
	public void verify_the_context_type_in_json_format() {
		
		
	}

	@Then("verify country is USA")
	public void verify_country_is_USA() {
		
		
	}

	@Then("verify country Bangladesh  is not there")
	public void verify_country_Bangladesh_is_not_there() {
		
		
	}

	@Then("Verify city name is New York")
	public void verify_city_name_is_New_York() {
		
		
	}

	@Then("Verify city name Las Vagus is not there")
	public void verify_city_name_Las_Vagus_is_not_there() {
		
		
	}

	@When("Update  city name to Arizona")
	public void update_city_name_to_Arizona() {
		
		
	}

	@Then("validate update status code is {int}")
	public void validate_update_status_code_is(Integer int1) {
		
		
	}

	@When("Detele the json weather data")
	public void detele_the_json_weather_data() {
		
		
	}

	@Then("User able to validate delete status code is {int}")
	public void user_able_to_validate_delete_status_code_is(Integer int1) {
		
		
	}

}