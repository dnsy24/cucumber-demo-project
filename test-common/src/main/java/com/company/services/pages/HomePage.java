package com.company.services.pages;

import com.company.configuration.Driver;
import com.company.services.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends AbstractBasePage {

    private static HomePage instance;

    @FindBy(className = "dropdown-toggle")
    private WebElement settingsIcon;

    private HomePage(int timeout) {
        super(Driver.getInstance().getDriver(), timeout);
    }

    public String getSettingsIconText() {
        return wait.until(visibilityOf(settingsIcon)).getText();
    }

    public void headerLinkClick(String headerLink) {
        wait.until(elementToBeClickable(xpath("//strong[text()='" + headerLink + "']"))).click();
    }

    public static HomePage homePage() {
        if (instance == null) {
            instance = new HomePage(Integer.parseInt(ConfigurationReader
                    .getInstance().getProperty("explicit.wait")));
        }
        return instance;
    }

    public static void refresh() {
        instance = null;
    }
}
