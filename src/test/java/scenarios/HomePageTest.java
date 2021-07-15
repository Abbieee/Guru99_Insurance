package scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseTest {
	WebDriver driver;

	@Test(dataProvider = "testData1")
	public void requestQuoteTest(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login(username, password);

		homePage.isLogoutDisplayed();
		homePage.calculatePremium();

		Assert.assertTrue(homePage.isCalculatedPremiumDispalyed());
		Assert.assertTrue(homePage.isRadioButtonSelected());
		Assert.assertTrue(homePage.isTextDispalyed());
	}

	@DataProvider(name = "testData1")
	public void testDataProvider() {
		Object[][] data = new Object[2][2];
		data[0][0] = "abhishek.raj@outlook.in";
		data[0][1] = "XEd9iYNf9JP@Q8n";
		data[1][0] = "abc@gmail.com";
		data[1][1] = "abc";

	}

	@Test(dataProvider = "testData1")
	public void logOutTest(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login(username, password);

		homePage.logOut();
	}

}
