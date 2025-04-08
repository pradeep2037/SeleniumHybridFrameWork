package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.BaseTest;

//common methods we are using in this class

public class BasePage extends BaseTest{
	
	public BasePage() {
		PageFactory.initElements(driver, this);

	}
	
	public void type(WebElement element, String text) {
		
		waitForElementPresence(element);
		element.sendKeys(text);
		test.log(Status.INFO, " Entered text "+text+" into the text");
	}
	
	
	private void waitForElementPresence(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(configProperties.getProperty("explicitWait"))));
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void click(WebElement element) {
		waitForElementPresence(element);
		element.click();	
		test.log(Status.INFO, " Clicked the button ");

	}
	
	
	public void selectOptionFromDropDown(WebElement element, String option) {
		waitForElementPresence(element);
		new Select(element).selectByVisibleText(option);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	
	public void verifyTextPresentAsValue(WebElement element,String text) {
		Assert.assertTrue(element.getAttribute("value").contains(text));
	}
	
	
	public void verifyTitle(String expTitle) {
		Assert.assertEquals(getTitle(), expTitle);
		test.log(Status.PASS, " Titles are matched...");
	}
}
