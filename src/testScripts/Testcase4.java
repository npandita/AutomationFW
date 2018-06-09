package testScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Generic.BaseTest;
import Generic.ExcelLib;
import PO.loginPO;

public class Testcase4 extends BaseTest{

	
	
	@Test
	public void tc_03() throws InterruptedException
	{
		int rowCount = ExcelLib.getRowCount(testDataPath, "tc_03");
		for(int i=1;i<=rowCount;i++)
		{
			String userName = ExcelLib.getExcelCellValue(testDataPath, "tc_03",i, 1);
			String pwd = ExcelLib.getExcelCellValue(testDataPath, "tc_03",i, 2);
			
			loginPO login_po = new loginPO(driver);
			login_po.invalidLogin(userName,pwd);
			Reporter.log("Entered userName and password "+userName+" "+pwd);
			Thread.sleep(5000);
			Assert.assertEquals(login_po.geterrormsg(), 
					"Username or Password is invalid. Please try again.");
		
			Reporter.log("Error msg verified successfully");
			
			ExcelLib.writeDataToExcel(testDataPath, "tc_03", i, 3, "pass");
		}
	}
	
	
}
