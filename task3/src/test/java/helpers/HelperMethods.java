package helpers;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelperMethods {
    public static String tex2string(String...args) {
        StringBuilder builder = new StringBuilder();
        for (String s : args) {
            builder.append(s);
            builder.append(System.getProperty("line.separator"));
        }
        return builder.toString();
    }

    public static void string2file(WebDriver driver, String input, String searchEngine, String path) throws IOException {
        String filename = path + "\\" + createFileName(driver, searchEngine);
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(input);
        writer.close();
    }

    private static String createFileName(WebDriver driver, String searchEngine) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);

        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName();

        return dateTime + "-" + browserName +"-" + searchEngine + ".txt";
    }
}
