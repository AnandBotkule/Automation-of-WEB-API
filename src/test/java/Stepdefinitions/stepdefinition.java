package Stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;

import PageObject.landingloginPage;
import Restassured.APIAssured;
import TestComponents.BaseTest;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefinition extends BaseTest {
	public landingloginPage loginPage;
	@Given("I landed on Bank portal Page")
	public void i_landed_on_bank_portal_page() {
	    // Write code here that turns the phrase above into concrete actions
		loginPage = launchApplication();
	}
	@When("Logged in with {string} and {string}")
	public void logged_in_with_and(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.logintoportal("hello","hello");
	}
	@Then("{string} message is displayed")
	public void message_is_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.errormessage("Please enter a username and password.");
	}
	//API
	@Given("Get API Url")
	public void get_api_url() {
	    APIAssured.GetRestassured();
	}

	@When("Request body Specification")
	public void request_body_specification() {
		APIAssured.requestspecificationparabank();
	}

	@When("Response body Specification")
	public void response_body_specification() {
		APIAssured.responsespecificationcall();
	}

	@When("Sending the get API call with response {int}")
	public void sending_the_get_api_call_with_response(int code) {
		APIAssured.Sendingcall(code);
	}

	@Then("{int} and {string} message is displayed")
	public void and_message_is_displayed(int code, String type) {
		APIAssured.reponsecode(code,type);
	}
	//screenshot
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		if(driver != null) {
		  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
		  scenario.attach(fileContent, "image/png", "screenshot");
		}
		
	}
}
