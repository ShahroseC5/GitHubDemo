package End;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Landingpage;
import pageObject.LoginPage;
import resources.base;

public class validationTitle extends base {
	public WebDriver driver;
	Landingpage ld;
	private static Logger Log = LogManager.getLogger(validationTitle.class.getName());
	
	@BeforeTest
	public void intialize() throws IOException {
		driver= intializerDriver();
	Log.info("Driver is intialized");
		
		driver.get(prop.getProperty("url"));
	}
	
	@Test ()
	public void  basenavigation () throws IOException {
		
		
		//Create object to that class and invoke methods of it 
	 ld= new Landingpage(driver);
	
		AssertJUnit.assertEquals(ld.getTitle().getText(), "FEATURED COURSES"); //Take screenshot at failure
		Log.info("Succesfully validated Text message");
		
		
	
	
		}
	@Test 
	public void gettingHeader () {
		
		Assert.assertEquals(ld.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	driver.quit();
	}
	
}
