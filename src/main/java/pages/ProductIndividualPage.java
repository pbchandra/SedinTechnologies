package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductIndividualPage {

	public WebDriver driver;
	
	By item_name = By.cssSelector("[class*='inventory_details_name']");
	By item_price = By.cssSelector("[class='inventory_details_price']");
	By removeFromCart = By.xpath("//button[text()='Remove']");
	By checkout = By.id("checkout");
	
	public ProductIndividualPage(WebDriver driver) {
	
		this.driver = driver;
	}


	public WebElement item_name() {
		return driver.findElement(item_name);
	}
	public WebElement item_price() {
		return driver.findElement(item_price);
	}
	public WebElement removeFromCart() {
		return driver.findElement(removeFromCart);
	}
}
