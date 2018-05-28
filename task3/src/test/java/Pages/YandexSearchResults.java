package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class YandexSearchResults {
    private static By alfaLink = By.xpath("//h2/a[@href='https://AlfaBank.ru/']");
    private static By alfaPage = By.id("alfa");

    public static void openAlfaLink(WebDriver driver, WebDriverWait wait) {
        driver.findElement(alfaLink).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        String yandexWindowHandler = driver.getWindowHandle();
        handles.remove(yandexWindowHandler);
        String alfaWindowHandle = handles.get(0);
        driver.switchTo().window(alfaWindowHandle);
        wait.until(ExpectedConditions.visibilityOfElementLocated(alfaPage));
    }
}
