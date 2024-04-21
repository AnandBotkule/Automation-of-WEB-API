package TestComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObject.landingloginPage;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public landingloginPage  loginPage;
	public WebDriver initializeDriver() {
		String browsername ="Edge";
		
		if(browsername.contains("chrome")) {
			ChromeOptions option=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browsername.contains("headless")) {
				option.addArguments("headless");
			}
			driver =new ChromeDriver(option);
			driver.manage().window().setSize(new Dimension(1440,900));		
			}
		else if(browsername.contains("Edge")) {
			EdgeOptions option=new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			if(browsername.contains("headless")) {
				option.addArguments("headless");
			}
			driver =new EdgeDriver(option);
			driver.manage().window().setSize(new Dimension(1440,900));		
			}
		else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users");
			driver = new FirefoxDriver();
			// Firefox
		} 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	@BeforeMethod(alwaysRun=true)
	public landingloginPage launchApplication() {
		driver =initializeDriver();
		loginPage =new landingloginPage(driver);
		loginPage.geturl();
		return loginPage;
		
	}
	
	
	

}