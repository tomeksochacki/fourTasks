package pl.amberteam.antycaptcha.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.amberteam.antycaptcha.utils.pageobject.ExerciseOnePageObjects;

import java.time.Duration;

public class Task1Test extends TestBase {

    private static final String PAGE_URL = "https://antycaptcha.amberteam.pl/exercises/exercise1?seed=4a51f42a-1563-4a06-8dce-7b92f0a670c0";

    private final ExerciseOnePageObjects exerciseOnePageObjects;
    private final WebDriverWait wait;

    public Task1Test() {
        super();
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        this.exerciseOnePageObjects = new ExerciseOnePageObjects(webDriver);
    }

    @Test
    @Order(1)
    public void openExerciseOnePageTest() {
        mainUtilitiesController.goToURLMethod(PAGE_URL);

        //checking if exercise one page is open
        Assertions.assertTrue(exerciseOnePageObjects.isExerciseOnePageVisible(), "Exercise one page does not open");

        //clicking on buttons
        exerciseOnePageObjects.checkAndClickCorrectButton(exerciseOnePageObjects.getButtonOne());
        exerciseOnePageObjects.checkAndClickCorrectButton(exerciseOnePageObjects.getButtonTwo());
        exerciseOnePageObjects.checkAndClickCorrectButton(exerciseOnePageObjects.getButtonOne());

        //checking if the actions are correct
        exerciseOnePageObjects.clickButton(exerciseOnePageObjects.getSolutionCheckButton());

        //exerciseOnePageObjects.waitForElement();
        try {
            /*WebElement message = wait.until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver d) {
                    return d.findElement(By.xpath("//pre//code[@class='wrap']"));
                }
            });*/

            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath("//pre//code[@class='wrap']")).getAttribute("innerText").contains("OK. Good answer");
            }});

            //Assertions.assertEquals("OK. Good answer", message.getText(), "Solution check test failed.");
        } finally {

        }


        //"OK. Good answerr"
    }
}
