package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumMethods {
	WebDriver driver = BaseClass.driver; // We are intiating WebDriver driver directly thru the driver we intiated in
											// Testcase1 class, for this we made the driver variable public static

	public int fetchString(String s) {
		int a = Integer.parseInt(s.substring(0, 1));
		int b = Integer.parseInt(s.substring(4, 5));
		return a + b;

	}

	public int subString(String w) {
		int x = Integer.parseInt(w.substring(0, 1));
		int y = Integer.parseInt(w.substring(4, 8));
		return x + y;

	}

	public WebElement getWebElement(String ele) {
		return driver.findElement(locator.elements(ele));
	}

	public void selectVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public void reusablePrintHyperLink(List<WebElement> links) {
		int linkSize = links.size();
		System.out.println("Number of links present:" + linkSize);
		// List name links is of type WebElement so in for we are writing WebElement
		// HyperLink
		for (WebElement hyperLink : links) {
			String link = hyperLink.getText();
			// for String length method and for integer size method
			if (link.length() > 0 && !link.equals(" ")) {
				System.out.println(link);
			}
		}
	}
	

	// MOVE ALL LOCATORS TO PROPERTY FILE
	// change hard coded path of ChromeDriver and FireFox driver like properties file
	// CREATE SEPARATE METHOD FOR CLICK AND SENDKEYS
	// BREAK CODE INTO SMALL METHODSE
	Locators locator = new Locators();

	public void clickElement(String locatore) {
		// clicks on any element of the webpage
		// need to provide xpath of the element
		try {
			driver.findElement(locator.elements(locatore)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void typeText(String locatore, String fText) {
		// types the text into the editable text field
		// need to provide the xpath of the element
		try {
			driver.findElement(locator.elements(locatore)).sendKeys(fText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getText(String locatore) {
		return driver.findElement(locator.elements(locatore)).getText();
	}

	public List<WebElement> geWebelemetList(String string) {
		return driver.findElements(locator.elements(string));
	}

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
