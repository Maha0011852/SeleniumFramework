package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_HomePage extends BaseClass
{

	@Test (groups= {"Sanity"})
public void verify_homepage_validation () throws InterruptedException {
	
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
	 
	 
	 
	 
	 
	 
	
}



}
