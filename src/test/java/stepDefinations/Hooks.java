package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestCaseUtils;

public class Hooks {

	TestCaseUtils testCaseUtils;

	public Hooks(TestCaseUtils testCaseUtils) {
		this.testCaseUtils = testCaseUtils;
	}

	@After
	public void AfterScenario() throws IOException {
		testCaseUtils.testBase.getWebDriver().quit();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		WebDriver driver = testCaseUtils.testBase.getWebDriver();
		if (scenario.isFailed()) {
			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] data = FileUtils.readFileToByteArray(sourceFile);
			scenario.attach(data, "image/png", "image");
		}
	}

}
