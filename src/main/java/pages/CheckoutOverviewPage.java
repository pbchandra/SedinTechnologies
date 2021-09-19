package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {

	//
public WebDriver driver;
	

	By item_name = By.cssSelector("[class='inventory_item_name']");
	By finish = By.id("finish");
	
	public CheckoutOverviewPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	
	public WebElement item_name() {
		return driver.findElement(item_name);
	}
	public WebElement finish() {
		return driver.findElement(finish);
	}
}
