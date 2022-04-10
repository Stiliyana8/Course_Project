package qa.automation;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckOutItemTest extends TestUtil {

    @Test
    public void successfulCheckOutItem() {

            LoginPage loginPage = new LoginPage(driver);
            ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
            productsPage.addItemToTheCart("backpack");

            WebElement shoppingCart = driver.findElement(By.cssSelector("[class='shopping_cart_link']"));
            shoppingCart.click();
            Assert.assertEquals(productsPage.getItemsInTheCart(), 1, "We have one item in the cart.");

            WebElement checkOut = driver.findElement(By.id("checkout"));
            checkOut.click();

            WebElement firstName = driver.findElement(By.id("first-name"));
            firstName.click();
            firstName.sendKeys("Stiliyana");

            WebElement lastName = driver.findElement(By.id("last-name"));
            lastName.click();
            lastName.sendKeys("Yaneva");

            WebElement zipCode = driver.findElement(By.id("postal-code"));
            zipCode.click();
            zipCode.sendKeys("8000");

            WebElement nextstepContinue = driver.findElement(By.id("continue"));
            nextstepContinue.click();

            WebElement finishBtn = driver.findElement(By.id("finish"));
            finishBtn.click();

            WebElement backToProductsBtn = driver.findElement(By.id("back-to-products"));
            Assert.assertTrue(backToProductsBtn.isDisplayed(), "This shall be visible after successful check out");
        }
}