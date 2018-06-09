package Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest implements Const{

	static {
		System.setProperty(chromeDriverKey,chromeDriverValue);
		System.setProperty(ffDriverKey,ffDriverValue);
	}
	
	protected WebDriver driver = null;
			
	@BeforeSuite
	public void bs()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(implicitWaitTime,TimeUnit.SECONDS);
		Reporter.log("Chrome broswer launched",true);
	}
	
	@AfterSuite
	public void as()
	{
		Reporter.log("Chrome broswer Closed",true);
		driver.close();
		
	}
	
	@BeforeClass
	public void bc()
	{
		//driver.get("http://giganew-pc/login.do");
		driver.get(Generic.getPropertyValues(propertyFilePath+"\\app_config", "app_url"));
		Reporter.log("url loaded to the broswer =  http://giganew-pc/login.do",true);
	}
	
}
