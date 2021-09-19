package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductSelection {
	public WebDriver driver;

	By items = By.cssSelector("[class='inventory_item']");
	By item_name = By.cssSelector("[class='inventory_item_name']");
	By item_price = By.cssSelector("[class='inventory_item_price']");
	By addToCart = By.xpath("//div[@class='inventory_item_price']/following-sibling::button");
	By cart = By.cssSelector("[class='shopping_cart_link']");
	
	public ProductSelection(WebDriver driver) {
	
		this.driver = driver;
	}

	public List<WebElement> items() {
		return driver.findElements(items);
	}
	public List<WebElement> item_name() {
		return driver.findElements(item_name);
	}
	public List<WebElement> item_price() {
		return driver.findElements(item_price);
	}
	public List<WebElement> addToCart() {
		return driver.findElements(addToCart);
	}
	public WebElement cart() {
		return driver.findElement(cart);
	}
	
}
