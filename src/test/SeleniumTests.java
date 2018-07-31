package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SeleniumTests extends BaseClass {

	@Test
	public void handleScreenCaptcha() {
		driver.get("https://timesofindia.indiatimes.com/home/polls");
		// driver.findElement(By.xpath("//*[@type='radio'][2]")).click();
		method.clickElement(LOCATE.getProperty("radioButton"));
		String getCapcha = method.getText(LOCATE.getProperty("getcapcha"));
		method.clickElement(LOCATE.getProperty("clickVote"));
		driver.findElement(By.cssSelector("div.homesprite.vot")).click();
		// verify result on another window
	}

	@Test
	public void handleSelect() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/newtours/register.php");

		WebElement con = driver.findElement(By.name("country"));
		// Select select = new Select( con);
		// select.selectByIndex(5);
		// select.selectByValue("ALBANIA");
		// select.selectByVisibleText("AUSTRALIA");
		Thread.sleep(3000);
		method.selectVisibleText(con, "AUSTRALIA");
		Thread.sleep(3000);

	}

	@Test
	public void printHyperlink() {
		driver.get("https://www.cricbuzz.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));		
		
		//List<WebElement> links= driver.findElements(method.locator(LOCATE.getProperty("hyperLink")));
		
		method.reusablePrintHyperLink(links);

	}

	@Test
	public void clickButton() throws InterruptedException {

		method.clickElement(LOCATE.getProperty("checkbox"));
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
	}

}
