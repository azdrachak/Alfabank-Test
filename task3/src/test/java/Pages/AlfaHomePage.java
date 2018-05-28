package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlfaHomePage {
    private static By jobs = By.xpath("//div/a[text()='Вакансии']");
    private static By jobsNavBar = By.className("nav");

    public static void openJobsPage(WebDriver driver, WebDriverWait wait) {
        driver.findElement(jobs).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(jobsNavBar));
    }
}
