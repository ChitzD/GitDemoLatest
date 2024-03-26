package Chaitrali.imdbflow.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Chaitrali.imdbflow.AbstractComponent.AbstractComponents;

public class videoPlayFlow extends AbstractComponents {

	private WebDriver driver;

	public videoPlayFlow(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='search']")
	WebElement searchBar;
	
	@FindBy(css="#search-icon-legacy")
	WebElement searchButton;
	
	@Test
	public void searchBarOperations(String text) throws InterruptedException {
		Thread.sleep(2000);
		searchBar.click();
		Thread.sleep(2000);
		searchBar.sendKeys(text);
	}
	
	public ResultPage clickOnSearchButton() {
	searchButton.click();
	ResultPage resultPage = new ResultPage(driver);
	return resultPage;
	}
	
	public void goToSitePage() throws InterruptedException {
		driver.get("https://www.youtube.com");
		Thread.sleep(5000);
	}
	
	

}

