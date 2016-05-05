package com.user.reg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class UserRegistration {

	static String[] result = new String[7], actual = new String[7];

	static Map map = PropReader.readProp();

	static Logger logger = Logger.getLogger(UserRegistration.class);
	static WebDriver driver;
	static WebElement element;
	static String name = "";
	static String[] args;

	public static void clickOnMyFav() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		Util.waitTime(driver, 10);
		Util.findElementByXpath(driver, Constants.USER_FAV_LINK).click();

		Util.waitTime(driver, 10);
		Util.findElementByXpath(driver, Constants.USER_FAV_LINK_2).click();

		String userName = Util.findElementByXpath(driver, Constants.USER_DETAILS).getText();
		logger.info("userName -->" + userName);

		String userName_ = (String) map.get("userName");
		Assert.assertEquals(userName, userName_);

		logOut();

	}

	public static void clickOnUserName() {
		name = getName();
		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);

		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByXpath(driver, Constants.USER_NAME).click();

	}

	public static void LogIn() throws NoElementException {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		openBrowser();
		acessToMatchSite();
		maximizePage();
		clickOnMemberSignLink();
		enterUserNamePass();
		comparePrimaryMenuLists();
		compareFooterMatchOne();
		compareFooterMatchTwo();
		compareFooterMatchThree();
		compareFooterMatchFour();
		compareFooterMatchFive();

	}

	public static void compareUnkownImage() {
		System.out.println("----compareUnkownImage---------");

		System.out.println(driver.getCurrentUrl());
		String xpath = "//*[@id='app']/div/div[1]/header/nav/ul[2]/li[1]/a/img";

		File scrFile = driver.findElement(By.xpath(xpath)).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void compareFooterMatchFive() {

		String xpath = "//*[@id='pageBody']/div[5]/div[1]/div[1]/ul[5]";

		String[] actual1 = new String[4];

		actual1[0] = new String("Advertise on Match.com");
		actual1[1] = new String("Become an Affiliate");
		actual1[2] = new String("Promotions & Sponsorships");
		actual1[3] = new String("Business Development");

		String[] results1 = Util.captureItemsInMenu(xpath, driver);
		System.out.println("actual arrays is " + Arrays.toString(actual1));
		System.out.println("results arrays is " + Arrays.toString(results1));

		System.out.println("Check both the links are same or not? " + Util.compareItemsInMenu(actual1, results1));

	}

	private static void compareFooterMatchFour() {

		String xpath = "//*[@id='pageBody']/div[5]/div[1]/div[1]/ul[4]";

		String[] actual1 = new String[4];

		actual1[0] = new String("Match.com Guarantee");
		actual1[1] = new String("Mobile");
		actual1[2] = new String("Gift Subscriptions");
		actual1[3] = new String("ProfilePro");

		String[] results1 = Util.captureItemsInMenu(xpath, driver);
		System.out.println("actual arrays is " + Arrays.toString(actual1));
		System.out.println("results arrays is " + Arrays.toString(results1));

		System.out.println("Check both the links are same or not? " + Util.compareItemsInMenu(actual1, results1));

	}

	private static void compareFooterMatchThree() {

		String xpath = "//*[@id='pageBody']/div[5]/div[1]/div[1]/ul[3]";

		String[] actual1 = new String[5];

		actual1[0] = new String("Help/FAQs");
		actual1[1] = new String("Profile Assistance");
		actual1[2] = new String("Site Map");
		actual1[3] = new String("Match International");
		actual1[4] = new String("Media Room");

		String[] results1 = Util.captureItemsInMenu(xpath, driver);
		System.out.println("actual arrays is " + Arrays.toString(actual1));
		System.out.println("results arrays is " + Arrays.toString(results1));

		System.out.println("Check both the links are same or not? " + Util.compareItemsInMenu(actual1, results1));

	}

	private static void compareFooterMatchTwo() {

		String xpath = "//*[@id='pageBody']/div[5]/div[1]/div[1]/ul[2]";

		String[] actual1 = new String[6];

		actual1[0] = new String("Online Dating Safety Tips");
		actual1[1] = new String("Dating Articles and Advice");
		actual1[2] = new String("How Online Dating Works");
		actual1[3] = new String("Success Stories");
		actual1[4] = new String("Relationship Tips");
		actual1[5] = new String("Dating Tips");

		String[] results1 = Util.captureItemsInMenu(xpath, driver);
		System.out.println("actual arrays is " + Arrays.toString(actual1));
		System.out.println("results arrays is " + Arrays.toString(results1));

		System.out.println("Check both the links are same or not? " + Util.compareItemsInMenu(actual1, results1));

	}

	private static void compareFooterMatchOne() {

		String xpath1 = "//*[@id='pageBody']/div[5]/div[1]/div[1]/ul[1]";

		String[] actual1 = new String[5];

		actual1[0] = new String("About Match.com");
		actual1[1] = new String("Terms of Use**");
		actual1[2] = new String("Your Privacy");
		actual1[3] = new String("Ad Choices");
		actual1[4] = new String("Careers");

		String[] results1 = Util.captureItemsInMenu(xpath1, driver);
		System.out.println("actual arrays is " + Arrays.toString(actual1));
		System.out.println("results arrays is " + Arrays.toString(results1));

		System.out.println("Check both the links are same or not? " + Util.compareItemsInMenu(actual1, results1));

	}

	private static void comparePrimaryMenuLists() {
		// String xpath = "//*[@id='app']/div/div[1]/header";
		String xpath = "//*[@id='header-nav']/div/ul";

		actual[0] = new String("Subscribe");
		actual[1] = new String("Search");
		actual[2] = new String("Matches");
		actual[3] = new String("Connections");
		actual[4] = new String("Messages");
		actual[5] = new String("Events");
		actual[6] = new String("Sign In");

		String[] results = Util.captureItemsInMenu(xpath, driver);
		System.out.println("actual arrays is " + Arrays.toString(actual));
		System.out.println("results arrays is " + Arrays.toString(results));

		System.out.println("Check both the links are same or not? " + Util.compareItemsInMenu(actual, results));

	}

	private static String[] captureItemsInMenu(String xpath) {
		List<WebElement> allElements = driver.findElements(By.xpath(xpath));
		int i = 0;
		for (WebElement element : allElements) {

			String s = element.getText();

			result = s.split("\\n");
			for (int x = 0; x < result.length; x++)
				System.out.println(result[x]);
		}

		return result;
	}

	public static void enterUserNamePass() throws NoElementException {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);

		Util.waitTime(driver, 10);

		String emailIDvalue = (String) map.get("emailID");
		Util.findElement(driver, "id", "email").clear();
		Util.findElement(driver, "id", "email").sendKeys(emailIDvalue);
		Util.findElement(driver, "id", "password").clear();
		Util.findElement(driver, "id", "password").sendKeys(Constants.PASSWORD);
		Util.findElement(driver, "id", "password").sendKeys(Keys.ENTER);

	}

	public static void logOut() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);
		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);

		Util.waitTime(driver, 10);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(Constants.USER_HOVER));
		action.moveToElement(element).moveToElement(driver.findElement(By.xpath(Constants.USER_LOGOUT))).click().build()
				.perform();

	}

	public static void clickOnFavMe() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);
		Assert.assertEquals(ititle, Constants.PAGE_TITLE_5);

		Util.waitTime(driver, 10);
		Util.findElementByXpath(driver, Constants.FAV_ME_BTN).click();

	}

	public static void clickOnSaveButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);
		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);
		Assert.assertEquals(ititle, Constants.PAGE_TITLE_4);
		Util.waitTime(driver, 10);
		Util.findElementByXpath(driver, Constants.SEARCH_RESULTS).click();

	}

	public static void enterTextSearchBox() throws NoElementException {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);
		Assert.assertEquals(ititle, Constants.PAGE_TITLE_3);

		Util.waitTime(driver, 10);
		Util.findElement(driver, "id", Constants.SEARCH_TXT).clear();
		Util.waitTime(driver, 10);
		Util.findElement(driver, "id", Constants.SEARCH_TXT).sendKeys(Constants.SEARCH_KEY);
		Util.waitTime(driver, 10);
		Util.findElement(driver, "id", Constants.SEARCH_TXT).sendKeys(Keys.ENTER);

	}

	public static void clickOnSearchBox() throws NoElementException {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);
		Assert.assertEquals(ititle, Constants.PAGE_TITLE_2);
		Util.waitTime(driver, 10);
		Util.findElement(driver, "id", Constants.SEARCH_ID).click();

	}

	public static void clickOnAddAPicButton() {
		name = getName();
		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);
		// Assert.assertEquals(ititle, Constants.PAGE_TITLE);

		logger.info(Constants.LOG_STATEMENT + name);
		Util.waitTime(driver, 10);
		Util.findElementByXpath(driver, "/html/body/div[4]/div/div/div[1]/div[3]/a").click();

	}

	public static void clickOnAddProfilePicButton() {
		name = getName();
		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);
		// Assert.assertEquals(ititle, Constants.PAGE_TITLE);

		logger.info(Constants.LOG_STATEMENT + name);
		Util.findElementByXpath(driver, Constants.BUTTON_BASE_XPATH).click();

	}

	public static void clickOnFirstMatchesButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);
		// Assert.assertEquals(ititle, Constants.PAGE_TITLE);

		Util.findElementbyName(driver, Constants.NEXT).click();

	}

	public static void clickOnProfilePicButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnAboutYouButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);
		Util.waitTime(driver, 10);
		driver.findElement(By.xpath(Constants.SELFESSAY_TEXT)).sendKeys(Constants.TEXT_AREA_TXT);

		Util.waitTime(driver, 10);
		Util.findElementByXpath(driver, Constants.BUTTON_XPATH).click();

	}

	public static void clickOnHeadLinesButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);

		Util.findElementByXpath(driver, Constants.SELFHEADLINETEXT).sendKeys("hi ih");

		Util.findElementByXpath(driver, Constants.BUTTON_XPATH).click();

	}

	public static void clickOnSalaryButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnRelationShipKidsButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnEthinicButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);
		Util.waitTime(driver, 10);
		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnEducationLangButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnHairEyeColorButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnInterestButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnFavButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnBackgrounButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);
		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnSmokeButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnEducationButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnRelationshipButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnHairColorButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOngetStartedButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByXpath(driver, Constants.BTN_ONE).click();

	}

	public static void clickOnContinuewUserButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByXpath(driver, Constants.CONTINUE_USERNAME).click();

	}

	public static void enterUserName() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByNameAndSendKeys(driver, Constants.USER_NAME_TXT, Constants.USERNAME_VALUE);

	}

	public static void clickOnContinuewPassButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByXpath(driver, Constants.CONTINUE_BTN_PASS).click();

	}

	public static void enterPassword() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByNameAndSendKeys(driver, Constants.PASSWORD_TXT, Constants.PASSWORD);

	}

	public static void cilckOnContinuewButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByXpath(driver, Constants.CONTINUE_BTN).click();

	}

	public static void enterEmailId() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);
		Util.waitTime(driver, 10);
		String emaildid = (String) map.get("emailID");
		driver.findElement(By.xpath(Constants.EMAIL_ID)).sendKeys(emaildid);

	}

	public static void clickOnViewSinglesButton() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByXpath(driver, Constants.VIEW_SINGLE_BTN).click();

	}

	public static void enterZipCode() {
		name = getName();
		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementbyIDAndSendKeys(driver, Constants.POSTAL_CODE, Constants.PIN_CODE);

	}

	public static void clickOnRegistartionLink() {
		name = getName();

		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByXpath(driver, Constants.RESGISTARTION_LINK_XPATH).click();
	}

	public static void clickOnMemberSignLink() {
		name = getName();

		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByLinkText(driver, Constants.SIGNIN_TXT).click();

	}

	public static void maximizePage() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);
		driver.manage().window().maximize();

	}

	public static void acessToMatchSite() {
		name = getName();

		logger.info(Constants.LOG_STATEMENT + name);

		Util.getURL(driver, Constants.MATCH_COM);
		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);

	}

	public static void openBrowser() {

		name = getName();

		String type = (String) map.get("browserType");
		driver = Util.getBrowser(type);

	}

	private static boolean retryingFindClick(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (Exception e) {
			}
			attempts++;
		}
		return result;
	}

	public static void ReLogIn() throws NoElementException {
		name = getName();

		logger.info(Constants.LOG_STATEMENT + name);

		enterUserNamePass();

	}

	public static String getName() {
		return name = new Object() {
		}.getClass().getEnclosingMethod().getName();

	}

	public static void captureScreenshot() throws IOException {
		WebElement Image = driver.findElement(
				By.xpath("//*[@id='ctl00_matchHeader_ctl00_PrimaryNavigationRepeater1_ctl08_HyperLink3']"));
		captureElementScreenshot(Image);
	}

	public static void takeScreenShot() {
		Util.takeScreenShot(driver);

	}

	public static void captureElementScreenshot(WebElement element) throws IOException {
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		int ImageWidth = element.getSize().getWidth();
		int ImageHeight = element.getSize().getHeight();
		Point point = element.getLocation();
		int xcord = point.getX();
		int ycord = point.getY();
		BufferedImage img = ImageIO.read(screen);
		BufferedImage dest = img.getSubimage(xcord, ycord, ImageWidth, ImageHeight);

		ImageIO.write(dest, "png", screen);
		FileUtils.copyFile(screen, new File("D:\\screenshot.png"));
	}

}