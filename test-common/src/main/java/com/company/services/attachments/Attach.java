package com.company.services.attachments;

import com.company.configuration.Driver;
import com.company.services.attachments.implementations.Attachments;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Arrays;


public class Attach implements Attachments {

    private static Attach instance;

    public void attachScreenShotIfFailed(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) Driver.getInstance().getDriver())
                .getScreenshotAs(OutputType.BYTES);
        System.out.println(Arrays.toString(screenshot));
        scenario.attach(screenshot, "image/png", scenario.getName());
    }

    public static Attach screenshot() {
        if (instance == null)
            instance = new Attach();
        return instance;
    }

    public static void refresh() {
        instance = null;
    }
}




