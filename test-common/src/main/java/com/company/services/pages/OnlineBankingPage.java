package com.company.services.pages;

import com.company.configuration.Driver;
import com.company.services.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static com.company.services.utilities.selenium.PageLoadValidator.waitPageForLoad;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class OnlineBankingPage extends AbstractBasePage {

    private static OnlineBankingPage instance;

    @FindBy(xpath = "//span[@class='headers']")
    private List<WebElement> listOfLinks;

    private OnlineBankingPage(int timeout) {
        super(Driver.getInstance().getDriver(), timeout);
    }

    public List<String> numberOfLinksOnThePage() {
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfLinks));
        return listOfLinks.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void onlineBankingPageLinkClick(String link) {
        wait.until(elementToBeClickable(xpath("//span[text()='" + link + "']"))).click();
    }

    public String getPageTitle() {
        waitPageForLoad();
        return Driver.getInstance().getDriver().getTitle();
    }

    public static OnlineBankingPage onlineBankingPage() {
        if (instance == null) {
            instance = new OnlineBankingPage(Integer.parseInt(ConfigurationReader.getInstance()
                    .getProperty("explicit.wait")));
        }
        return instance;
    }

    public static void refresh() {
        instance = null;
    }
}


//  TODO:
//    public static OnlineBankingPage onlineBankingPage2() {
//        if (instance == null || !instance.driver.equals(Driver.getInstance().getDriver())) {
//            instance = new OnlineBankingPage(Integer.parseInt(ConfigurationReader.getInstance()
//                    .getProperty("explicit.wait")));
//        }
//        return instance;
//    }