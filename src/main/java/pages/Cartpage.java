package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cartpage {

	
	
	public WebDriver driver;
	
	By item_name = By.cssSelector("[class='inventory_item_name']");
	By item_price = By.cssSelector("[class='inventory_item_price']");
	By removeFromCart = By.xpath("//div[@class='inventory_item_price']/following-sibling::button");
	By checkout = By.id("checkout");
	
	public Cartpage(WebDriver driver) {
	
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
	
	public WebElement checkout() {
		return driver.findElement(checkout);
	}
}
