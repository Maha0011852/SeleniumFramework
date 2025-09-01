package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SavingsPage;
import testBase.BaseClass;

public class TC002_SavingsPage extends BaseClass {
	
	@Test (groups= {"Sanity"})
	public void verify_SavingsPage_validation () throws InterruptedException {
	
	 HomePage hp = new HomePage (driver);
	 hp.clickHomeQuote();
	 hp.selectProvinceByIndex(8);
	 hp.enterPropertyAddress("N6G0T8");
	 Thread.sleep(5000);
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
	 
	 
	 
	 

}
}
