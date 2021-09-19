package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutInformationpage {

	
	
	public WebDriver driver;
	

	
	By firstname = By.id("first-name");
	By lastname = By.id("last-name");
	By postalcode = By.id("postal-code");
	By continueButton = By.id("continue");
	
	public CheckOutInformationpage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	public WebElement firstname() {
		return driver.findElement(firstname);
	}
	public WebElement lastname() {
		return driver.findElement(lastname);
	}
	public WebElement postalcode() {
		return driver.findElement(postalcode);
	}
	
	public WebElement continueButton() {
		return driver.findElement(continueButton);
	}
	
}



