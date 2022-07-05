package pl.amberteam.antycaptcha.utils.controller;

import org.openqa.selenium.WebDriver;

public class MainUtilitiesController {
    private final WebDriver driver;

    public MainUtilitiesController(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method goes to URL provided in method argument.
     *
     * @param urlPath - String argument that indicates url path of required page.
     */
    public void goToURLMethod(final String urlPath) {
        driver.get(urlPath);
    }
}
