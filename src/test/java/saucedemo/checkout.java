package saucedemo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Cartpage;
import pages.CheckOutInformationpage;
import pages.CheckoutOverviewPage;
import pages.ProductSelection;
import pages.loginpage;
import resources.base;

public class checkout extends base {

	@Test
	public void ValidateProductDetails() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		loginpage lp = new loginpage(driver);
		lp.username().sendKeys("standard_user");
		lp.password().sendKeys("secret_sauce");
		lp.loginButton().click();

		ProductSelection psp = new ProductSelection(driver);
		String requiredItem = "Sauce Labs Bolt T-Shirt";

		for (int i = 0; i < psp.item_name().size(); i++) {
			if (psp.item_name().get(i).getText().equalsIgnoreCase(requiredItem)) {
				psp.addToCart().get(i).click();
				break;
			}

		}
		psp.cart().click();

		Cartpage cp = new Cartpage(driver);
		cp.checkout().click();

		CheckOutInformationpage cip = new CheckOutInformationpage(driver);
		cip.firstname().sendKeys("bhuvana");
		cip.lastname().sendKeys("chandra");
		cip.postalcode().sendKeys("1234");
		cip.continueButton().click();
		CheckoutOverviewPage cov = new CheckoutOverviewPage(driver);
		Assert.assertEquals(requiredItem, cov.item_name().getText());
		cov.finish().click();
		driver.close();
	}
}
