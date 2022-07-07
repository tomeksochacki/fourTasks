package pl.amberteam.antycaptcha;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public WebDriver initDriver() {
        WebDriverManager.getInstance(ChromeDriver.class).driverVersion("102.0.5005.63").setup();
        WebDriver webDriver = new ChromeDriver();
        tlDriver.set(webDriver);
        return getDriver();
    }
}
