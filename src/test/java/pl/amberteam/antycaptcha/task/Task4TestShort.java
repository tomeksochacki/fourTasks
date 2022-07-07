package pl.amberteam.antycaptcha.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.amberteam.antycaptcha.utils.pageobject.ExerciseFourPageObject;

import java.time.Duration;

public class Task4TestShort extends TestBase {
    private static final String PAGE_URL = "https://antycaptcha.amberteam.pl/exercises/exercise4?seed=4a51f42a-1563-4a06-8dce-7b92f0a670c0";

    private final ExerciseFourPageObject exerciseFourPageObject;
    private final WebDriverWait wait;

    public Task4TestShort() {
        super();
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        this.exerciseFourPageObject = new ExerciseFourPageObject(webDriver);
    }

    @Test
    @Order(1)
    public void exerciseFourPageTest() {
        mainUtilitiesController.goToURLMethod(PAGE_URL);

        //checking if exercise one page is open
        Assertions.assertTrue(mainUtilitiesController.isExercisePageVisible(exerciseFourPageObject.getExerciseFourPageRecognizer()), "Exercise four page does not open");

        //select group 0
        mainUtilitiesController.selectElement(exerciseFourPageObject.getCheckboxForZeroGroup());
        //select group 1
        mainUtilitiesController.selectElement(exerciseFourPageObject.getCheckboxForOneGroup());
        //select group 2
        mainUtilitiesController.selectElement(exerciseFourPageObject.getCheckboxForTwoGroup());
        //select group 3
        mainUtilitiesController.selectElement(exerciseFourPageObject.getCheckboxForThreeGroup());

        //checking if the actions are correct
        mainUtilitiesController.clickButton(exerciseFourPageObject.getSolutionCheckButton());

        //checking if the answer field is displayed
        try {
            webDriver.findElement(By.xpath("//pre//code[@class='wrap']")).isDisplayed();
        } catch (Exception e) {
            Assertions.fail("The answer field is not on the page. Application error.");
        }

        //checking the current result with the expected result
        Assertions.assertEquals(exerciseFourPageObject.getExpectedOutcome().getAttribute("innerText"), exerciseFourPageObject.getAnswerAfterSelecting().getAttribute("innerText"), "Solution check test failed. The result is not as expected.");

    }
}
