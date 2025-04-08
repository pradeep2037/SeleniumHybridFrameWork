package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BasePage{
	
	public SearchHotelPage() {
//		PageFactory.initElements(driver, this);
		super();
	}
	
	@FindBy(xpath = "//input[@id='username_show']") WebElement helloUsernameText;
	
	
	public void helloUsernameText(String username) {
		
		verifyTextPresentAsValue(helloUsernameText,username);
	}
}


