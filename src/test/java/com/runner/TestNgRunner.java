package com.runner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		plugin = { "pretty:target/cucumber-pretty",
					"html:target/cucumber-html", 
					"rerun:target/rerun.txt",
					"json:target/cucumber.json" }, 
		
		snippets = SnippetType.UNDERSCORE, 
		features = {"src/test/resources/Login.feature" }, 
		glue = { "com.stepdef" } // package name
)

public class TestNgRunner extends AbstractTestNGCucumberTests{
	
	@BeforeTest
	public void setup() {
		//code
		
	}
	@Test
	public void test() {
		//code
		
	}
	@AfterTest
	public void teardown() {
		//code
		
	}
	

}
