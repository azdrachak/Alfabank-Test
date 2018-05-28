package ru.market.yandex.stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.market.yandex.pages.*;

public class StepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;

    private String productNameFromSearch;
    private String productNameFromProductPage;

    @Before
    public void start() {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    @Given("^I open Yandex home page$")
    public void iOpenYandexHomePage() {
        YandexHomePage.openHomePage(driver);
    }

    @When("^I click Market link$")
    public void iClickMarketLink() {
        YandexHomePage.openMarket(driver);
    }

    @And("^Open Electronics department$")
    public void openElectronicsDepartment() {
        MarketHomePage.openElectronicsDepartment(driver);
    }

    @And("^Open Mobile Phone page$")
    public void openMobilePhonePage() {
        MarketElectronicsDept.openPhonesPage(driver);
    }

    @And("^Set filter to \"([^\"]*)\"")
    public void setFilterToSamsung(String brandName) {
        Filters.filterByBrand(driver, wait, brandName);
    }

    @And("^Set max price to \"([^\"]*)\"$")
    public void setMaxPriceTo(String price) {
        Filters.setMaxPrice(driver, wait, price);
        productNameFromSearch = MarketElectronicsPhones.getNthResultName(driver, 0);
    }

    @And("^Open first search result$")
    public void openFirstSearchResult() {
        MarketElectronicsPhones.openNthResult(driver, 0);
        productNameFromProductPage = MarketProductPage.getProductName(driver);
    }

    @Then("^Product name from search is the same as From Product page$")
    public void productNameFromSerchIsTheSameAsFromProductPage() {
        Assert.assertEquals(productNameFromProductPage, productNameFromSearch);
    }

    @And("^Open Headsets page$")
    public void openHeadsetsPage() {
        MarketElectronicsDept.openHeadsetsPage(driver);
    }

    @And("^Set min price to \"([^\"]*)\"$")
    public void setMinPriceTo(String price) {
       Filters.setMinPrice(driver, wait, "17000");
    }
}
