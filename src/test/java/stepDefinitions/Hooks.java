package stepDefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@After
	public void AfterScenario() throws Exception {
		testContextSetup.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws Exception {
		WebDriver driver = testContextSetup.testBase.WebDriverManager();
		if(scenario.isFailed()) {
		File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		}
		
	}
}
