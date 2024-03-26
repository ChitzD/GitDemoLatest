package Chaitrali.imdbflow.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Chaitrali.imdbflow.AbstractComponent.AbstractComponents;

public class SignInPage extends AbstractComponents {

	private WebDriver driver;

	public SignInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#identifierId")
	WebElement emailBox;
	
	By findBy2 = By.cssSelector("#identifierId");
	
	@FindBy(css = "div[id='identifierNext']")
	WebElement nextButton;

	@FindBy(xpath = "//div[text()='Try using a different browser. If you’re already using a supported browser, you can try again to sign in.']")
	WebElement errorMessage;

	By FindBy = By.cssSelector("a[aria-label='Sign in']");

	@FindBy(xpath = "//*[text()='Couldn’t find your Google Account']")
	WebElement errorMessage2;

	public void signInProcess(String email) throws InterruptedException {
		waitForElementToAppear(findBy2);
		emailBox.sendKeys(email);
		nextButton.click();
		Thread.sleep(5000);
	}

	public String getErrorMessage() throws InterruptedException {
		Thread.sleep(8000);
		return errorMessage.getText();
	}

	public String getErrorMessage2() {
		waitForWebElementToAppear(errorMessage2);
		return errorMessage2.getText();

	}
	// .PrDSKc:nth-child(2)
	// driver.findElement(By.cssSelector("a[aria-label='Sign in']")).click();
	// driver.findElement(By.cssSelector("#identifierId")).sendKeys(email);
	// driver.findElement(By.cssSelector("div[id='identifierNext']")).click();

}
