package testScripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic.BaseTest;
import Generic.Generic;
import PO.loginPO;
import PO.otasklist;

public class Testcase1 extends BaseTest{

	@Test
	public void tc_01()
	{
		loginPO login_po = new loginPO(driver);
		login_po.login();
		Reporter.log("Login to acti time is done successfully",true);
	
		WebDriverWait wait = new WebDriverWait(driver, explicitWaitTime);
		wait.until(ExpectedConditions.urlContains("http://giganew-pc/tasks/otasklist.do"));
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://giganew-pc/tasks/otasklist.do");
		Reporter.log("Landed to home page successfully",true);
		
		login_po.allLinks();
		Reporter.log("All links present in the home page printed successfully",true);
		
		otasklist taskList_po = new otasklist(driver);
		taskList_po.logout();
		Reporter.log("Logout link clicked in the home page successfully",true);
		Generic.takeSS(driver,ssPath,"tc_01");
	}
	
	@Test(enabled=false)
	public void tc_02()
	{
		/*System.out.println("before");
		Assert.assertEquals("a", "b");
		System.out.println("after");*/
		
		System.out.println("before");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("a", "b");
		System.out.println("after");
		sa.assertAll();
		
	}
	
}
