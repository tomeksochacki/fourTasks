package pl.amberteam.antycaptcha.utils.pageobject;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Data
public class ExerciseTwoPageObject {

    @FindBy(xpath = "//h1[contains(text(),'Exercise 2 - Editbox')]")
    private WebElement exerciseTwoPageRecognizer;

    @FindBy(xpath = "//td//code[text()='Generation than left.']")
    private WebElement downloadedText;

    @FindBy(xpath = "//div//input[@id='t14']")
    private WebElement toTextInput;

    @FindBy(xpath = "//div//button[@name='btnButton1']")
    private WebElement buttonOne;

    @FindBy(xpath = "//div//button[@name='end']")
    private WebElement solutionCheckButton;

    @FindBy(xpath = "//td//code[contains(text(),'t14:Generation than left.b1')]")
    private WebElement expectedOutcome;

    @FindBy(xpath = "//pre//code[@class='wrap']")
    private WebElement answerAfterClicking;

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final long DEFAULT_S_TIMEOUT = 20;

    public ExerciseTwoPageObject(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }
}
