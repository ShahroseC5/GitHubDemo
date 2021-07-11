package pageObject;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ForgotPassword {

	public WebDriver driver;
	
	private static Logger Log = LogManager.getLogger(ForgotPassword.class.getName());
	
	
	
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	

	By Email= By.id("user_email");
	public WebElement Email() {
		
		return driver.findElement(Email);
		
		
		
		
	}

	By SendmeInstructions= By.cssSelector("input[type='submit']");
	
	public WebElement SendInstructions() {
		
		return driver.findElement(SendmeInstructions);
		
		
		
		
	}
	


}
