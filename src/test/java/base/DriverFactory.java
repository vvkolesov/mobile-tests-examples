package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static utils.CommonUtils.getCentralData;

import utils.CommonUtils;

public class DriverFactory {

    private static AppiumDriver driver;

    private DriverFactory() {
        initializeAppiumDriver();
    }

    private static DriverFactory instanceOfDriverFactory;

    public static DriverFactory getInstanceOfDriverFactory() {
        if (instanceOfDriverFactory == null) {
            instanceOfDriverFactory = new DriverFactory();
        }
        return instanceOfDriverFactory;
    }

    private void initializeAppiumDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getCentralData("deviceName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getCentralData("platformName"));
        capabilities.setCapability(APP_PACKAGE, getCentralData("appPackage"));
        capabilities.setCapability(APP_ACTIVITY, getCentralData("appActivity"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, getCentralData("automationName"));
        capabilities.setCapability(MobileCapabilityType.UDID, getCentralData("UDID"));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, getCentralData("waitTimeoutInSeconds"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getCentralData("platformVersion"));
        try {
            driver = new AndroidDriver(new URL(getCentralData("URL")), capabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static AppiumDriver getDriver() {
        return driver;
    }
}
