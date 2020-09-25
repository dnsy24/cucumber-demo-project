package com.company.services.pages;

import com.company.configuration.Driver;
import com.company.services.utilities.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LandingPage extends AbstractBasePage {

    private static LandingPage instance;

    @FindBy(id = "signin_button")
    private WebElement signInButton;

    @FindBy(id = "user_login")
    private WebElement loginField;

    @FindBy(id = "user_password")
    private WebElement passwordField;

    @FindBy(name = "submit")
    private WebElement signInLogin;

    @FindBy(partialLinkText = "Zero Bank")
    private WebElement zeroBankLogo;


    private LandingPage(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public void signInButtonClick() {
        wait.until(elementToBeClickable(signInButton)).click();
    }

    public void login(String email, String password) {
        wait.until(visibilityOf(loginField)).sendKeys(email);
        wait.until(visibilityOf(passwordField)).sendKeys(password);
        signInLogin.click();
    }

    public void toHomePage() {
        wait.until(elementToBeClickable(zeroBankLogo)).click();
    }

    public static LandingPage landingPage() {
        if (instance == null) {
            instance = new LandingPage(Driver.getInstance().getDriver(), Integer.parseInt(ConfigurationReader
                    .getInstance().getProperty("explicit.wait")));
        }
        return instance;
    }

    public static void refresh() {
        instance = null;
    }
}
