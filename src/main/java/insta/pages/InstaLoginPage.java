package insta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstaLoginPage {
	public InstaLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="username")
	public  WebElement userName;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//button[.='Log in']")
	public WebElement logInButton;
	
	//Login method @ Yaroslav
	public void InstaLogIn(String name , String pass) {
		userName.sendKeys( name );
		password.sendKeys(pass);
		logInButton.click();
	}

}
