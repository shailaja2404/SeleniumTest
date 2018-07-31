package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	// where we initialize the browser and load and read properties file
	public static WebDriver driver = null;
	// file path for locator property
	String LOCATOR_PRP = System.getProperty("user.dir") + File.separator + "Data" + File.separator
			+ "locator.properties";
	// loaded property file for locator
	Properties LOCATE = initProp(LOCATOR_PRP);

	String env_Filepath = System.getProperty("user.dir") + File.separator + "Data" + File.separator + "env.properties";
	// loaded property file for locator
	Properties env = initProp(env_Filepath);

	String url = env.getProperty("url");
	String browser = env.getProperty("browser");

	String getBrowser() {
		if (browser == null) {
			browser = "chrome";
		}
		return browser;
	}

	// Method to initiate webdriver or start selenium webdriver
	public WebDriver initBrowser(String browser) {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "Drivers1" + File.separator + "chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + File.separator + "Drivers1" + File.separator + "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	// Method to open url
	public void openUrl(String url) {
		driver.get(url);
	}

	SeleniumMethods method;

	@BeforeMethod
	public void setup() {
		driver = initBrowser(getBrowser());// just to avoid null pointer exception
		openUrl(url);
		method = new SeleniumMethods();

	}

	@AfterMethod
	public void cleanup() {
		// driver.close();
		driver.quit();

	}
	/*
	 * @Test public void firstTest() { Assert.assertEquals(driver.getTitle(),
	 * "The Internet"); }
	 */

	// method for reading property file
	Properties initProp(String filepath) {
		Properties prop = new Properties();
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(filepath);
			prop.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}

}
