package insurance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InsuranceTests {
	
	@Test(enabled=false)
	public void loginvalidcredentials() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/insurance/v1/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("abhishek.raj@outlook.in");
		driver.findElement(By.id("password")).sendKeys("XEd9iYNf9JP@Q8n");
		driver.findElement(By.name("submit")).click();
	    String title = driver.getTitle();
		Assert.assertEquals(title, "Insurance Broker System");
	    String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://demo.guru99.com/insurance/v1/header.php");
		String text = driver.findElement(By.xpath("//div[@id='tabs-1']/h2")).getText();
		Assert.assertEquals(text, "Broker Insurance WebPage");
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Log out']")).isDisplayed());
	    
	    
	}
	@Test
	public void requestquotation() {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/insurance/v1/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("abhishek.raj@outlook.in");
		driver.findElement(By.id("password")).sendKeys("XEd9iYNf9JP@Q8n");
		driver.findElement(By.name("submit")).click();
		
		//Opening Request Quotation
		driver.findElement(By.linkText("Request Quotation")).click();
		
		//Conditions applied
		WebElement radio = driver.findElement(By.xpath("//input[@id='quotation_windscreenrepair_t']"));
		radio.click();
		Assert.assertTrue(radio.isSelected());
		
		
		
		driver.findElement(By.id("quotation_vehicle_attributes_value")).sendKeys("1000");
		
		Select parking = new Select(driver.findElement(By.name("parkinglocation")));
		parking.selectByIndex(3);
		
		
		
		
		//Calculate premium
		driver.findElement(By.xpath("//input[@value='Calculate Premium']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='calculatedpremium']")).isDisplayed());
		
		//Resetting form
		driver.findElement(By.xpath("//input[@id='resetquote']")).click();
		
     
		}
	}
