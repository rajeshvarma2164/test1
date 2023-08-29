package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;
import org.openqa.selenium.WebElement;
import utils.DataReader;

public class SwagLabPage {
	public WebDriver driver;

	public SwagLabPage(WebDriver driver) {
		this.driver = driver;
	}

	//public List<HashMap<String, String>> datamap; // Data driven
	
	private By button = By.xpath("//input[contains(@name,'login-button')]");
	private By usernameweb = By.xpath("//input[contains(@name,'user-name')]");
	private By passwordweb = By.xpath("//input[contains(@name,'password')]");
	private By addtocart = By.xpath("//*[@class='inventory_list']//following::button");
	private By shoppingcart = By.xpath("//*[@id='shopping_cart_container']/a");
	private By title = By.xpath("//*[@class='title']");
	private By checkout = By.xpath("//button[contains(@name,'checkout')]");
	private By firsnamecheckout = By.xpath("//input[contains(@name,'firstName')]");
	private By lastnamecheckout = By.xpath("//input[contains(@name,'lastName')]");
	private By postalCode = By.xpath("//input[contains(@name,'postalCode')]");
	private By submitdetails = By.xpath("//input[contains(@type,'submit')]");
	private By invetoryname = By.xpath("//*[@class='inventory_item_name']");
	private By finishorder = By.xpath("//button[contains(@name,'finish')]");
	private By succesmessage = By.xpath("//*[@id=\"checkout_complete_container\"]");

	TestContextSetup testContextSetup;

	public void Login(String username, String password) throws InterruptedException {
		// Implement login functionality using the provided username and password
		Thread.sleep(5000);
		driver.findElement(usernameweb).sendKeys(username);
		driver.findElement(passwordweb).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(button).click();

	}

	public void searchAndAddToCart(String productName) throws InterruptedException {
		// Implement product search and add to cart functionality using the provided
		// product name
		// testContextSetup.genericUtils.waitForVisibilityOfElement(productName, null);
		Thread.sleep(5000);
		int i = 0;
		List<WebElement> cartItems = driver.findElements(By.xpath("//*[@class='inventory_list']//following::a//div"));
		for (WebElement e : cartItems) {
			i++;
			System.out.println(e.getText().trim());
			if (e.getText().equalsIgnoreCase(productName.trim())) {
				System.out.println(i + 1);
				break;
			}
		}
		i = i - 1;
		WebElement addtocart = driver
				.findElement(By.xpath("//*[@class='inventory_list']//following::button[" + i + "]"));
		i = 0;
		Thread.sleep(2000);
		addtocart.click();
		Thread.sleep(2000);

	}

	public void adds_items_to_cart(Integer int1) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		String c = driver.findElement(shoppingcart).getText();
		System.out.println(c);
		if (c != null) {
			driver.findElement(shoppingcart).click();
			Thread.sleep(2000);
		}
	}

	public void validateCartItemInCheckout(String productName) throws InterruptedException {
		// Implement validation of the specified product in the checkout page
		String c = driver.findElement(shoppingcart).getText();
		System.out.println(c);
		if (c != null) {
			driver.findElement(checkout).click();
			Thread.sleep(2000);
		}
	}

	public void user_enters_and_and_for_delivery(String name, String last, String pin) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(firsnamecheckout).sendKeys(name);
		driver.findElement(lastnamecheckout).sendKeys(last);
		driver.findElement(postalCode).sendKeys(pin);
		Thread.sleep(2000);
		driver.findElement(submitdetails).click();

	}

	public void verify_user_has_ability_to_finsh_the_order() {

		// Write code here that turns the phrase above into concrete actions
		String c = driver.findElement(invetoryname).getText();
		if (c != null) {
			driver.findElement(finishorder).click();

		}
	}

}
