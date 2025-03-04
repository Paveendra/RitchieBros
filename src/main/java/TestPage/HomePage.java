package TestPage;


import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends TestBase{
	
WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		implicitwait(30);
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[@id='truste-consent-button']")
	WebElement cookies;
	@FindBy(xpath="//input[@class='MuiInputBase-input muiltr-ndk6wi']")
	WebElement globalSearch;
	@FindBy(xpath="//button[@class='MuiButtonBase-root  muiltr-119dq63']")
	WebElement searchButton;
	@FindBy(xpath="manufactureYearRange_min")
	WebElement yearStartrangeFrom;
	@FindBy(xpath="//h2[@data-testid='non-cat-header']")
	WebElement searchResultsHeader;
	@FindBy(css = ".muiltr-1w8dugu h4")
	List<WebElement> resultTiles;
	@FindBy(xpath="//*[@id='manufactureYearRange-header']//*[name()='svg']")
	WebElement yeardropdown;
	@FindBy(id="manufactureYearRange_min")
	WebElement fromYear;
	@FindBy(id="manufactureYearRange_max")
	WebElement toYear;
	
	/*
	 *This Method is to Accept Cookies on home page 
	 */
	public void acceptingCookies() {
		cookies.click();
	}
	/*
	 * This method to enter text in Global Search box
	 */
	public void setGlobalSearch(String searchValue) {
		globalSearch.sendKeys(searchValue);
	}
	/*
	 * This method is to get the search results from global search 
	 */
	public void clickGlobalSearch() {
		searchButton.click();
	}
	/*
	 * Get the Global search result value and store in a variable 
	 */
	public List<WebElement> getTileContents(){
		return resultTiles;
	}
	/*
	 * Capture the Global search Results 
	 */
	
	public String getResultContent() {
		return searchResultsHeader.getText();
	}
	
	/*
	 * Clicks on year drop down
	 */
	public void clickYearDropDown(){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yeardropdown);
		//yeardropdown.sendKeys(Keys.PAGE_DOWN);
		explicitwait(40,yeardropdown);
		yeardropdown.click();
	}
	
	/*
	 *  This method sets start of year
	 *  @param year - Year value
	 */
	public void setFromYear(String year) {
		fromYear.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		fromYear.sendKeys(Keys.chord(Keys.BACK_SPACE));
		fromYear.sendKeys(year);
	}
	/*
	 *  This method sets max year
	 *  @param year - Year value
	 */
	public void setToYear(String year) {
		toYear.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		toYear.sendKeys(Keys.chord(Keys.BACK_SPACE));
		toYear.sendKeys(year);
		toYear.sendKeys(Keys.ENTER);
	}
	
}
