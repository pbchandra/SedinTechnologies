package saucedemo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.loginpage;
import resources.base;

public class LoginTest extends base {
	@Test
	public void InvalidLoginTest() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		loginpage lp = new loginpage(driver);
		lp.username().sendKeys("stanted_user");
		lp.password().sendKeys("invalid");
		lp.loginButton().click();

		Assert.assertEquals(lp.errorMsg().getText(),
				"Epic sadface: Username and password do not match any user in this service");
		driver.close();
	}
}
