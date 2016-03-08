
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.user.reg.UserProfile;
import com.user.reg.UserRegistration;

public class CompareImagesTest {

	static WebDriver driver;
	static WebElement element;

	UserProfile user = new UserProfile();

	@Test(priority = 1)
	public void LogIn() throws IOException {
		UserRegistration.openBrowser();
		UserRegistration.acessToMatchSite();
		UserRegistration.maximizePage();
		UserRegistration.clickOnMemberSignLink();
		UserRegistration.captureScreenshot();

	}

}
