package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	private By logout = By.xpath("//input[@value='Log out']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void validlogin() {
		driver.findElement(By.id("email")).sendKeys("abhishek.raj@outlook.in");
		driver.findElement(By.id("password")).sendKeys("XEd9iYNf9JP@Q8n");
		driver.findElement(By.name("submit")).click();
	}

	public void invalidlogin() {
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("password")).sendKeys("abc");
		driver.findElement(By.name("submit")).click();
	}

	public void logout() {
		driver.findElement(logout).click();
	}

}
