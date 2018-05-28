package ru.market.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Filters {
    private static By maxPrice = By.cssSelector("#glpriceto");
    private static By minPrice = By.cssSelector("#glpricefrom");
    private static By updateVale = By.xpath("//div[@class='preloadable__preloader preloadable__preloader_visibility_visible preloadable__paranja']");
    private static String brandCheckboxXpath = "//div[@data-reactid]/span[text()='%s']";

    public static void setMaxPrice(WebDriver driver, WebDriverWait waitResultsRefresh, String price) {
        driver.findElement(maxPrice).sendKeys(price);
        waitResultsRefresh.until(ExpectedConditions.visibilityOfElementLocated(updateVale));
        waitResultsRefresh.until(ExpectedConditions.invisibilityOfElementLocated(updateVale));
    }

    public static void setMinPrice(WebDriver driver, WebDriverWait waitResultsRefresh, String price) {
        driver.findElement(minPrice).sendKeys(price);
        waitResultsRefresh.until(ExpectedConditions.visibilityOfElementLocated(updateVale));
        waitResultsRefresh.until(ExpectedConditions.invisibilityOfElementLocated(updateVale));
    }

    public static void filterByBrand(WebDriver driver, WebDriverWait waitResultsRefresh, String brand) {
        String brandCheckbox = String.format(brandCheckboxXpath, brand);
        By brandCheckboxLocator = By.xpath(brandCheckbox);
        driver.findElement(brandCheckboxLocator).click();
        waitResultsRefresh.until(ExpectedConditions.invisibilityOfElementLocated(updateVale));
    }
}
