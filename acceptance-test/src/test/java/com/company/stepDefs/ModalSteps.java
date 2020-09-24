package com.company.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.util.List;

import static com.company.services.pages.HomePage.homePage;
import static com.company.services.pages.LandingPage.landingPage;
import static com.company.services.pages.OnlineBankingPage.onlineBankingPage;


public class ModalSteps {


    @When("User clicks sign in button")
    public void userHitsSignInButton() {
        landingPage().signInButtonClick();
    }

    @When("User enters valid email and password")
    public void userEntersValidEmailAndPassword(DataTable userData) {
        List<String> data = userData.row(1);
        landingPage().login(data.get(0), data.get(1));
    }

//     TODO: не работает!!!
//    @When("User enters valid credentials")
//    public void userEntersValidEmailAndPassword(List<User> userData) {
//        User user = userData.get(0);
//        System.out.println("user: " + user);
//        landingPage().fillInEmailField(user.getEmail());
//    }

    @When("User go to Home page")
    public void userGoToHomePage() {
        landingPage().toHomePage();
    }

    @When("User clicks online banking header link")
    public void userClicksOnlineBankingHeaderLink(String headerLink) {
        homePage().headerLinkClick(headerLink);
    }

    @When("User clicks {string}")
    public void userClicksLink(String string) {
        onlineBankingPage().onlineBankingPageLinkClick(string);
    }
}










