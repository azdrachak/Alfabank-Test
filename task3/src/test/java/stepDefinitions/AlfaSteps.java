package stepDefinitions;

import Pages.AlfaHomePage;
import Pages.AlfaJobsPage;
import Pages.YandexHomePage;
import Pages.YandexSearchResults;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.HelperMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class AlfaSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Given("^I am on the Yandex home page$")
    public void iAmOnTheYandexHomePage() {
        YandexHomePage.openHomePage(driver);
    }

    @When("^I search Альфа-Банк$")
    public void iSearchAlfaBank() throws Throwable {
        YandexHomePage.performSearch(driver, "Альфа-Банк");

    }

    @And("^Click link to Alfa-Bank$")
    public void clickLinkToAlfaBank() {
        YandexSearchResults.openAlfaLink(driver, wait);
    }

    @And("^Click link to Вакансии$")
    public void clickLinkToJobs() {
        AlfaHomePage.openJobsPage(driver, wait);
    }

    @And("^Open о работе в банке section$")
    public void openAboutJobsSection() {
        AlfaJobsPage.openAboutJob(driver, wait);
    }

    @Then("^Benefits text is saved ito the file$")
    public void benefitsTextIsSavedItoTheFile() throws IOException {
        String jobsText = HelperMethods.tex2string(AlfaJobsPage.getPromoTitle(driver), AlfaJobsPage.getPromoText(driver));
        HelperMethods.string2file(driver, jobsText, "Yandex", "results");
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
