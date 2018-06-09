package PO;
import java.util.List;

import org.apache.http.client.params.AllClientPNames;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class loginPO {

	public loginPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);  //initialization
	}
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userNameTxtBx; //Declaration
	
	@FindBy(xpath="//input[@name='pwd']")
	private WebElement pwdTxtBx;
	
	@FindBy(xpath="//input[contains(@value,'Login now')]")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a")
	private List<WebElement> allLinks;
	
	@FindBy(xpath="(//span[@class='errormsg'])[1]")
	private WebElement login_errorMsg;
	
	public void login()
	{
		if(userNameTxtBx.isDisplayed())
		{
			userNameTxtBx.clear();
			userNameTxtBx.sendKeys("admin");
		}
		if(pwdTxtBx.isDisplayed())
		{
			pwdTxtBx.clear();
			pwdTxtBx.sendKeys("manager");
		}
		if(loginBtn.isEnabled())
		{
			loginBtn.click();
		}
	
	}
	
	
	public void invalidLogin(String userName, String password)
	{
		if(userNameTxtBx.isDisplayed())
		{
			userNameTxtBx.clear();
			userNameTxtBx.sendKeys(userName);
		}
		if(pwdTxtBx.isDisplayed())
		{
			pwdTxtBx.clear();
			pwdTxtBx.sendKeys(password);
		}
		if(loginBtn.isEnabled())
		{
			loginBtn.click();
		}
	
	}
	
	public void allLinks()
	{
		for(int i=0;i<allLinks.size();i++)
		{
			//System.out.println(allLinks.get(i).getText());
			Reporter.log("Links "+ allLinks.get(i).getText(),true);
		}
	}

	public String geterrormsg()
	{
		String errormsg = login_errorMsg.getText();
		return errormsg;
	}
}
