package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;
import pageObjects.SwagLabPage;

public class SwagLabPageStepDefinition {

	SwagLabPage Sw;

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;

	public SwagLabPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("User login to Sawglab with {string} and {string}")
	public void userLogin(String username, String password) throws InterruptedException {
		// Implement login functionality using the provided username and password
		SwagLabPage swagLabPage = testContextSetup.pageObjectManager.getSwagLabPage();
		swagLabPage.Login(username, password);

	}

	@When("user searched with {string} and adds to cart")
	public void searchAndAddToCart(String productName) throws InterruptedException {

		// Implement product search and add to cart functionality using the provided
		// swagLabPage swagLabPage =
		// testContextSetup.pageObjectManager.getSwagLabPage();
		SwagLabPage swagLabPage = testContextSetup.pageObjectManager.getSwagLabPage();
		swagLabPage.searchAndAddToCart(productName);
	}

	@When("Adds {int} items to cart")
	public void adds_items_to_cart(Integer int1) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		SwagLabPage swagLabPage = testContextSetup.pageObjectManager.getSwagLabPage();
		swagLabPage.adds_items_to_cart(int1);
	}

	@Then("User Checkout and validate the {string} items in checkout page")
	public void validateCartItemInCheckout(String productName) throws InterruptedException {
		// Implement validation of the specified product in the checkout page
		SwagLabPage swagLabPage = testContextSetup.pageObjectManager.getSwagLabPage();
		swagLabPage.validateCartItemInCheckout(productName);
	}

	@Then("User enters {string} and  {string} and  {string} for delivery")
	public void user_enters_and_and_for_delivery(String string, String string2, String string3) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		SwagLabPage swagLabPage = testContextSetup.pageObjectManager.getSwagLabPage();
		swagLabPage.user_enters_and_and_for_delivery(string, string2, string3);
	}

	@Then("verify user has ability to finsh the order")
	public void verify_user_has_ability_to_finsh_the_order() {
		// Write code here that turns the phrase above into concrete actions
		SwagLabPage swagLabPage = testContextSetup.pageObjectManager.getSwagLabPage();
		swagLabPage.verify_user_has_ability_to_finsh_the_order();
	}
}
