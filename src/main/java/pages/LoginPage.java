package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	public LoginPage() {
//		PageFactory.initElements(driver, this);
		super();
	}
	
	//WebElements or Variables
	//We Use Page Factory
	
//	WebElement usernameTextbox = driver.findElement(By.xpath("//input[@name='username']"));
	
	@FindBy(xpath="//input[@name='username']") WebElement usernameTextbox;
	
	@FindBy(xpath="//input[@name='password']") WebElement passwordTextbox;

	@FindBy(xpath="//input[@name='login']") WebElement loginButton;
	

	
	
	

	
	
	//Methods
	public void usernameTextbox(String text) {
		type(usernameTextbox, text);
	}
	
	public void passwordTextbox(String text) {
		type(passwordTextbox, text);
	}
	
	public void loginButton() {
		click(loginButton);
	}
	
	
	
}
