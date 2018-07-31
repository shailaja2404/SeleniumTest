package test;

import org.openqa.selenium.By;

public class Locators {
	public By by;
    

	// Todays task to write , generic click and sendkeys method
	public By elements(String locator) {

		String loc = locator.substring(0, 2);

		// String locator should be like this XP_ , CS_, ID_

		if (loc.equalsIgnoreCase("ID")) {
			by = By.id(locator.substring(3, locator.length()));
		} else if (loc.equalsIgnoreCase("XP")) {
			by = By.xpath(locator.substring(3, locator.length()));
		}else if(loc.equalsIgnoreCase("PLT")) {
			by= By.partialLinkText(locator.substring(3, locator.length()));
		}else if(loc.equalsIgnoreCase("LT")){
			by= By.linkText(locator.substring(3, locator.length()));
		
		} else if (loc.equalsIgnoreCase("CS")) {
			by = By.cssSelector(locator.substring(3, locator.length()));
		} else if (loc.equalsIgnoreCase("NM")) {
			by = By.name(locator.substring(3, locator.length()));
		} else if (loc.equalsIgnoreCase("LT")) {

			by = By.linkText(locator.substring(3, locator.length()));

		} else if (loc.equalsIgnoreCase("TN")) {
			by = By.tagName(locator.substring(3, locator.length()));

		} else {
			System.out.println("Invalid locator");
		}
		return (by);
	}

}
