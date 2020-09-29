package com.company.runners.hooks;

import com.company.configuration.Driver;
import com.company.configuration.WebDriverFactory;
import com.company.services.attachments.Attach;
import com.company.services.pages.HomePage;
import com.company.services.pages.LandingPage;
import com.company.services.pages.OnlineBankingPage;
import com.company.services.utilities.owner.ConfigurationProvider;
import com.company.services.utilities.ConfigurationReader;
import io.cucumber.java.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.company.services.attachments.Attach.refresh;
import static com.company.services.attachments.Attach.screenshot;


public class CucumberHooks {

    private static int failedTests = 0;
    private static int passedTests = 0;
    private static int count = 0;

    private static final Logger LOGGER = Logger.getLogger(CucumberHooks.class);

    @Before
    public void setUpScenario() {
//        PropertyConfigurator.configure(this.getClass().getClassLoader().getResourceAsStream("log/log4j.properties"));
        LOGGER.info("::: Starting automation :::");
//        String browser = ConfigurationReader.getInstance().getProperty("browser.name");
        String browser = ConfigurationProvider.getInstance().getConfiguration().browserName();
//        String url = ConfigurationReader.getInstance().getProperty("url");
        String url = ConfigurationProvider.getInstance().getConfiguration().siteUrl();
        Driver.getInstance().setDriver(WebDriverFactory.getInstance()
                .createDriver(browser));
        LOGGER.info("Browser: " + browser);
        LOGGER.info("url: " + url);
        Driver.getInstance().getDriver().manage().window().maximize();
    }


    @After
    public void takeScreenShotIfFailed(Scenario scenario) {
        if (scenario.isFailed()) {
//            byte[] screenshot = ((TakesScreenshot) Driver.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", scenario.getName());
            screenshot().attachScreenShotIfFailed(scenario);
            refresh();
        }
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
        LandingPage.refresh();
        HomePage.refresh();
        OnlineBankingPage.refresh();
        LOGGER.info("::: Ending automation :::");
        Driver.getInstance().getDriver().close();
    }
}
