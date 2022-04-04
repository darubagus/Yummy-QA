package Tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBoilerPlate {
    private final String menuItemNamePlaceholder = "#menuItemName";
    private final String menuItemXpath = "//android.view.ViewGroup[@content-desc=\""+menuItemNamePlaceholder+"\"]/android.view.ViewGroup/android.widget.TextView";
    private final String buttonItemXpath = "//android.view.ViewGroup[@content-desc=\""+menuItemNamePlaceholder+"\"]/android.view.ViewGroup";
    private final String textFieldXpath = "//android.widget.EditText[@content-desc=\""+menuItemNamePlaceholder+"\"]";

    private final String btnRegister = "//android.view.ViewGroup[@content-desc=\"btnRegister\"]/android.view.ViewGroup";
    private final String btnLogin = "//android.view.ViewGroup[@content-desc=\"btnLogin\"]/android.view.ViewGroup";

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    /**
     * Do not remove this method
     * This method will instantiate the driver and the wait object
     * @throws MalformedURLException
     */
    @BeforeSuite
    public void setup() throws MalformedURLException {
        String PROJECT_ROOT = System.getProperty("user.dir");
        System.out.println(PROJECT_ROOT);
        String APK_PATH = PROJECT_ROOT + "/resources/app-releaseSit.apk";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", new File(APK_PATH).getAbsolutePath());
        capabilities.setCapability("appPackage", "com.yummycorp.yummyshop.sit");
        capabilities.setCapability("appActivity", "com.yummycorp.yummyshop.MainActivity");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 20);
    }

    /**
     * Fill the automation test script here
     * Dont forget the test annotation
     */

    /**
     * Do not remove this method
     */
    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
