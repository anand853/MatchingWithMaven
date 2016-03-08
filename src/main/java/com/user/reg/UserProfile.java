package com.user.reg;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sun.jna.platform.win32.Netapi32Util.User;

public class UserProfile {
	static String[] result = new String[7], actual = new String[7];

	static Map map = PropReader.readProp();

	static Logger logger = Logger.getLogger(UserRegistration.class);
	static WebDriver driver;
	static WebElement element;
	static String name = "";
	static String[] args;

	public static void LogIn() {
		name = UserRegistration.getName();
		logger.info(Constants.LOG_STATEMENT + name);

		UserRegistration.openBrowser();
		UserRegistration.acessToMatchSite();
		UserRegistration.maximizePage();
		UserRegistration.clickOnMemberSignLink();
		UserRegistration.compareUnkownImage();

	}

}
