package testCases;

import org.testng.annotations.Test;

import pageObjects.AboutYourOwnPage;
import pageObjects.HomePage;
import pageObjects.SavingsPage;
import testBase.BaseClass;

public class TC003_AboutYourOwnPage extends BaseClass {
	
	@Test (groups= {"Sanity"})
	public void verify_AboutYourOwnPage_validation () throws InterruptedException 
	{
	HomePage hp = new HomePage (driver);
	 hp.clickHomeQuote();
	 hp.selectProvinceByIndex(8);
	 hp.enterPropertyAddress("N6G0T8");
	 Thread.sleep(3000);
	 hp.clickSuggestedAddress();
	 hp.clickYes();
	 hp.clickNext();
	 hp.selectCoverageStartDate(3, 3);
	 hp.enterYearHomeBuilt("2017");
	 hp.selectBasementNo();
	 hp.roofReplacement("2022", 4);
	 hp.selectHomeBasedBusinessNo();
	 hp.addHighValueItem("3000");
	 
	 
	 SavingsPage sp = new SavingsPage(driver);
	 sp.selectWaterProtectionSystem();
	 sp.addClaim("Windstorm & Hail", 2, 2);
	 sp.additionalSavingsNo();
	 sp.groupInformationNotApplicable();
	 
	 AboutYourOwnPage ap = new AboutYourOwnPage(driver);
	 ap.enterName("Krish", "Anju");
	 ap.selectDateOfBirth("1995", "Jun", "15");
	 ap.selectPersonalDetails();
	 ap.enterContactInfo("7059882845", "maha.veerakumark@gmail.com");
	 Thread.sleep(7000);
	 ap.clickBuyOnline();
	 
	 

}
}
