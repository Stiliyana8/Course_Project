package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;

public class LoginPage {
    protected WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(css = "[placeholder=Password]")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[text()='Epic sadface: Username and password do not match any user in this service']")
    private WebElement genericErrorMessage;

    @FindBy(xpath = "the other locator")
    private WebElement usernameEmptyErrorMessage;

    @FindBy(xpath = "the other locator")
    private WebElement passwordEmptyErrorMessage;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductsPage login(String username, String password) {

        FluentWait fluentWait = new FluentWait<>(driver)
                .withTimeout((Duration.ofSeconds(20)))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.click();
        userNameInput.sendKeys(username);

        fluentWait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.click();
        passwordInput.sendKeys(password);

        fluentWait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();

        return new ProductsPage(driver);
    }

    public void tryToLogin (String username, String password){
        FluentWait fluentWait = new FluentWait<>(driver)
                .withTimeout((Duration.ofSeconds(20)))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.click();
        userNameInput.sendKeys(username);

        fluentWait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.click();
        passwordInput.sendKeys(password);

        fluentWait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }

    public boolean isLoginErrorMessageShown() {
        try {
            return genericErrorMessage.isDisplayed() || usernameEmptyErrorMessage.isDisplayed() || passwordEmptyErrorMessage.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
}