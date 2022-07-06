package pl.amberteam.antycaptcha.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.amberteam.antycaptcha.utils.pageobject.ExerciseTwoPageObject;

import java.time.Duration;

public class Task2Test extends TestBase {

    private static final String PAGE_URL = "https://antycaptcha.amberteam.pl/exercises/exercise2?seed=4a51f42a-1563-4a06-8dce-7b92f0a670c0";

    private final ExerciseTwoPageObject exerciseTwoPageObject;
    private final WebDriverWait wait;

    public Task2Test() {
        super();
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        this.exerciseTwoPageObject = new ExerciseTwoPageObject(webDriver);
    }

    @Test
    @Order(1)
    public void exerciseTwoPageTest() {

        mainUtilitiesController.goToURLMethod(PAGE_URL);

        //checking if exercise two page is open
        Assertions.assertTrue(exerciseTwoPageObject.isExerciseTwoPageVisible(), "Exercise two page does not open");

        //getting the text
        WebElement element = wait.until(ExpectedConditions.visibilityOf(exerciseTwoPageObject.getDownloadedText()));
        String text = element.getAttribute("innerText");

        //entering text
        exerciseTwoPageObject.getToTextInput().clear();
        exerciseTwoPageObject.getToTextInput().sendKeys(text);

        //clicking b1 button
        exerciseTwoPageObject.getButtonOne().click();

        //checking if the actions are correct
        exerciseTwoPageObject.clickButton(exerciseTwoPageObject.getSolutionCheckButton());

        //checking if the answer field is displayed
        try {
            webDriver.findElement(By.xpath("//pre//code[@class='wrap']")).isDisplayed();
        } catch (Exception e) {
            Assertions.fail("The answer field is not on the page. Application error.");
        }

        //checking the current result with the expected result
        Assertions.assertEquals(exerciseTwoPageObject.getExpectedOutcome().getAttribute("innerText"), exerciseTwoPageObject.getAnswerAfterClicking().getAttribute("innerText"), "Solution check test failed.");

    }
}
