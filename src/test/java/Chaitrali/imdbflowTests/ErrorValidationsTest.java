package Chaitrali.imdbflowTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Chaitrali.TestComponentsJava.BaseTest;
import Chaitrali.TestComponentsJava.Retry;
import Chaitrali.imdbflow.PageObjects.ResultPage;
import Chaitrali.imdbflow.PageObjects.SignInPage;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups = { "ErrorHandling" }, retryAnalyzer = Retry.class)
	public void SigninErrorValidation() throws InterruptedException, IOException {
		String email = "wc@gmail.com";
		flow.searchBarOperations("amazon");
		ResultPage resultPage = flow.clickOnSearchButton();
		SignInPage sgnPage = resultPage.playVideo();
		sgnPage.signInProcess(email);
		Assert.assertEquals(sgnPage.getErrorMessage2(), "Couldn’t find your Google Account");
	}

	@Test(dependsOnMethods = { "ImdbFullFlowErrorValidation" })
	public void dependencyCheck() {
		System.out.println("ImdbFullFlowErrorValidation will run first");
	}

	@Test
	public void ImdbFullFlowErrorValidation() throws InterruptedException, IOException {
		String email = "dchaitrali15@gmail.com";
		flow.searchBarOperations("amazon");
		ResultPage resultPage = flow.clickOnSearchButton();
		SignInPage sgnPage = resultPage.playVideo();
		sgnPage.signInProcess(email);
		Thread.sleep(8000);
		sgnPage.getErrorMessage();
		System.out.println("I will run first");

	}


}
