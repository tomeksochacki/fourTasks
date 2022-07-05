/*
package pl.amberteam.antycaptcha.utils.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pl.amberteam.antycaptcha.utils.pageobject.ExerciseOnePageObjects;

import java.time.Duration;

public class ExerciseOneController {
    private static final long DEFAULT_S_TIMEOUT = 20;

    private final ExerciseOnePageObjects exerciseOnePageObjects;
    private final WebDriverWait wait;

    public ExerciseOneController(final WebDriver driver) {
        this.exerciseOnePageObjects = new ExerciseOnePageObjects(driver, webDriverWait);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_S_TIMEOUT));
    }


    */
/**
     * Method checks if exercise one title is displayed in page.
     *
     * @return true if wikipedia logo is visible.
     *//*

    public boolean isExerciseOnePageVisible() {
        wait.until(ExpectedConditions.visibilityOf(exerciseOnePageObjects.getExerciseOnePageRecognizer()));
        return exerciseOnePageObjects.getExerciseOnePageRecognizer().isDisplayed();
    }

    */
/**
     * Method checks the button name and clicks correct button.
     *//*

    public void checkAndClickCorrectButton(WebElement element) {
        String nameOfElement = element.getText();
        switch (nameOfElement) {
            case "B1":
            case "B2":
                clickButton(element);
                break;
            default:
                Assert.fail("Expected button not found");
        }
    }

    */
/**
     * Method clicks button.
     *//*

    public void clickButton(WebElement button) {
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    public void waitForElement(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//pre//code[@class='wrap']")));
    }








    */
/* *//*
*/
/**
     * Method prints name of all accessible languages form wikipedia page. If name of language equals provided String argument, method will print href related
     * of language's child object.
     *
     * @param expectedLanguage - the name of the language for which we want to get the URL.
     * @return String with URL related to language with name indicated in method argument.
     *//*
*/
/*
    public String printAllLanguagesAndFindURLOfChosenLanguage(final String expectedLanguage) {
        String url = "";
        wait.until(ExpectedConditions.visibilityOf(wikipediaPageObjects.getLanguagesList().get(0)));
        for (WebElement language : wikipediaPageObjects.getLanguagesList()) {
            String languageName = language.getText();
            System.out.println(languageName);
            if (languageName.equals(expectedLanguage)) {
                url = wikipediaPageObjects.getSubElementOfLanguageWebElement(languageName).getAttribute("href");
                System.out.println(url);
            }
        }
        return url;
    }*//*

}
*/
