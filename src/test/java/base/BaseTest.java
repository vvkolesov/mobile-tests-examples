package base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static base.DriverFactory.getDriver;

public class BaseTest {

    public BasePage basePage;

    @BeforeTest()
    public void startDriver() {
        basePage = new BasePage();
    }

    @AfterTest
    public void stopDriver() {
        getDriver().quit();
    }
}
