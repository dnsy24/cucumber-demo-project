package com.company.configuration;

import org.openqa.selenium.remote.BrowserType;

public enum BrowserName {

    CHROME(BrowserType.CHROME),
    FIREFOX(BrowserType.FIREFOX),
    SAFARI(BrowserType.SAFARI);

    private String browserName;

    BrowserName(String browserName) {
        this.browserName = browserName;
    }

    public static BrowserName getBrowserName(String value) {
        for (BrowserName browserName : values()) {
            if (browserName.browserName.equalsIgnoreCase(value)) {
                return browserName;
            }
        }
        throw new IllegalArgumentException(String.format("Unknown browser '%s'", value));
    }
}
