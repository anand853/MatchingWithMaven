package com.user.reg;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class UserRegistration {

	static Map map = PropReader.readProp();

	static Logger logger = Logger.getLogger(UserRegistration.class);
	static WebDriver driver;
	static WebElement element;
	static String name = "";
	static String[] args;

	public static void clickOnMyFav() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

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
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();
		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);

		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByXpath(driver, Constants.USER_NAME).click();

	}

	public static void LogIn() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		openBrowser();
		acessToMatchSite();
		maximizePage();
		clickOnMemberSignLink();
		enterUserNamePass();

	}

	public static void enterUserNamePass() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);

		Util.waitTime(driver, 10);

		String emailIDvalue = (String) map.get("emailID");
		Util.findElementByID(driver, "email").clear();
		Util.findElementByID(driver, "email").sendKeys(emailIDvalue);
		Util.findElementByID(driver, "password").clear();
		Util.findElementByID(driver, "password").sendKeys(Constants.PASSWORD);
		Util.findElementByID(driver, "password").sendKeys(Keys.ENTER);

	}

	public static void logOut() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

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
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);
		Assert.assertEquals(ititle, Constants.PAGE_TITLE_5);

		Util.waitTime(driver, 10);
		Util.findElementByXpath(driver, Constants.FAV_ME_BTN).click();

	}

	public static void clickOnSaveButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);
		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);
		Assert.assertEquals(ititle, Constants.PAGE_TITLE_4);
		Util.waitTime(driver, 10);
		Util.findElementByXpath(driver, Constants.SEARCH_RESULTS).click();

	}

	public static void enterTextSearchBox() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);
		Assert.assertEquals(ititle, Constants.PAGE_TITLE_3);

		Util.waitTime(driver, 10);
		Util.findElementByID(driver, Constants.SEARCH_TXT).clear();
		Util.waitTime(driver, 10);
		Util.findElementByID(driver, Constants.SEARCH_TXT).sendKeys(Constants.SEARCH_KEY);
		Util.waitTime(driver, 10);
		Util.findElementByID(driver, Constants.SEARCH_TXT).sendKeys(Keys.ENTER);

	}

	public static void clickOnSearchBox() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);
		Assert.assertEquals(ititle, Constants.PAGE_TITLE_2);
		Util.waitTime(driver, 10);
		Util.findElementByID(driver, Constants.SEARCH_ID).click();

	}

	public static void clickOnAddAPicButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);
		// Assert.assertEquals(ititle, Constants.PAGE_TITLE);

		logger.info(Constants.LOG_STATEMENT + name);
		Util.waitTime(driver, 10);
		Util.findElementByXpath(driver, "/html/body/div[4]/div/div/div[1]/div[3]/a").click();

	}

	public static void clickOnAddProfilePicButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);
		// Assert.assertEquals(ititle, Constants.PAGE_TITLE);

		logger.info(Constants.LOG_STATEMENT + name);
		Util.findElementByXpath(driver, Constants.BUTTON_BASE_XPATH).click();

	}

	public static void clickOnFirstMatchesButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);
		// Assert.assertEquals(ititle, Constants.PAGE_TITLE);

		Util.findElementbyName(driver, Constants.NEXT).click();

	}

	public static void clickOnProfilePicButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnAboutYouButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);
		Util.waitTime(driver, 10);
		driver.findElement(By.xpath(Constants.SELFESSAY_TEXT)).sendKeys(Constants.TEXT_AREA_TXT);

		Util.waitTime(driver, 10);
		Util.findElementByXpath(driver, Constants.BUTTON_XPATH).click();

	}

	public static void clickOnHeadLinesButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);

		Util.findElementByXpath(driver, Constants.SELFHEADLINETEXT).sendKeys("hi ih");

		Util.findElementByXpath(driver, Constants.BUTTON_XPATH).click();

	}

	public static void clickOnSalaryButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnRelationShipKidsButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnEthinicButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);
		Util.waitTime(driver, 10);
		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnEducationLangButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnHairEyeColorButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnInterestButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnFavButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnBackgrounButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);
		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnSmokeButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOnEducationButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

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
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		retryingFindClick(By.xpath(Constants.BUTTON_XPATH));

	}

	public static void clickOngetStartedButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByXpath(driver, Constants.BTN_ONE).click();

	}

	public static void clickOnContinuewUserButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByXpath(driver, Constants.CONTINUE_USERNAME).click();

	}

	public static void enterUserName() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementbyNameAndSendKeys(driver, Constants.USER_NAME_TXT, Constants.USERNAME_VALUE);

	}

	public static void clickOnContinuewPassButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByXpath(driver, Constants.CONTINUE_BTN_PASS).click();

	}

	public static void enterPassword() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementbyNameAndSendKeys(driver, Constants.PASSWORD_TXT, Constants.PASSWORD);

	}

	public static void cilckOnContinuewButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByXpath(driver, Constants.CONTINUE_BTN).click();

	}

	public static void enterEmailId() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);
		Util.waitTime(driver, 10);
		String emaildid = (String) map.get("emailID");
		driver.findElement(By.xpath(Constants.EMAIL_ID)).sendKeys(emaildid);

	}

	public static void clickOnViewSinglesButton() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByXpath(driver, Constants.VIEW_SINGLE_BTN).click();

	}

	public static void enterZipCode() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementbyIdAndSendKeys(driver, Constants.POSTAL_CODE, Constants.PIN_CODE);

	}

	public static void clickOnRegistartionLink() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		Util.findElementByLinkText(driver, Constants.RESGISTARTION_LINK_TXT).click();
	}

	public static void clickOnMemberSignLink() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

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
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		Util.getURL(driver, Constants.MATCH_COM);
		String ititle = Util.getPageTitle(driver);
		logger.info(" The page title is " + ititle);

	}

	public static void openBrowser() {

		name = new Object() {
		}.getClass().getEnclosingMethod().getName();
		// Map map = PropReader.readProp();
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

	public static void ReLogIn() {
		name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info(Constants.LOG_STATEMENT + name);

		enterUserNamePass();

	}
}
