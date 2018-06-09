package testScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Generic.BaseTest;
import PO.loginPO;

public class Testcase2 extends BaseTest{

	@DataProvider
	public String[][] getText()
	{
		String data[][]= new String[3][2];
		data[0][0]="sdhfgsh";data[0][1]="asdfdsf";
		data[1][0]="nfgnf";data[1][1]="ghngn";
		data[2][0]="dfgfg";data[2][1]="drgr";
		return data;
	}
	
	@Test(dataProvider="getText")
	public void tc_02(String userName, String pwd) throws InterruptedException
	{
		
		loginPO login_po = new loginPO(driver);
		login_po.invalidLogin(userName,pwd);
		Reporter.log("Entered userName and password "+userName+" "+pwd);
		Thread.sleep(5000);
		Assert.assertEquals(login_po.geterrormsg(), 
				"Username or Password is invalid. Please try again.");
	
		Reporter.log("Error msg verified successfully");
	}
	
	
}
