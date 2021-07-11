package End;

import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.Landingpage;
import pageObject.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;

@BeforeTest
public void intialize() throws IOException {
	driver= intializerDriver();
	driver.get(prop.getProperty("url"));
}
	
private static Logger Log = LogManager.getLogger(HomePage.class.getName());
	
	@Test (dataProvider="getdata")
	public void  basenavigation (String username,String password, String text) throws IOException {
		
		//Create object to that class and invoke methods of it 
		driver.get(prop.getProperty("url"));
		Log.info("URL is opened");
		
		Landingpage ld= new Landingpage(driver);
		LoginPage lp=ld.getlogin();
		
	Log.info("Login page");
		
		
		lp.Email().sendKeys(username);
		lp.Password().sendKeys(password);
		
		ForgotPassword fw=lp.ForgetPassword();
		fw.Email().sendKeys("Helooo");
		fw.SendInstructions().click();
	}
	@DataProvider
	public Object[][] getdata() {
		Object[][] data= new Object[2][3];
		data[0][0]="nonrestrict@user.com";
		data[0][1]="w23432234";
		data[0][2]="text";
	 
		data[1][0]="restrict@user.com";
	    data[1][1]="212313123";
	    data[1][2]="text";
				
		return data;
		
	}
	@AfterTest
	public void teardown() {
		
		driver.close();
	}
}

