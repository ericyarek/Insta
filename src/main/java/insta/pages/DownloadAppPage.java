package insta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadAppPage {
	
	public DownloadAppPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[.='Not Now']")
	public WebElement notNowButton;
	

}
