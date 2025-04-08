
package regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;

public class ValidateLoginUsingPOM extends BaseTest {

	@Test
	public void validateLoginTest() {

		// Page Initialization -- Login Page
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.usernameTextbox("pradeep264");
		loginPage.passwordTextbox("pradeep264");
		loginPage.loginButton();

		// Page Initialization -- Search-Hotel Page
		SearchHotelPage searchHotelPage = PageFactory.initElements(driver, SearchHotelPage.class);
		searchHotelPage.verifyTitle("Adactin.com - Search Hotel");
		searchHotelPage.helloUsernameText("pradeep264");
		
	}
}
