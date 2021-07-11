package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class base {
public WebDriver driver;//Create driver outside 
public Properties prop;
	public WebDriver intializerDriver() throws IOException {
		
		
		prop=new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.propertiess");
		prop.load(fis);
		//with this below code your Browser is not dependent on your data.properties file any more 
		String browserName= System.getProperty("browser");
		//String browserName =prop.getProperty("browser");
		//mvn test -Dbrowser=chromeheadless
		if(browserName.contains("chrome")) {
			//execute in chrome
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/resources/chromedriver-2");
			if(browserName.contains("headless")) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("headless");
			driver=new ChromeDriver(options);
			}
			else {
			driver=new ChromeDriver();
			}
			}
		
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/src/main/java/resources/geckodriver");
		 driver=new FirefoxDriver(); //driver created outside
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver; //Send this driver back 
		
		//This code will be used all your test cases 
		
	}
	public String getScreenshots(String testMethodName, WebDriver driver) throws IOException {
		String screenName= testMethodName +".png";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
		FileHandler.copy(src, new File(System.getProperty("user.dir")+"/target/Screenshots/"+screenName+""));
		}
		
		
		catch(IOException e)
		{
		System.out.println(e.getMessage());
		}
		return screenName;
		
	}

	
}
