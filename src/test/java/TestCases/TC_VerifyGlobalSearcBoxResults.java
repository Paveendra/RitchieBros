package TestCases;

import TestPage.HomePage;
import base.TestBase;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Year;
import java.util.List;

public class TC_VerifyGlobalSearcBoxResults extends TestBase {
	HomePage homepage;

	@Test
	public void execution() throws InterruptedException {
		
		homepage = new HomePage(driver);
		homepage.acceptingCookies();
		homepage.setGlobalSearch("Ford F-150");
		ChainTestListener.log(" Ford F-150 Value is passed into Global serch text box ");
		homepage.clickGlobalSearch();
		// capturing total results count
		int resultsCount = Integer.parseInt(homepage.getResultContent().split("of ")[1].split("results")[0].trim());
		
		logger.info("Total Result Count from Global search - "+resultsCount);
		ChainTestListener.log("Total Result Count from Global search - "+resultsCount);
		// Strong the all values in an variable 
		List<WebElement> tileContents = homepage.getTileContents();
		// capturing 1st result text
		String tileText = tileContents.get(0).getText();
		// Verifying the first result with Actual
		if(tileText.contains("Ford F-150")) {
			logger.info("First Tile contains Ford F-150 ");
			ChainTestListener.log(" First Tile contains Ford F-150 ");
		}else {
			logger.info("First Result Tile does not contains Ford F-150 Value."
					+ "  Actual Result :"+tileText
					+ " and Expected Result : Ford F-150");
			ChainTestListener.log("First Result Tile does not contains Ford F-150 Value."
					+ "  Actual Result :"+tileText
					+ " and Expected Result : Ford F-150");
		}
		//Clicking on Year drop down 
		homepage.clickYearDropDown();
		ChainTestListener.log(" Year Drop down is clicked to provode range ");
		homepage.setFromYear("2010");
		ChainTestListener.log(" Year range start from 2010 ");
		int year = Year.now().getValue();
		homepage.setToYear(String.valueOf(year));
		ChainTestListener.log(" Till current Year ");
		Thread.sleep(3000);
        int finalResultsCount = Integer.parseInt(homepage.getResultContent().split("of ")[1].split("results")[0].trim());
		logger.info("Total Result Count - "+finalResultsCount);
		ChainTestListener.log("Total Result Count - "+finalResultsCount);
		if(finalResultsCount>resultsCount) {
			logger.info("finalResultsCount = "+finalResultsCount + "  is Greater than "+tileContents);
			ChainTestListener.log("finalResultsCount = "+finalResultsCount + "  is Greater than "+tileContents);

		}
		else {
			logger.info("finalResultsCount = "+finalResultsCount + "  is Less than  "+ tileContents);
			ChainTestListener.log("finalResultsCount = "+finalResultsCount + "  is Less than  "+ tileContents);
			
		}
	}

}
