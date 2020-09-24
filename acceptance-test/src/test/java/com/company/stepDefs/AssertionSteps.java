package com.company.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.company.services.pages.HomePage.homePage;
import static com.company.services.pages.OnlineBankingPage.onlineBankingPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionSteps {

    @Then("User should see settings icon")
    public void userShouldSeeSettingsIcon() {
        assertEquals("Settings", homePage().getSettingsIconText(),
                "Setting icon is not present");
    }

    @Then("User should see six header links on online banking page")
    public void userShouldSeeSixHeaderLinksOnOnlineBankingPage(List<String> expectedLinks) {
        assertEquals(expectedLinks, onlineBankingPage().numberOfLinksOnThePage(),
                "links do not match");
    }


    @When("User verifies that page title is {string}")
    public void userVerifiesThatPageTitleIsTitle(String expectedTitle) {
        assertEquals(expectedTitle, onlineBankingPage().getPageTitle(), "Title does not match");
    }
}
