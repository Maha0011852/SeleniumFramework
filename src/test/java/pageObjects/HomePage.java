package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	//Your Home page - Page 1
	
	@FindBy(linkText = "Home Quote")
	    WebElement homeQuoteLink;
	
	@FindBy(xpath = "//select[@id='quoterEngine.question.province']")
	    WebElement provinceDropdown;
	
	 @FindBy(xpath = "//input[@id='quoterEngine.question.propertyAddress']")
	    WebElement propertyAddress;
	 
	 @FindBy(xpath = "//typeahead-container[@role='listbox']//button[6]")
	    WebElement suggestedAddress;
	 
	   @FindBy(xpath = "//button[@aria-label='Yes']")
	    WebElement yesButton;

	    @FindBy(id = "quoterEngine.footerButton.next")
	    WebElement nextButton1;
	    
	 // Coverage Start Date
	    @FindBy(id = "quoterEngine.question.effectiveDate.month")
	     WebElement monthDropdown;

	    @FindBy(id = "quoterEngine.question.effectiveDate.day")
	     WebElement dayDropdown;

	    @FindBy(id = "quoterEngine.footerButton.next")
	     WebElement nextButton2;

	    // Year Home Built
	    @FindBy(linkText = "Where do I find this?")
	     WebElement findYearLink;

	    @FindBy(id = "buttonGotIt")
	     WebElement gotItButton;

	    @FindBy(id = "quoterEngine.question.yearBuilt")
	     WebElement yearBuiltInput;

	    // Basement
	    @FindBy(xpath = "//button[@aria-label='No']")
	     WebElement basementNoButton;

	    // Roof replacement
	    @FindBy(xpath = "//button[normalize-space()='Yes']")
	     WebElement roofYesButton;

	    @FindBy(id = "quoterEngine.question.roofReplacementYear")
	     WebElement roofYearInput;

	    @FindBy(id = "quoterEngine.question.roofType")
	     WebElement roofTypeDropdown;

	    // Home based business
	    @FindBy(xpath = "//button[normalize-space()='No']")
	     WebElement homeBusinessNoButton;

	    // High-Value Items
	    @FindBy(id = "checkbox-insurePersonalBikes")
	     WebElement personalBikesCheckbox;

	    @FindBy(id = "quoterEngine.question.insurePersonalBikesValue")
	     WebElement personalBikesValueInput;

	
	
	// Action Methods
    public void clickHomeQuote () {
		
    	homeQuoteLink.click();
	}
    public void selectProvinceByIndex(int index) {
    	wait.until(ExpectedConditions.elementToBeClickable(provinceDropdown));
        Select select = new Select(provinceDropdown);
        select.selectByIndex(index);
    }
    public void enterPropertyAddress(String address) {
        propertyAddress.sendKeys(address);
    }
    public void clickSuggestedAddress() {
        suggestedAddress.click();
    }
    public void clickYes() {
    	wait.until(ExpectedConditions.elementToBeClickable(yesButton));
        yesButton.click();
    }

    public void clickNext() {
    	wait.until(ExpectedConditions.elementToBeClickable(nextButton1));
        nextButton1.click();
    }
    public void selectCoverageStartDate(int monthIndex, int dayIndex) {
        wait.until(ExpectedConditions.elementToBeClickable(monthDropdown));
        new Select(monthDropdown).selectByIndex(monthIndex);
        new Select(dayDropdown).selectByIndex(dayIndex);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton2));
        nextButton2.click();
    }

    public void enterYearHomeBuilt(String year) {
        wait.until(ExpectedConditions.elementToBeClickable(findYearLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(gotItButton)).click();
        yearBuiltInput.clear();
        yearBuiltInput.sendKeys(year);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton2));
        nextButton2.click();
    }

    public void selectBasementNo() {
        wait.until(ExpectedConditions.elementToBeClickable(basementNoButton)).click();
        nextButton2.click();
    }

    public void roofReplacement(String year, int roofTypeIndex) {
        wait.until(ExpectedConditions.elementToBeClickable(roofYesButton)).click();
        roofYearInput.sendKeys(year);
        new Select(roofTypeDropdown).selectByIndex(roofTypeIndex);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton2));
        nextButton2.click();
    }

    public void selectHomeBasedBusinessNo() {
        wait.until(ExpectedConditions.elementToBeClickable(homeBusinessNoButton)).click();
        nextButton2.click();
    }

    public void addHighValueItem(String bikeValue) {
        wait.until(ExpectedConditions.elementToBeClickable(personalBikesCheckbox)).click();
        personalBikesValueInput.sendKeys(bikeValue);
        nextButton2.click();
    }

}
