package com.company.services.utilities.selenium;

import com.company.configuration.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageLoadValidator {

    public static void waitPageForLoad() {
        new WebDriverWait(Driver.getInstance().getDriver(), 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
