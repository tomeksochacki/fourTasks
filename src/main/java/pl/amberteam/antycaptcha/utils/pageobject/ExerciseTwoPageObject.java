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
public class ExerciseTwoPageObject {

    @FindBy(xpath = "//h1[contains(text(),'Exercise 2 - Editbox')]")
    private WebElement exerciseTwoPageRecognizer;

    @FindBy(xpath = "//td//code[text()='Generation than left.']")
    private WebElement toEnterText;

    @FindBy(xpath = "//div//input[@id='t14']")
    private WebElement toTextInput;

    @FindBy(xpath = "//div//button[@name='btnButton1']")
    private WebElement buttonOne;

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final long DEFAULT_S_TIMEOUT = 20;

    public ExerciseTwoPageObject(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    /**
     * Method checks if exercise one title is displayed in page.
     *
     * @return true if wikipedia logo is visible.
     */
    public boolean isExerciseTwoPageVisible() {
        wait.until(ExpectedConditions.visibilityOf(exerciseTwoPageRecognizer));
        return exerciseTwoPageRecognizer.isDisplayed();
    }




}
