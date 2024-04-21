package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;





public class landingloginPage extends AbstractComponent {
	WebDriver driver;
	
	public landingloginPage(WebDriver driver) {
		super(driver);
		this .driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (xpath="//input[@name='username']")
	WebElement Username;
	
	@FindBy (xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy (xpath="//input[@value='Log In']")
	WebElement login;
	
	@FindBy (xpath="//p[@class='error']")
	WebElement Error;
	
	public String logintoportal(String name , String pswd) {
		Username.sendKeys(name);
		Password.sendKeys(pswd);
		login.click();
		return pswd;
		
	}
	public void geturl() {
		driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
	}
	public String errormessage(String textmsg) {
		textmsg=Error.getText();
		return textmsg;
		
	}
			

}
