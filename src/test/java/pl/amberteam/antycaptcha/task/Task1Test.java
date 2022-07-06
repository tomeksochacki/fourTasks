package pl.amberteam.antycaptcha.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.amberteam.antycaptcha.utils.pageobject.ExerciseOnePageObject;

import java.time.Duration;

public class Task1Test extends TestBase {

    private static final String PAGE_URL = "https://antycaptcha.amberteam.pl/exercises/exercise1?seed=4a51f42a-1563-4a06-8dce-7b92f0a670c0";

    private final ExerciseOnePageObject exerciseOnePageObject;
    private final WebDriverWait wait;

    public Task1Test() {
        super();
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        this.exerciseOnePageObject = new ExerciseOnePageObject(webDriver);
    }

    @Test
    @Order(1)
    public void exerciseOnePageTest() {
        mainUtilitiesController.goToURLMethod(PAGE_URL);

        //checking if exercise one page is open
        Assertions.assertTrue(exerciseOnePageObject.isExerciseOnePageVisible(), "Exercise one page does not open");

        //clicking on buttons
        exerciseOnePageObject.checkAndClickCorrectButton(exerciseOnePageObject.getButtonOne());
        if (wait.until(ExpectedConditions.attributeContains(exerciseOnePageObject.getAnswerAfterClicking(), "innerText", "b1")))
            ;
        {
            exerciseOnePageObject.checkAndClickCorrectButton(exerciseOnePageObject.getButtonTwo());
            if (wait.until(ExpectedConditions.attributeContains(exerciseOnePageObject.getAnswerAfterClicking(), "innerText", "b1b2")))
                ;
            {
                exerciseOnePageObject.checkAndClickCorrectButton(exerciseOnePageObject.getButtonOne());
                if (wait.until(ExpectedConditions.attributeContains(exerciseOnePageObject.getAnswerAfterClicking(), "innerText", "b1b2b1")))
                    ;
                {
                    //checking if the actions are correct
                    exerciseOnePageObject.clickButton(exerciseOnePageObject.getSolutionCheckButton());
                }
            }
        }

        //checking the current result with the expected result
        Assertions.assertEquals(exerciseOnePageObject.getExpectedOutcome().getAttribute("innerText"), exerciseOnePageObject.getAnswerAfterClicking().getAttribute("innerText"), "Solution check test failed.");

    }
}
