package Chaitrali.imdbflow.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Chaitrali.imdbflow.AbstractComponent.AbstractComponents;

public class ResultPage extends AbstractComponents {
	private WebDriver driver;

	public ResultPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='title-wrapper'][1]")
	WebElement titles;


	By findBy = By.xpath("//div[@id='title-wrapper'][1]");

	public SignInPage playVideo() throws InterruptedException {
		waitForElementToAppear(findBy);
		titles.click();
		Thread.sleep(9000);
		clickOnHomeButton();
		Thread.sleep(5000);
		clickOnSignInButton();
		SignInPage sgnPage = new SignInPage(driver);
		return sgnPage;
	}

}
