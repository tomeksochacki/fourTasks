package pl.amberteam.antycaptcha.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.amberteam.antycaptcha.utils.Log;
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
        Log.logInfo("Przejście na stronę: https://antycaptcha.amberteam.pl/exercises/exercise1?seed=4a51f42a-1563-4a06-8dce-7b92f0a670c0");

        //checking if exercise one page is open
        Assertions.assertTrue(mainUtilitiesController.isExercisePageVisible(exerciseOnePageObject.getExerciseOnePageRecognizer()), "Exercise one page does not open");
        Log.logInfo("Weryfikacja strony udana");

        //clicking on buttons
        mainUtilitiesController.checkAndClickCorrectButton(exerciseOnePageObject.getButtonOne());
        Log.logInfo("Kliknięcie w przycisk b1");
        if (wait.until(ExpectedConditions.attributeContains(exerciseOnePageObject.getAnswerAfterClicking(), "innerText", "b1")));
        Log.logInfo("Pojawił się wynik b1");
        {
            mainUtilitiesController.checkAndClickCorrectButton(exerciseOnePageObject.getButtonTwo());
            Log.logInfo("Kliknięcie w przycisk b2");
            if (wait.until(ExpectedConditions.attributeContains(exerciseOnePageObject.getAnswerAfterClicking(), "innerText", "b1b2")));
            Log.logInfo("Pojawił się wynik b1b2");
            {
                mainUtilitiesController.checkAndClickCorrectButton(exerciseOnePageObject.getButtonOne());
                Log.logInfo("Kliknięcie w przycisk b1");
                if (wait.until(ExpectedConditions.attributeContains(exerciseOnePageObject.getAnswerAfterClicking(), "innerText", "b1b2b1")));
                Log.logInfo("Pojawił się wynik b1b2b1");
                {
                    //checking if the actions are correct
                    mainUtilitiesController.clickButton(exerciseOnePageObject.getSolutionCheckButton());
                    Log.logInfo("Kliknięcie w przycisk sprawdzający wynik");
                }
            }
        }

        //checking the current result with the expected result
        Assertions.assertEquals(exerciseOnePageObject.getExpectedOutcome().getAttribute("innerText"), exerciseOnePageObject.getAnswerAfterClicking().getAttribute("innerText"), "Solution check test failed.");
        Log.logInfo("Aktualny wynik zgodny z oczekiwanym");
        Log.logInfo("Zakończenie testu powodzeniem");
    }
}
