package com.company.stepDefs;

import com.company.configuration.Driver;
import com.company.services.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;

public class ActionSteps {

    @Given("User on start page")
    public void userOnStartPage() {
        Driver.getInstance().getDriver().get(ConfigurationReader.getInstance().getProperty("url"));
    }
}
