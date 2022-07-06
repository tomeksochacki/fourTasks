package pl.amberteam.antycaptcha.utils.pageobject;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Data
public class ExerciseThreePageObject {

    @FindBy(xpath = "//h1[contains(text(),'Exercise 3 - Dropdown list')]")
    private WebElement exerciseThreePageRecognizer;

    @FindBy(xpath = "//td//code[text()='Anti - Establishment Mint']")
    private WebElement downloadedText;

    @FindBy(xpath = "//div//button[@name='solution']")
    private WebElement solutionCheckButton;

    @FindBy(xpath = "//td//code[contains(text(),'s13:v7')]")
    private WebElement expectedOutcome;

    @FindBy(xpath = "//pre//code[@class='wrap']")
    private WebElement answerAfterSelecting;

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final long DEFAULT_S_TIMEOUT = 20;

    public ExerciseThreePageObject(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    /**
     * Method checks if exercise one title is displayed in page.
     *
     * @return true if wikipedia logo is visible.
     */
    public boolean isExerciseThreePageVisible() {
        wait.until(ExpectedConditions.visibilityOf(exerciseThreePageRecognizer));
        return exerciseThreePageRecognizer.isDisplayed();
    }

    /**
     * Method clicks button.
     */
    public void clickButton(WebElement button) {
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }

}
