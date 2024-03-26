package imdbflow.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import Chaitrali.TestComponentsJava.BaseTest;
import Chaitrali.imdbflow.PageObjects.ResultPage;
import Chaitrali.imdbflow.PageObjects.SignInPage;
import Chaitrali.imdbflow.PageObjects.videoPlayFlow;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {

	public videoPlayFlow flow;
	public ResultPage resultPage;
	public SignInPage sgnPage;
	
	@Given("I landed on youtube page")
	public void I_landed_on_youtube_page() throws IOException, InterruptedException {
		flow = launchApplication();
	}
	
	@Given("^On youtube page it will paste (.+) and click on search button$")
	public void enterContentAndClickSearchButton(String content) throws InterruptedException {
		flow.searchBarOperations(content);
		resultPage = flow.clickOnSearchButton();
	}

	@When("it will go to next page,play video and click on home button and go to signinpage")
	public void playVideoAndClickHomeButtonandGoToSignInPage() throws InterruptedException {
		sgnPage = resultPage.playVideo();
	}
	
	@Then("^on homepage it will click on sign in button and try to sign in through (.+)$")
	public void signInProcessAndGetErrorMessage(String email) throws InterruptedException {
		sgnPage.signInProcess(email);
		Thread.sleep(8000);
		System.out.println(sgnPage.getErrorMessage());
		driver.close();
	}

	@Then("^error message is displayed it use (.+) and (.+)$")
	public void error_Message_is_displayed(String email, String content) throws InterruptedException {
		flow.searchBarOperations(content);
		resultPage = flow.clickOnSearchButton();
		sgnPage = resultPage.playVideo();
		sgnPage.signInProcess(email);
		Assert.assertEquals(sgnPage.getErrorMessage2(), "Couldn’t find your Google Account");
		driver.close();
	}
}
