package Chaitrali.imdbflowTests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Chaitrali.TestComponentsJava.BaseTest;
import Chaitrali.imdbflow.PageObjects.ResultPage;
import Chaitrali.imdbflow.PageObjects.SignInPage;

public class ImdbFullFlowCode extends BaseTest {

	@Test(dataProvider = "getData", groups = { "FlowGroup" })
	public void ImdbFullFlow(HashMap<String, String> input) throws InterruptedException, IOException {
		// String email = "dchaitrali15@gmail.com";
		flow.searchBarOperations(input.get("content"));
			ResultPage resultPage = flow.clickOnSearchButton();
			SignInPage sgnPage = resultPage.playVideo();
			sgnPage.signInProcess(input.get("email"));
			Thread.sleep(8000);
			sgnPage.getErrorMessage();
			System.out.println("changed method");
			System.out.println("changed method1");
			// sgnPage.getErrorMessage();
			// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			// wait.until((ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".dEOOab.RxsGPe")))));
			// System.out.println(driver.findElement(By.cssSelector(".dEOOab.RxsGPe")).getText());
			// // driver.findElement(By.cssSelector(".PrDSKc")).click();

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\Chaitrali\\imdbflow\\data\\Content.json");
		return new Object[][] { { data.get(0) } };
	}


}

/*
 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
 * "dchaitrali15@gmail.com"); map.put("content", "amazon");
 */