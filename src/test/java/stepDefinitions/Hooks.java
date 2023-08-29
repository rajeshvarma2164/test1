package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;
	}

//	@Before
//	private static void executeCucumberTests() {
//		String command = "java -javaagent:C:\\Users\\rajes\\.m2\\repository\\org\\jacoco\\org.jacoco.agent\\0.8.10\\org.jacoco.agent-0.8.10.jar -jar your-test-jar.jar";
//
//		try {
//			Process process = Runtime.getRuntime().exec(command);
//			process.waitFor();
//		} catch (IOException | InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	@After
	public void AfterScenario() throws IOException {

		testContextSetup.testBase.WebDriverManager().quit();

	}

	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		WebDriver driver = testContextSetup.testBase.WebDriverManager();
		if (scenario.isFailed()) {
			// screenshot
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");

		}

	}

}
