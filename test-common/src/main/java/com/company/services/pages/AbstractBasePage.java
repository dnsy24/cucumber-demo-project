package com.company.services.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected AbstractBasePage(WebDriver driver, int timeout) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);
        PageFactory.initElements(driver, this);
    }
}

