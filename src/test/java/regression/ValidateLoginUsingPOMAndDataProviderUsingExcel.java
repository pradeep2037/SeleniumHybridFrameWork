package regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;
import utils.UtilKit;

public class ValidateLoginUsingPOMAndDataProviderUsingExcel extends BaseTest{
	
	@Test(dataProvider = "getTestData")
	public void validateLoginTest(HashMap <String, String> dataMap) {

		// Page Initialization -- Login Page
//		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		LoginPage loginPage = new LoginPage();
		loginPage.usernameTextbox(dataMap.get("username"));
		loginPage.passwordTextbox(dataMap.get("password"));
		loginPage.loginButton();

		// Page Initialization -- Search-Hotel Page
//		SearchHotelPage searchHotelPage = PageFactory.initElements(driver, SearchHotelPage.class);
		SearchHotelPage searchHotelPage = new SearchHotelPage();
		searchHotelPage.verifyTitle(dataMap.get("expTitle"));
		searchHotelPage.helloUsernameText(dataMap.get("username"));
	}
	
	
	@DataProvider
	public Object[][] getTestData() {
		Object[][] data = new Object[1][1];
		data[0][0] = UtilKit.getTestDataFromExcel("TC-001");
		return data;
	}
}










