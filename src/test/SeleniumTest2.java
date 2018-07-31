package test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumTest2 extends BaseClass {
	@Test
	public void checkBoxes() throws InterruptedException {

		// driver.findElement(By.xpath("//a[@href='/checkboxes']")).click();
		// method.clickElement("//a[@href='/checkboxes']");
		List<WebElement> list = method.geWebelemetList(LOCATE.getProperty("checkbox"));
		// click on first box for
		for (WebElement ele : list) {
			ele.click();
		}

	}

	@Test
	public void loginSnapdeal() throws InterruptedException {
		// goto snapdeal
		driver.get("https://www.snapdeal.com/");
		// move mouse to sign in
		Actions action = new Actions(driver);
		WebElement a = method.getWebElement(LOCATE.getProperty("accountUserName"));
		action.moveToElement(a).build().perform();

		String s = "test";
		//
		// click login
		method.clickElement(LOCATE.getProperty("clickLogin"));

		// switch to frame
		driver.switchTo().frame("loginIframe");

		// click using gmail
		method.clickElement(LOCATE.getProperty("clickGmail"));

		// switch to windows
		// String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> win = allWindows.iterator();

		String parent = win.next();
		String child = win.next();

		driver.switchTo().window(child);
		driver.manage().window().maximize();
		method.typeText(LOCATE.getProperty("enterUserName"), "Testshailja87@gmail.com");
		driver.findElement(By.cssSelector(LOCATE.getProperty("clickNext"))).click();
		method.typeText(LOCATE.getProperty("clickPassword"), "Test123$");
		method.clickElement(LOCATE.getProperty("passwordNext"));
		driver.switchTo().window(parent);
		Thread.sleep(8000);

	}

}
