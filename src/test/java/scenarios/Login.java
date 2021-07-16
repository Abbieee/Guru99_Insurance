package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class Login {
	private By logout = By.xpath("//input[@value='Log out']");
	private By content = By.xpath("//div[@id='tabs-1']/h2");
	@Test
	public void loginvalidcredentials() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/insurance/v1/index.php");
		driver.manage().window().maximize();
		
		LoginPage logs = new LoginPage(driver);
		logs.login();
		
	    String title = driver.getTitle();
		Assert.assertEquals(title, "Insurance Broker System");
	    String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://demo.guru99.com/insurance/v1/header.php");
		String text = driver.findElement(content).getText();
		Assert.assertEquals(text, "Broker Insurance WebPage");
		
		Assert.assertTrue(driver.findElement(logout).isDisplayed());
		
		driver.quit();

}
}