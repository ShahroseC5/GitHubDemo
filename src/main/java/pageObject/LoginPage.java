package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	
	
	By forgetpassowrd= By.cssSelector("[href*='password/new']");
	public ForgotPassword ForgetPassword() {
		driver.findElement(forgetpassowrd).click();
		ForgotPassword f= new ForgotPassword(driver);
		
	return f;
	
		
	}

	By Email= By.id("user_email");
	public WebElement Email() {
		
		return driver.findElement(Email);
		
		
		
		
	}

	By Password= By.id("user_password");
	public WebElement Password() {
		
		return driver.findElement(Password);
		
		
		
		
	}
	
	By Submit= By.cssSelector("input[type='submit']");
	public WebElement submit() {
		
		return driver.findElement(Submit);
		
		
		
		
	}
	
}
