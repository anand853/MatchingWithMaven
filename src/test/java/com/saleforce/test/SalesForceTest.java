package com.saleforce.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.user.reg.NoElementException;
import com.user.reg.Util;

public class SalesForceTest {
	WebDriver driver = Util.getBrowser("Chrome");

	@Test
	public void initiateDriver() throws NoElementException {

		Util.getURL(driver, "https://www.salesforce.com");
		System.out.println(Util.getPageTitle(driver));

	}

	@Test
	public void checkElementsPresent() throws NoElementException {
		System.out.println(Util.isDisplayed(driver, LocatorType.ID, "searchtext"));
		System.out.println(Util.isDisplayed(driver, LocatorType.ID, "button-login"));
		System.out.println(Util.isDisplayed(driver, LocatorType.ID, "free-trial-trigger"));

	}

	@Test
	public void checkElementsEnabled() throws NoElementException {
		System.out.println(Util.isEnabled(driver, LocatorType.ID, "searchtext"));
		System.out.println(Util.isEnabled(driver, LocatorType.ID, "button-login"));
		System.out.println(Util.isEnabled(driver, LocatorType.ID, "free-trial-trigger"));

	}
}
