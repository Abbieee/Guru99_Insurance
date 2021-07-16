package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest {
	private By rad = By.xpath("//input[@id='quotation_windscreenrepair_t']"); 
	private By quote = By.id("quotation_vehicle_attributes_value");
	private By calculate = By.xpath("//p[@id='calculatedpremium']");
	private By park = By.name("parkinglocation");
	@Test
	public void requestquotation() {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/insurance/v1/index.php");
		driver.manage().window().maximize();
		
		LoginPage logs = new LoginPage(driver);
		logs.login();
		HomePage home = new HomePage(driver);
		home.request();
		
		//Conditions applied
		WebElement radio = driver.findElement(rad);
		radio.click();
		Assert.assertTrue(radio.isSelected());
		
		driver.findElement(quote).sendKeys("1000");
		
		Select parking = new Select(driver.findElement(park));
		parking.selectByIndex(3);
		
		
		home.premium();
		
		Assert.assertTrue(driver.findElement(calculate).isDisplayed());
		
		home.reset();
		driver.quit();
		
     
		}

}
