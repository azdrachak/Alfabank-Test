package ru.market.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketProductPage {
    private static By productTitle = By.cssSelector(".n-title__text");

    public static String getProductName(WebDriver driver) {
        return driver.findElement(By.cssSelector(".n-title__text")).getText();
    }
}
