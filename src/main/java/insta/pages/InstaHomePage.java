package insta.pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstaHomePage {
	private WebDriver driver;

	
	public InstaHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='uDNXD']")
	public WebElement htmlPopOutCloseButton;
	
	@FindBy(xpath="//div/div/div/article/div[2]/section/span/button/span[.='Like']")
	public WebElement like;
	
	

	
	
	public void hitLikesForSomeTime(WebDriver driver, int manyMinutes) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		
		LocalDateTime RightNow = LocalDateTime.now();
		String start = LocalDateTime.now() +"";
		DateTimeFormatter customMinutes = DateTimeFormatter.ofPattern("mm");
		System.out.println(customMinutes.format(RightNow));
		Integer minuteNow = Integer.valueOf(customMinutes.format(RightNow));
		
		int forOneMinute =  minuteNow + manyMinutes;

		
		while (minuteNow < forOneMinute) {
			try {
			List<WebElement> likes =driver.findElements(By.xpath("//div/div/div/article/div[2]/section/span/button/span[.='Like']"));
			if(likes.size()==0) {
				js.executeScript("window.scrollBy(0,1900);");
			}
			for(WebElement like : likes) {
				action.moveToElement(like).click().build().perform();
				Thread.sleep(2000);
			}
			RightNow = LocalDateTime.now();
			minuteNow = Integer.valueOf(customMinutes.format(RightNow));
			
			}catch(StaleElementReferenceException e) {
				return;
			}
	}
		System.out.println("Starting time - " + start);
		System.out.println("Finish time - " + LocalDateTime.now());
	}
}
