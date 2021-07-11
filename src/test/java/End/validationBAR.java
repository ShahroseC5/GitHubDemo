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

public class validationBAR extends base {
public WebDriver driver;
	private static Logger Log = LogManager.getLogger(validationBAR.class.getName());
	
	@BeforeTest
public void intialize() throws IOException {
	driver= intializerDriver();
	driver.get(prop.getProperty("url"));
}
	
	
	@Test ()
	public void  basenavigation () throws IOException {
	
		//Create object to that class and invoke methods of it 
		Landingpage ld= new Landingpage(driver);
	
	ld.Navbar().isDisplayed();
	AssertJUnit.assertTrue(ld.Navbar().isDisplayed());
	Log.info("It is displayed");
		
	driver.quit();
	}


	
}
