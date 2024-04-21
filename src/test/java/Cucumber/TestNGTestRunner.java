package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="Stepdefinitions",
monochrome=true, publish=true,tags = "@tagurpage", plugin= {"pretty","html:target/cucumber.html",
		                                  "json:target/cucumberreport.json",
		                                  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

                                           
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

	
}