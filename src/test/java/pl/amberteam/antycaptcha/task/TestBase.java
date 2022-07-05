package pl.amberteam.antycaptcha.task;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import pl.amberteam.antycaptcha.DriverFactory;
import pl.amberteam.antycaptcha.utils.controller.MainUtilitiesController;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBase {

    protected WebDriver webDriver;
    protected MainUtilitiesController mainUtilitiesController;

    public TestBase()
    {
        DriverFactory driverFactory = new DriverFactory();
        this.webDriver = driverFactory.initDriver();
        this.mainUtilitiesController = new MainUtilitiesController(webDriver);
        this.webDriver.manage().window().maximize();
    }

    @AfterAll
    public void cleanUp(){
        this.webDriver.quit();
    }
}