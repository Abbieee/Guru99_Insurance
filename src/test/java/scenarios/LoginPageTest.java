package scenarios;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {

	@Test(dataProvider = "testData1")
	public void loginTest(String username, String password) {
		System.out.println("Test 1 executed");
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login(username, password);
		Assert.assertTrue(homePage.isLogoutDisplayed());
		String title = driver.getTitle();
		Assert.assertEquals(title, "Insurance Broker System");
		Assert.assertTrue(homePage.isTextDispalyed());
		

	}
	
	
	@DataProvider(name = "testData1")
	public Object[][] testDataProvider() {
		Object[][] data = new Object[2][2];
		data[0][0] = "abhishek.raj@outlook.in";
		data[0][1] = "XEd9iYNf9JP@Q8n";
		data[1][0] = "abc@gmail.com";
		data[1][1] = "abc";
		return data;

	}

}
