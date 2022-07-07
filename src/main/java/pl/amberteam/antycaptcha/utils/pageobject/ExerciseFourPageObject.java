package pl.amberteam.antycaptcha.utils.pageobject;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Data
public class ExerciseFourPageObject {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final long DEFAULT_S_TIMEOUT = 20;
    final String checkboxValueForZeroGroup = "v70";
    final String checkboxValueForOneGroup = "v61";
    final String checkboxValueForTwoGroup = "v02";
    final String checkboxValueForThreeGroup = "v83";
    final String selectElementNameForZeroGroup = "Anti - Establishment Mint";
    final String selectElementNameForOneGroup = "Duck Egg Blue";
    final String selectElementNameForTwoGroup = "Beluga Brown";
    final String selectElementNameForThreeGroup = "Amberlite Firemist";

    @FindBy(xpath = "//h1[contains(text(),'Exercise 4 - Radio buttons')]")
    private WebElement exerciseFourPageRecognizer;
    @FindBy(xpath = "//input[@value='v70']")
    private WebElement checkboxForZeroGroup;
    @FindBy(xpath = "//input[@value='v61']")
    private WebElement checkboxForOneGroup;
    @FindBy(xpath = "//input[@value='v02']")
    private WebElement checkboxForTwoGroup;
    @FindBy(xpath = "//input[@value='v83']")
    private WebElement checkboxForThreeGroup;
    @FindBy(xpath = "//div//button[@name='solution']")
    private WebElement solutionCheckButton;
    @FindBy(xpath = "//td//code[contains(text(),'[7, 6, 0, 8]')]")
    private WebElement expectedOutcome;
    @FindBy(xpath = "//pre//code[@class='wrap']")
    private WebElement answerAfterSelecting;

    By byForAllTextInZeroGroup = By.xpath("//div/div[@class='row u-full-width'][1]");
    By byForAllTextInOneGroup = By.xpath("//div/div[@class='row u-full-width'][2]");
    By byForAllTextInTwoGroup = By.xpath("//div/div[@class='row u-full-width'][3]");
    By byForAllTextInThreeGroup = By.xpath("//div/div[@class='row u-full-width'][4]");

    By byForCheckboxListZero = By.xpath("//div//input[@name='s0']");
    By byForCheckboxListOne = By.xpath("//div//input[@name='s1']");
    By byForCheckboxListTwo = By.xpath("//div//input[@name='s2']");
    By byForCheckboxListThree = By.xpath("//div//input[@name='s3']");

    public ExerciseFourPageObject(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }
}
