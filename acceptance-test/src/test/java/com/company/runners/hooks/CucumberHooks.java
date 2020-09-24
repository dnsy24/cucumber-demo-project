package com.company.runners.hooks;

import com.company.configuration.Driver;
import com.company.configuration.WebDriverFactory;
import com.company.services.attachments.Attach;
import com.company.services.utilities.owner.ConfigurationProvider;
import com.company.services.utilities.ConfigurationReader;
import io.cucumber.java.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class CucumberHooks {

    private static int failedTests = 0;
    private static int passedTests = 0;
    private static int count = 0;

    private static final Logger LOGGER = Logger.getLogger(CucumberHooks.class);

    @Before
    public void setUpScenario() {
        String browser1 = ConfigurationProvider.getInstance().getConfiguration().browserName();
        System.out.println("Browser name from owner: " + browser1);

        PropertyConfigurator.configure("src/test/resources/log4j.properties");
        LOGGER.info("::: Starting automation :::");
        String browser = ConfigurationReader.getInstance().getProperty("browser.name");
        String url = ConfigurationReader.getInstance().getProperty("url");
        Driver.getInstance().setDriver(WebDriverFactory.getInstance()
                .createDriver(browser));
        LOGGER.info("Browser: " + browser);
        LOGGER.info("url: " + url);
        Driver.getInstance().getDriver().manage().window().maximize();
    }


    @After
    public void takeScreenShotIfFailed(Scenario scenario) {
        Attach.screenshot().attachScreenShotIfFailed(scenario);
    }

    @After
    public void logCountOfTest(Scenario scenario) {
        count++;
        if (scenario.isFailed()) {
            failedTests++;
        } else {
            passedTests++;
        }
        LOGGER.info("::: Number of completed tests: " + count + " :::");
        LOGGER.info("Status of test " + count + " is: " + scenario.getStatus());
        LOGGER.info("Passed tests: " + passedTests + ", Failed tests: " + failedTests);
    }

    @After
    public void tearDownScenario() {
        LOGGER.info("::: Ending automation :::");
        Driver.getInstance().getDriver().close();
    }
}
