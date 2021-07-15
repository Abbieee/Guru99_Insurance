package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	private By cal = By.xpath("//input[@value='Calculate Premium']");
	private By reset = By.xpath("//input[@id='resetquote']");
	private By req = By.linkText("Request Quotation");
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
	}
	public void request() {
		//Opening Request Quotation
				driver.findElement(req).click();
	}
	public void premium() {
		//Calculate premium
				driver.findElement(cal).click();
	}
	public void reset() {
		//Resetting form
				driver.findElement(reset).click();
	}

}