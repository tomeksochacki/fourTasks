package pl.amberteam.antycaptcha.utils.pageobject;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Data
public class ExerciseFourPageObject {

    @FindBy(xpath = "//h1[contains(text(),'Exercise 4 - Radio buttons')]")
    private WebElement exerciseFourPageRecognizer;
    //tu webelementy

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final long DEFAULT_S_TIMEOUT = 20;

    public ExerciseFourPageObject(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }
}
