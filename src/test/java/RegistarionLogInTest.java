
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.user.reg.Util;
import com.user.reg.NoElementException;
import com.user.reg.UserRegistration;

public class RegistarionLogInTest {
	static WebDriver driver;
	static WebElement element;

	UserRegistration user = new UserRegistration();

	@Test(priority = 1)
	public void LogIn() throws NoElementException {
		UserRegistration.LogIn();
	}

	@Test(priority = 2)
	public void clickOnUserName() {
		UserRegistration.clickOnUserName();
	}

	@Test(priority = 3)
	public void clickOnMyFav() {
		UserRegistration.clickOnMyFav();
	}

	@AfterMethod
	public void tearDown(ITestResult results) {
		if (ITestResult.FAILURE == results.getStatus()) {
			UserRegistration.takeScreenShot();

		}
	}
}
