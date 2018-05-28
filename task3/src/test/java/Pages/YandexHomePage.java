package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexHomePage {

    private static By searchInput = By.xpath("//div[@class='container container__search container__line']//input[@class='input__control input__input']");
    private static By searchButton = By.cssSelector(".search2__button button");

    public static void openHomePage(WebDriver driver) {
        driver.navigate().to("https://yandex.ru/");
    }

    public static void performSearch(WebDriver driver, String searchTerm) {
        driver.findElement(searchInput).sendKeys(searchTerm);
        driver.findElement(searchButton).click();
    }
}
