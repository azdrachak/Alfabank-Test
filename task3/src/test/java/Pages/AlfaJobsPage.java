package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlfaJobsPage {
    private static By aboutLink = By.xpath("//a[@href='/about/']");
    private static By aboutJobsPageTitle = By.xpath("//h1[text()='О работе в банке']");
    private static By promoTitle = By.cssSelector("div.message");
    private static By promoText = By.cssSelector("div.info");

    public static void openAboutJob(WebDriver driver, WebDriverWait wait) {
        driver.findElement(aboutLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutJobsPageTitle));
    }

    public static String getPromoTitle(WebDriver driver) {
        return driver.findElement(promoTitle).getText();
    }

    public static String getPromoText(WebDriver driver) {
        return driver.findElement(promoText).getText();
    }
}
