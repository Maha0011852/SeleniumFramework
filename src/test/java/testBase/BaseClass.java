package testBase;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.qameta.allure.Attachment;

public class BaseClass {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeClass (groups= {"Sanity"})
	public void setup() throws IOException {
		
		 // Initialize ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to URL
        driver.get("https://www.tdinsurance.com/products-services/home-insurance/coverage/ontario");

        // Handle cookie banner if present
        try {
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(., 'Accept all')]")
            ));
            acceptCookies.click();
            wait.until(ExpectedConditions.invisibilityOf(acceptCookies));
            System.out.println("Cookies banner dismissed.");
        } catch (Exception e) {
            System.out.println("No cookie banner found, skipping...");
        }
    }
	 @AfterMethod(alwaysRun = true)
	    public void captureFailureScreenshot(ITestResult result) {
	        if (ITestResult.FAILURE == result.getStatus()) {
	            saveScreenshotPNG(driver);
	        }
	    }

	    @Attachment(value = "Page Screenshot", type = "image/png")
	    public byte[] saveScreenshotPNG(WebDriver driver) {
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    } 

	
    @AfterClass (alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // quits browser completely
            
            System.out.println("TearDown called, quitting driver...");
        }
    }
	
}
