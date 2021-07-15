package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	private By email = By.cssSelector("#email");
	private By passwordBox = By.xpath("//input[@id='password']");
	private By loginButton = By.cssSelector("input[name='submit']");


	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage login(String username, String password ) {

		driver.findElement(email).sendKeys(username);
		driver.findElement(passwordBox).sendKeys(password);
		driver.findElement(loginButton).click();
		
		
		
		return new HomePage(driver);
	}

}
