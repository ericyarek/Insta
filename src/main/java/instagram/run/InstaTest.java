package instagram.run;

import static utilities.ConfigReader.getProperty;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import insta.pages.DownloadAppPage;
import insta.pages.InstaHomePage;
import insta.pages.InstaLoginPage;

public class InstaTest extends TestBase{
	
	InstaLoginPage instaLoginPage;
	DownloadAppPage downloadAppPage; 
	InstaHomePage instaHomePage;
	
	
	@BeforeMethod
	public void navigate() {		
		super.driver.get( getProperty("insta.url") );
		
		instaLoginPage= new InstaLoginPage(driver);
		downloadAppPage= new DownloadAppPage(driver);
		instaHomePage= new InstaHomePage(driver);
	}
	
	@Test
	public void InstagramLiker() throws InterruptedException {
		//FOR DAMIRA WITH LOVE
		//LOGING IN WITH METHOD
		instaLoginPage.InstaLogIn(getProperty("insta.username"), getProperty("insta.password"));
		// Declining Download App
		downloadAppPage.notNowButton.click();
		
		Thread.sleep(3000);
		instaHomePage.htmlPopOutCloseButton.click();
		
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until( ExpectedConditions.elementToBeClickable(instaHomePage.htmlPopOutCloseButton));
		
		instaHomePage.hitLikesForSomeTime(driver , Integer.valueOf(  getProperty("insta.minutes") ));
		
	}

}
