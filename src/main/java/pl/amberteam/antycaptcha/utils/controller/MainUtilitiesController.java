package pl.amberteam.antycaptcha.utils.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MainUtilitiesController {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainUtilitiesController(final WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /**
     * Method goes to URL provided in method argument.
     *
     * @param urlPath - String argument that indicates url path of required page.
     */
    public void goToURLMethod(final String urlPath) {
        driver.get(urlPath);
    }

    /**
     * Method checks if exercise title is displayed in page.
     *
     * @return true if exercise title is visible.
     */
    public boolean isExercisePageVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    /**
     * Method checks the button name and clicks correct button.
     *
     * @return element.
     */
    public WebElement checkAndClickCorrectButton(WebElement element) {
        String nameOfElement = element.getText();
        switch (nameOfElement) {
            case "B1":
            case "B2":
                clickButton(element);
                break;
            default:
                Assert.fail("Expected button not found");
        }
        return element;
    }

    /**
     * Method clicks button.
     */
    public void clickButton(WebElement button) {
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    /**
     * Method waits for element.
     */
    public void waitForElement(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
