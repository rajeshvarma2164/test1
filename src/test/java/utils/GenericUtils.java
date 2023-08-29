package utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.support.ui.ExpectedCondition;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void SwitchWindowToChild() {
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);

	}

	public void waitForVisibilityOfElement(String xpath, Duration timeout) {
	    WebDriverWait waitSelenium = new WebDriverWait(driver, timeout);
	    waitSelenium.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}

}
