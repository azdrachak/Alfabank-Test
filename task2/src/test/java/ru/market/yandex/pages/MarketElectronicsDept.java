package ru.market.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketElectronicsDept {
    private static By phones = By.xpath("//div[@class='catalog-menu__list']/a[text()='Мобильные телефоны']");
    private static By headsets = By.xpath("//div[@class='catalog-menu__list']/a[text()='Наушники и Bluetooth-гарнитуры']");

    public static void openPhonesPage(WebDriver driver) {
        driver.findElement(phones).click();
    }

    public static void openHeadsetsPage(WebDriver driver) {
        driver.findElement(headsets).click();
    }
}
