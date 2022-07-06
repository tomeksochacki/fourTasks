package pl.amberteam.antycaptcha.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.amberteam.antycaptcha.utils.pageobject.ExerciseOnePageObject;
import pl.amberteam.antycaptcha.utils.pageobject.ExerciseTwoPageObject;

import java.time.Duration;

public class Task2Test extends TestBase{

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
        String text = exerciseTwoPageObject.getToEnterText().getAttribute("innerText");

        //entering text
        exerciseTwoPageObject.getToTextInput().clear();
        exerciseTwoPageObject.getToTextInput().sendKeys(text);

        //clicking b1 button
        exerciseTwoPageObject.getButtonOne().click();

        //checking if the actions are correct
        exerciseTwoPageObject.clickButton(exerciseTwoPageObject.getSolutionCheckButton());

/*

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
*/

    }
}
