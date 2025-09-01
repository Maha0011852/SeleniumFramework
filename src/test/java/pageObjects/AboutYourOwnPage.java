package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AboutYourOwnPage extends BasePage {

	public AboutYourOwnPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// Locators

    // Name
    @FindBy(id = "quoterEngine.question.firstName")
    private WebElement firstNameInput;

    @FindBy(id = "quoterEngine.question.lastName")
    private WebElement lastNameInput;

    // Date of Birth
    @FindBy(id = "quoterEngine.question.dateOfBirth.year")
    private WebElement dobYearDropdown;

    @FindBy(id = "quoterEngine.question.dateOfBirth.month")
    private WebElement dobMonthDropdown;

    @FindBy(id = "quoterEngine.question.dateOfBirth.day")
    private WebElement dobDayDropdown;

    // Gender, Marital status, Smoker
    @FindBy(xpath = "//button[@aria-label='Female']")
    private WebElement femaleButton;

    @FindBy(xpath = "//button[normalize-space()='Single']")
    private WebElement singleButton;

    @FindBy(xpath = "//button[@aria-label='No']")
    private WebElement smokerNoButton;

    // Contact info
    @FindBy(id = "quoterEngine.question.phoneNumber")
    private WebElement phoneNumberInput;

    @FindBy(id = "quoterEngine.question.email")
    private WebElement emailInput;

    @FindBy(id = "checkbox-userConsent")
    private WebElement userConsentCheckbox;

    @FindBy(id = "quoterEngine.footerButton.next")
    private WebElement nextButton;

    @FindBy(linkText = "Buy online")
    private WebElement buyOnlineLink;

    // Actions

    public void enterName(String firstName, String lastName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOf(lastNameInput)).sendKeys(lastName);
    }

    public void selectDateOfBirth(String year, String month, String day) {
        wait.until(ExpectedConditions.elementToBeClickable(dobYearDropdown));
        Select yearSelect = new Select(dobYearDropdown);
        yearSelect.selectByValue(year);

        wait.until(ExpectedConditions.elementToBeClickable(dobMonthDropdown));
        Select monthSelect = new Select(dobMonthDropdown);
        monthSelect.selectByVisibleText(month);

        wait.until(ExpectedConditions.elementToBeClickable(dobDayDropdown));
        Select daySelect = new Select(dobDayDropdown);
        daySelect.selectByValue(day);
    }

    public void selectPersonalDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(femaleButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(singleButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(smokerNoButton)).click();
        nextButton.click();
    }

    public void enterContactInfo(String phone, String email) {
        wait.until(ExpectedConditions.visibilityOf(phoneNumberInput)).sendKeys(phone);
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
        userConsentCheckbox.click();
        nextButton.click();
    }

    public void clickBuyOnline() {
        wait.until(ExpectedConditions.elementToBeClickable(buyOnlineLink)).click();
    }

}
