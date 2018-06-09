package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class otasklist {

	public otasklist(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Logout']")
	private WebElement logoutBtn;
	
	
	public void logout()
	{
		logoutBtn.click();
	}
}
