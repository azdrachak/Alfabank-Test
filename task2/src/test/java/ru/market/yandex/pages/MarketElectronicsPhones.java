package ru.market.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketElectronicsPhones {
    private static By searchResults = By.xpath("//div[@class='n-snippet-cell2__header']");
    private static By searchResultsName = By.xpath("//div[@class='n-snippet-cell2__header']/div[@class='n-snippet-cell2__title']");

    public static String getNthResultName(WebDriver driver, int index) {
        return driver.findElements(searchResultsName).get(index).getText();
    }

    public static void openNthResult(WebDriver driver, int index) {
        driver.findElements(searchResults).get(index).click();
    }
}
