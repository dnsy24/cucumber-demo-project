package com.company.configuration;

import org.openqa.selenium.WebDriver;

public final class Driver {
    private WebDriver driver;

    private Driver() {

    }

    private static class Holder {
        private static final Driver INSTANCE = create();
    }

    private static Driver create() {
        return new Driver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static Driver getInstance() {
        return Holder.INSTANCE;
    }
}
