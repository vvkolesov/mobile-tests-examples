package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ViewsPages;

import static base.DriverFactory.getDriver;

public class SimpleTest extends BaseTest {

    @Test
    public void verifyingNumberOfElements() {
        MainPage mainPage = basePage.mainPage()
                .clickOnViewsButton();

        int numberOfElements = new ViewsPages().getListOfElements().size();

        Assert.assertEquals(numberOfElements, 42);
    }

    @Test
    public void setupDate() {
        MainPage mainPage = basePage.mainPage()
                .clickOnViewsButton();

        mainPage.viewsPage()
                .clickDateWidgetButton()
                .clickDialogButton()
                .setupDate()
                .setupTime();
    }

    @Test
    public void nextButtonTest() {
        int numberOfClicks = 5;

        MainPage mainPage = basePage.mainPage()
                .clickOnViewsButton();
        mainPage.viewsPage()
                .clickTextTextSwitcherButton()
                .clickNextButton(numberOfClicks);

        Assert.assertEquals(mainPage.viewsPage().getNumber(), String.valueOf(numberOfClicks));
    }
}
