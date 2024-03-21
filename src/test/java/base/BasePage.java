package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pages.MainPage;
import pages.ViewsPages;

import java.time.Duration;

import static base.DriverFactory.getDriver;
import static base.DriverFactory.getInstanceOfDriverFactory;
import static org.openqa.selenium.support.PageFactory.initElements;

public class BasePage {

    public final static Duration IMPLICIT_WAIT = Duration.ofSeconds(0);

    public BasePage() {
        getInstanceOfDriverFactory();
        initElements(new AppiumFieldDecorator(DriverFactory.getDriver(), IMPLICIT_WAIT), this);
    }

    public MainPage mainPage() {
        return new MainPage();
    }

    public ViewsPages viewsPage() {
        return new ViewsPages();
    }

}
