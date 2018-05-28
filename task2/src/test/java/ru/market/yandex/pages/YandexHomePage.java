package ru.market.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexHomePage {
    private static By marketLink = By.cssSelector("[data-id='market']");

    public static void openMarket(WebDriver driver) {
        driver.findElement(marketLink).click();
    }

    public static void openHomePage(WebDriver driver) {
        driver.navigate().to("https://yandex.ru/");
    }
}
