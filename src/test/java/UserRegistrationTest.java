
import org.testng.annotations.Test;
import com.user.reg.UserRegistration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@SuppressWarnings("unused")

public class UserRegistrationTest {
	static WebDriver driver;
	static WebElement element;

	UserRegistration user = new UserRegistration();

	@Test(priority = 1)
	public void accessToSite() {
		UserRegistration.openBrowser();
		UserRegistration.acessToMatchSite();
		UserRegistration.maximizePage();
	}

	@Test(priority = 2)
	public void registration() {
		UserRegistration.clickOnMemberSignLink();
		UserRegistration.clickOnRegistartionLink();
		UserRegistration.enterZipCode();
		UserRegistration.clickOnViewSinglesButton();
		UserRegistration.enterEmailId();
		UserRegistration.cilckOnContinuewButton();
		UserRegistration.enterPassword();
		UserRegistration.clickOnContinuewPassButton();
		UserRegistration.enterUserName();
		UserRegistration.clickOnContinuewUserButton();
		UserRegistration.clickOngetStartedButton();
		UserRegistration.clickOnHairColorButton();
		UserRegistration.clickOnRelationshipButton();
		UserRegistration.clickOnEducationButton();
		UserRegistration.clickOnSmokeButton();
		UserRegistration.clickOnBackgrounButton();
		UserRegistration.clickOnFavButton();
		UserRegistration.clickOnInterestButton();
		UserRegistration.clickOnHairEyeColorButton();
		UserRegistration.clickOnEducationLangButton();
		UserRegistration.clickOnEthinicButton();
		UserRegistration.clickOnRelationShipKidsButton();
		UserRegistration.clickOnSalaryButton();
		UserRegistration.clickOnHeadLinesButton();
		UserRegistration.clickOnAboutYouButton();
		UserRegistration.clickOnProfilePicButton();
		UserRegistration.clickOnFirstMatchesButton();
		UserRegistration.clickOnAddProfilePicButton();
		UserRegistration.clickOnAddAPicButton();
		UserRegistration.clickOnSearchBox();
		UserRegistration.enterTextSearchBox();
		UserRegistration.clickOnSaveButton();
		UserRegistration.clickOnFavMe();
		UserRegistration.logOut();
	}

}
