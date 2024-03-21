package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewsPages extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView")
    private List<WebElement> listOfElements;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Date Widgets\"]")
    private WebElement dateWidgetButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"1. Dialog\"]")
    private WebElement dialogButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"change the date\"]")
    private WebElement changeDateButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"21 March 2024\"]")
    private WebElement selectedDate;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    private WebElement okButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"change the time (spinner)\"]")
    private WebElement selectedTime;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\"])[1]")
    private WebElement selectHour;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\"])[2]")
    private WebElement selectMinute;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\"PM\"]")
    private WebElement selectPartOfDay;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
            ".scrollIntoView(new UiSelector().text(\"TextSwitcher\"))")
    private WebElement textSwitcherButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Next\"]")
    private WebElement nextButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"5\"]")
    private WebElement numberOfClick;

    public List<WebElement> getListOfElements() {
        return listOfElements;
    }

    public ViewsPages clickDateWidgetButton() {
        dateWidgetButton.click();
        return this;
    }

    public ViewsPages clickDialogButton() {
        dialogButton.click();
        return this;
    }

    public ViewsPages setupDate() {
        changeDateButton.click();
        selectedDate.sendKeys("21 March 2024");
        okButton.click();
        return this;
    }

    public ViewsPages setupTime() {
        selectedTime.click();
        selectHour.sendKeys("11");
        selectMinute.sendKeys("11");
        selectPartOfDay.click();
        okButton.click();
        return this;
    }

    public ViewsPages clickTextTextSwitcherButton() {
        textSwitcherButton.click();
        return this;
    }

    public ViewsPages clickNextButton(int numberOfClicks) {
        for (int i = 0; i < numberOfClicks; i++) {
            nextButton.click();
        }
        return this;
    }

    public String getNumber() {
        return numberOfClick.getText();
    }
}
