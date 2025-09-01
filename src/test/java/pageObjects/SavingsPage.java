package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SavingsPage extends BasePage {
	//WebDriver driver;
    //WebDriverWait wait;

    public SavingsPage(WebDriver driver) {
      super(driver);
    }

    // Locators

    // Savings - Monitored Systems
    @FindBy(xpath = "//div[@data-e2e='checkbox-textWaterProtectionSystem']")
    private WebElement waterProtectionCheckbox;

    @FindBy(id = "quoterEngine.footerButton.next")
    private WebElement nextButton;

    // Savings - Claims
    @FindBy(xpath = "//button[normalize-space()='1']")
    private WebElement claimButton;

    @FindBy(id = "quoterEngine.question.claimDetail")
    private WebElement claimDetailDropdown;

    @FindBy(id = "quoterEngine.question.accidentDate.year")
    private WebElement accidentYearDropdown;

    @FindBy(id = "quoterEngine.question.accidentDate.month")
    private WebElement accidentMonthDropdown;

    // Savings - Additional Savings
    @FindBy(xpath = "//div[@aria-labelledby='quoterEngine.question.mortgage-title-label']//button[@aria-label='No'][normalize-space()='No']")
    private WebElement mortgageNoButton;

    @FindBy(xpath = "//div[@aria-labelledby='quoterEngine.question.tdRelationship-title-label']//button[@aria-label='No'][normalize-space()='No']")
    private WebElement tdRelationshipNoButton;

    // Savings - Group Information
    @FindBy(id = "radio-button-group-discount-not-applicable")
    private WebElement groupDiscountNotApplicable;

    // Actions

    public void selectWaterProtectionSystem() {
        wait.until(ExpectedConditions.elementToBeClickable(waterProtectionCheckbox)).click();
        nextButton.click();
    }

    public void addClaim(String claimType, int accidentYearIndex, int accidentMonthIndex) {
        wait.until(ExpectedConditions.elementToBeClickable(claimButton)).click();

        wait.until(ExpectedConditions.elementToBeClickable(claimDetailDropdown)).click();
        Select selectClaim = new Select(claimDetailDropdown);
        selectClaim.selectByVisibleText(claimType);

        Select selectYear = new Select(accidentYearDropdown);
        selectYear.selectByIndex(accidentYearIndex);

        Select selectMonth = new Select(accidentMonthDropdown);
        selectMonth.selectByIndex(accidentMonthIndex);

        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
        nextButton.click();
    }

    public void additionalSavingsNo() {
        wait.until(ExpectedConditions.elementToBeClickable(mortgageNoButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tdRelationshipNoButton)).click();
        nextButton.click();
    }

    public void groupInformationNotApplicable() {
        wait.until(ExpectedConditions.elementToBeClickable(groupDiscountNotApplicable)).click();
        nextButton.click();
    }

}
