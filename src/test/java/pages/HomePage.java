package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	private By calculatepremium = By.xpath("//input[@value='Calculate Premium']");
	private By resetform = By.xpath("//input[@id='resetquote']");
	private By requestquotation = By.linkText("Request Quotation");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void request() {

		driver.findElement(requestquotation).click();
	}

	public void premium() {

		driver.findElement(calculatepremium).click();
	}

	public void reset() {

		driver.findElement(resetform).click();
	}

}
