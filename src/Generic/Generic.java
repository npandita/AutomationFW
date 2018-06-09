package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Generic {

	/* To read the values from properties files */
	public static String getPropertyValues(String path, String key) {
		String propValue = null;
		try {
			FileInputStream fis = new FileInputStream(path + ".properties");
			Properties prop = new Properties();
			prop.load(fis);
			propValue = prop.getProperty(key);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propValue;
	}

	/* To set the values from properties files */
	public static void setPropertyValues(String path, String key, String value) {
		try {
			FileInputStream fis = new FileInputStream(path + ".properties");
			Properties prop = new Properties();
			prop.load(fis);
			prop.setProperty(key, value);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Executing the .exe files
	public static void runExefiles(String path) {
		try {

			Runtime.getRuntime().exec(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Select drop downs
	public static void selectDropDowns_index(WebElement ele, int index)
	{
		Select s1 = new Select(ele);
		s1.selectByIndex(index);	
	}
	
	public static void selectDropDowns_visibleTxt(WebElement ele, String  text)
	{
		Select s1 = new Select(ele);
		s1.selectByVisibleText(text);	
	}
	
	public static void selectDropDowns_value(WebElement ele, String  value)
	{
		Select s1 = new Select(ele);
		s1.selectByValue(value);	
	}

	
	/*Taking Screen shot*/
	public static void takeSS(WebDriver driver, String path, String testcaseName)
	{
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			String pattern = "MM-dd-yyyy_HH_mm_ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			
			FileUtils.copyFile(screenshotFile, 
					new File(path+"\\"+testcaseName+"_"+date+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Actions class*/
	public static void actions_conextClick(WebDriver driver, WebElement ele)
	{
		Actions act = new Actions(driver);
		act.contextClick(ele).build().perform();
	}
	
	/*Alert window*/
	public static void alert_accept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	
	/*Alert window*/
	public static void alert_dismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/*Handling Windows*/
	public static void switchToChildWindow(WebDriver driver)
	{
		String parentwindowID = driver.getWindowHandle();
		System.out.println("parent window"+parentwindowID);
		
		Set<String> windowIDS = driver.getWindowHandles();
		Iterator<String> it = windowIDS.iterator();
		while(it.hasNext())
		{
			String childID = it.next();
			if(childID.equals(parentwindowID))
			{
				
			}
			else
			{
				driver.switchTo().window(childID);
				System.out.println(driver.getCurrentUrl());
			
			}
		}
	}
	
}
