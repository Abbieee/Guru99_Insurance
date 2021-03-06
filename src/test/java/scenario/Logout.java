package scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class Logout {
	
	
	
		private By loginbutton = By.xpath("//input[@value='Log in']");
		private By logoutbutton = By.xpath("//input[@value='Log out']");
		@Test
		public void out() {
			System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://demo.guru99.com/insurance/v1/index.php");
			driver.manage().window().maximize();
			
			LoginPage logs = new LoginPage(driver);
			logs.validlogin();
			//Log out button present
			Assert.assertTrue(driver.findElement(logoutbutton).isDisplayed());
			
			logs.logout();
			
		
			Assert.assertTrue(driver.findElement(loginbutton).isDisplayed());
			
			String title = driver.getTitle();
			Assert.assertEquals(title, "Insurance Broker System - Login");
			
			String url = driver.getCurrentUrl();
			Assert.assertEquals(url, "http://demo.guru99.com/insurance/v1/index.php");
			
			
		}
	}


