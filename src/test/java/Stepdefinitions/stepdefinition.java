package Stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;

import PageObject.landingloginPage;
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
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
		  scenario.attach(fileContent, "image/png", "screenshot");
		
	}
}
