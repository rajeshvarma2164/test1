package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/SwagLab.feature", 
glue = "stepDefinitions", 
dryRun=false,// checks mapping between steps and feature files
monochrome = true, //proper console output
tags = "@PlaceOrderSawglabmutiple", //Scenarios tagged with @PlaceOrderSawglab,
//tags = "@PlaceOrderSawglab and @PlaceOrderSawglabmutiple",	//Scenarios tagged with both @sanity and @regression
////tags = "@PlaceOrderSawglab or @PlaceOrderSawglabmutiple"	 //Scenarios tagged with either @sanity or @regression
////tags = "@PlaceOrderSawglab and not @PlaceOrderSawglabmutiple", //Scenarios tagged with @sanity but not tagged with @regression
plugin = {
		"html:target/cucumber.html", 
		"json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarios.txt" }) // Runs only failures

public class JunitTestRunnerTest {	
	
}
