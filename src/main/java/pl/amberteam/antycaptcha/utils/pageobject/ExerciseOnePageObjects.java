package pl.amberteam.antycaptcha.utils.pageobject;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

@Data
public class ExerciseOnePageObjects {

    @FindBy(xpath = "//h1[contains(text(),'Exercise 1 - Three buttons')]")
    private WebElement exerciseOnePageRecognizer;

    @FindBy(xpath = "//div//button[@name='btnButton1']")
    private WebElement buttonOne;

    @FindBy(xpath = "//div//button[@name='btnButton2']")
    private WebElement buttonTwo;

    @FindBy(xpath = "//div//button[@name='end']")
    private WebElement solutionCheckButton;

    /*@FindBy(xpath = "//pre//code[@class='wrap']")
    private WebElement answerForSolutions;*/

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final long DEFAULT_S_TIMEOUT = 20;

    public ExerciseOnePageObjects(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    /**
     * Method checks if exercise one title is displayed in page.
     *
     * @return true if wikipedia logo is visible.
     */
    public boolean isExerciseOnePageVisible() {
        wait.until(ExpectedConditions.visibilityOf(exerciseOnePageRecognizer));
        return exerciseOnePageRecognizer.isDisplayed();
    }

    /**
     * Method checks the button name and clicks correct button.
     */
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

    /**
     * Method clicks button.
     */
    public void clickButton(WebElement button) {
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    /**
     * Method waits for element.
     */
    public void waitForElement(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//pre//code[@class='wrap']")));
    }


}
