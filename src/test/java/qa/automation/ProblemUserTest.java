package qa.automation;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProblemUserPage;
import pages.ProductsPage;

public class ProblemUserTest extends TestUtil {

    @Test
    public void AddItemToTheCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProblemUserPage problemUserPage = new ProblemUserPage(driver);
        ProductsPage productsPage = loginPage.login("problem_user", "secret_sauce");
        problemUserPage.addItemToTheCar("backpack");

        Assert.assertEquals(problemUserPage.getItemsInTheCart(), 1, "We have only one item in the cart.");

        problemUserPage.removeItemFromTheCart("backpack");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(problemUserPage.getItemsInTheCart(), 0, "The cart is empty.");
        System.out.println("I will be executed");

        softAssert.assertAll();
    }
}

