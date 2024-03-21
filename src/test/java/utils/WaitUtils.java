package utils;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static helpers.ElementHelper.isDisplayed;
import static helpers.ElementHelper.isEnabled;
import static org.slf4j.helpers.Util.report;

public class WaitUtils {
    private static final Duration STANDARD_DELAY = Duration.ofSeconds(30);

    public static void delay(long time, TimeUnit timeType) {
        try {
            Thread.sleep(timeType.toMillis(time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitUntilVisibilityOf(WebElement element) {
        return waitUntilVisibilityOf(element, STANDARD_DELAY);
    }

    public static WebElement waitUntilVisibilityOf(WebElement element, Duration timeOutInSeconds) {
        return until(webDriver -> isDisplayed(element) ? element : null, timeOutInSeconds);
    }

    public static  WebElement waitUntilEnabled(WebElement element, Duration timeOutInSeconds) {
        return until(webDriver -> isEnabled(element) ? element : null, timeOutInSeconds);
    }

    private static <V> V until(Function<? super WebDriver, V> isTrue, Duration timeout) {
        try {
            return new WebDriverWait(DriverFactory.getDriver(),  timeout).until(isTrue);
        } catch (NullPointerException e) {
            report("A test's been failed because WebElement - NULL.");
        }
        return null;
    }
}
