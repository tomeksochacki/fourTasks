package pl.amberteam.antycaptcha.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.amberteam.antycaptcha.utils.pageobject.ExerciseThreePageObject;

import java.time.Duration;

public class Task3Test extends TestBase {

    private static final String PAGE_URL = "https://antycaptcha.amberteam.pl/exercises/exercise3?seed=4a51f42a-1563-4a06-8dce-7b92f0a670c0";

    private final ExerciseThreePageObject exerciseThreePageObject;
    private final WebDriverWait wait;

    public Task3Test() {
        super();
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        this.exerciseThreePageObject = new ExerciseThreePageObject(webDriver);
    }

    @Test
    @Order(1)
    public void exerciseThreePageTest() throws InterruptedException {

        mainUtilitiesController.goToURLMethod(PAGE_URL);

        //checking if exercise three page is open
        Assertions.assertTrue(mainUtilitiesController.isExercisePageVisible(exerciseThreePageObject.getExerciseThreePageRecognizer()), "Exercise three page does not open");

        //getting the text
        WebElement element = wait.until(ExpectedConditions.visibilityOf(exerciseThreePageObject.getDownloadedText()));
        String text = element.getAttribute("innerText");

        //retrieving a drop-down menu as a Select object
        Select listOfColors = new Select(webDriver.findElement(By.xpath("//div//select[@name='s13']")));

        //getting the value of a drop-down menu colors and selecting one color
        String lookingForColor = "Anti - Establishment Mint";
        for (WebElement color : listOfColors.getOptions()) {
            if (color.getText().equals(lookingForColor)) {
                listOfColors.selectByVisibleText(text);
                break;
            }
        }

        //checking if the actions are correct
        mainUtilitiesController.clickButton(exerciseThreePageObject.getSolutionCheckButton());

        //checking if the answer field is displayed
        try {
            webDriver.findElement(By.xpath("//pre//code[@class='wrap']")).isDisplayed();
        } catch (Exception e) {
            Assertions.fail("The answer field is not on the page. Application error.");
        }

        //checking the current result with the expected result
        Assertions.assertEquals(exerciseThreePageObject.getExpectedOutcome().getAttribute("innerText"), exerciseThreePageObject.getAnswerAfterSelecting().getAttribute("innerText"), "Solution check test failed.");

    }
}

