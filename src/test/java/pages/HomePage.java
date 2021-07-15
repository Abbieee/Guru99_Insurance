package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {

	WebDriver driver;

	private By requestQuotationTab = By.id("ui-id-2");
	private By estimateValuetextbox = By.id("quotation_vehicle_attributes_value");
	private By calculatePremiumButton = By.xpath("//input[@value='calculate premium']");
	private By calculatePremium = By.id("calculatedpremium");
	private By buttonIsSelected = By.xpath("//input[@value='No']");
	 
	private By text = By.id("Broker Insurance WebPage");
	private By logout = By.xpath("//input[@type='submit']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage calculatePremium() {
		driver.findElement(requestQuotationTab).click();
		driver.findElement(estimateValuetextbox).sendKeys("1000");
		driver.findElement(calculatePremiumButton).click();
		return this;
	}

	public boolean isCalculatedPremiumDispalyed() {
		return driver.findElement(calculatePremium).isDisplayed();
	}

	public boolean isRadioButtonSelected() {
		return driver.findElement(buttonIsSelected).isSelected();

	}
	public boolean isTextDispalyed() {
		return driver.findElement(text).isDisplayed();
	}
	

	public LoginPage logOut() {

		driver.findElement(logout).click();
		return new LoginPage(driver);

	}

	public boolean isLogoutDisplayed() {
		return driver.findElement(logout).isDisplayed();
	}
}
