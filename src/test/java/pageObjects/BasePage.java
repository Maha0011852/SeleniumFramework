package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public BasePage (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
		
		/*
		

Stores WebDriver instance → The driver is passed from your test class or base test class into each page object.

Initializes PageFactory → PageFactory.initElements(driver, this) automatically initializes all the @FindBy elements in child page classes.

Encapsulation → This avoids duplicate code in each page object class.
		 */
		
		
	}
	

}
