package pl.amberteam.antycaptcha.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.amberteam.antycaptcha.utils.pageobject.ExerciseFourPageObject;

import java.time.Duration;

public class Task4Test extends TestBase {
    private static final String PAGE_URL = "https://antycaptcha.amberteam.pl/exercises/exercise4?seed=4a51f42a-1563-4a06-8dce-7b92f0a670c0";

    private final ExerciseFourPageObject exerciseFourPageObject;
    private final WebDriverWait wait;

    public Task4Test() {
        super();
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        this.exerciseFourPageObject = new ExerciseFourPageObject(webDriver);
    }

    @Test
    @Order(1)
    public void exerciseOnePageTest() {
        mainUtilitiesController.goToURLMethod(PAGE_URL);

        //checking if exercise one page is open
        Assertions.assertTrue(mainUtilitiesController.isExercisePageVisible(exerciseFourPageObject.getExerciseFourPageRecognizer()), "Exercise four page does not open");

        //TODO
    }
}
