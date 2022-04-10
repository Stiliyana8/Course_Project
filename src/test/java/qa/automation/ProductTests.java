package qa.automation;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductTests extends TestUtil {

    @Test
    public void addItemsToTheCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToTheCart("backpack");
        productsPage.addItemToTheCart("bolt-t-shirt");

        productsPage.getItemsInTheCart();

      Assert.assertEquals(productsPage.getItemsInTheCart(), 2, "We have two items in the cart.");
    }
}
