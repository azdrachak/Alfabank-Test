package ru.market.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketHomePage {
    private static By electronicsDepartment = By.cssSelector("[data-department='Электроника']");

    public static void openElectronicsDepartment(WebDriver driver) {
        driver.findElement(electronicsDepartment).click();
    }
}
