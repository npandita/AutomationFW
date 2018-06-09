package Generic;

public interface Const {

	public static final String fwPath = System.getProperty("user.dir");
	public static final String chromeDriverKey = "webdriver.chrome.driver";
	public static final String chromeDriverValue = 
			fwPath+"\\driverExecutables\\chromedriver.exe";
	
	public static final String ffDriverKey = "webdriver.gecko.driver";
	public static final String ffDriverValue = 
			fwPath+"\\driverExecutables\\geckodriver.exe";
	
	public static final int implicitWaitTime = 5000;
	public static final int explicitWaitTime = 40;
	
	public static final String propertyFilePath = fwPath+"\\properties";
	
	public static final String ssPath = fwPath+"\\screenShots";
	
	public static final String testDataPath = fwPath+"\\testData.xlsx";
}
