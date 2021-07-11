package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {

	public WebDriver driver;
	
	
	
	
	public Landingpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	

	private By signin= By.cssSelector("a[href*='sign_in']");
	
	private @FindBy(css="div[class*='video-banner'] h3")
	WebElement Header;
	
	private @FindBy(css=".nav.navbar-nav.navbar-right")
	WebElement Bar;
	
	
	private @FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	WebElement getTitle;

	
	public WebElement getTitle() {
		
		return getTitle;
}
	
	public LoginPage getlogin() {
		
		driver.findElement(signin).click();
		LoginPage lo=new LoginPage(driver);
		return new LoginPage(driver);
		
		
		
		
		
	}
	
public WebElement getHeader() {
		
		return Header;
		
		
		
		
	}
	
	public WebElement Navbar() {
		
		return Bar;
		
		
		
		
	}
	
	
	
}
