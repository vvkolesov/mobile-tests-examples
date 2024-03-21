package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static base.DriverFactory.getDriver;

public class MainPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Views\"]")
    private WebElement viewsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"TextSwitcher\"]")
    private WebElement textSwitcherButton;

    public MainPage clickOnViewsButton() {
        viewsButton.click();
        return this;
    }
    public MainPage clickOnTextSwitcherButton() {
        textSwitcherButton.click();
        return this;
    }

}
