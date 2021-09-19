package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginpage {

	public WebDriver driver;

	By username = By.id("user-name");
	By password = By.id("password");
	By loginButton = By.id("login-button");
	By errorMsg = By.cssSelector("div[class='error-message-container error'] h3");
	public loginpage(WebDriver driver) {
	
		this.driver = driver;
	}

	public WebElement username() {
		return driver.findElement(username);
	}

	public WebElement password() {
		return driver.findElement(password);
	}

	public WebElement loginButton() {
		return driver.findElement(loginButton);
	}

	public WebElement errorMsg() {
		return driver.findElement(errorMsg);
	}

}
