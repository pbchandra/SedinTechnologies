package saucedemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductIndividualPage;
import pages.ProductSelection;
import pages.loginpage;
import resources.base;
public class PriceComparisionTest extends base {


	

	@Test
	public void priceComparision() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		loginpage lp = new loginpage(driver);
		lp.username().sendKeys("standard_user");
		lp.password().sendKeys("secret_sauce");
		lp.loginButton().click();

		ProductSelection psp = new ProductSelection(driver);

		List<String> prices = new ArrayList<String>();
		List<Float> integer_prices = new ArrayList<Float>();
		for (int i = 0; i < psp.item_name().size(); i++) {

			prices.add(psp.item_price().get(i).getText());
			String temp = psp.item_price().get(i).getText();
			integer_prices.add(Float.parseFloat(temp.substring(1,temp.length())));

		}
		System.out.println(prices);
		System.out.println(integer_prices);
		for (int i = 0; i < psp.item_name().size(); i++) {
			psp.item_name().get(i).click();

			ProductIndividualPage pip = new ProductIndividualPage(driver);
			Assert.assertEquals(pip.item_price().getText(), prices.get(i));

			driver.navigate().back();
		}

		driver.close();

	}

	

}
