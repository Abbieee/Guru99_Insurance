package scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class InsurancePage {
	private By radiobutton = By.xpath("//input[@id='quotation_windscreenrepair_t']");
	private By quotation = By.id("quotation_vehicle_attributes_value");
	private By calculatepremium = By.xpath("//p[@id='calculatedpremium']");
	private By parkinglocation = By.name("parkinglocation");

	@Test
	public void requestquotation() {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/insurance/v1/index.php");
		driver.manage().window().maximize();

		LoginPage logs = new LoginPage(driver);
		logs.validlogin();
		HomePage home = new HomePage(driver);
		home.request();

		WebElement radio = driver.findElement(radiobutton);
		radio.click();
		Assert.assertTrue(radio.isSelected());

		driver.findElement(quotation).sendKeys("1000");

		Select parking = new Select(driver.findElement(parkinglocation));
		parking.selectByIndex(3);

		home.premium();

		Assert.assertTrue(driver.findElement(calculatepremium).isDisplayed());

		home.reset();
		driver.quit();

	}

}
