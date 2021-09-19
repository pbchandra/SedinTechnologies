package saucedemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductSelection;
import pages.loginpage;
import resources.base;

public class CheckProductPresence extends base {
	
	@Test
	public void ValidateProductPresence() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		loginpage lp = new loginpage(driver);
		lp.username().sendKeys("standard_user");
		lp.password().sendKeys("secret_sauce");
		lp.loginButton().click();

		ProductSelection psp = new ProductSelection(driver);
		String requiredItem = "Sauce Labs Bolt T-Shirt";

		List<String> products = new ArrayList<String>();

		for (int i = 0; i < psp.item_name().size(); i++) {

			products.add(psp.item_name().get(i).getText());

		}
		System.out.println(products);

		Assert.assertTrue(products.contains(requiredItem));

		driver.close();
	}
}
