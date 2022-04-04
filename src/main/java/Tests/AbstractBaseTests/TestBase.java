package Tests.AbstractBaseTests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    /**
    * This is the base class for all the tests.
    * It contains the driver and the methods to find elements.
    * Created only once and used across all the tests.
    * */
    public static AndroidDriver<MobileElement> driver;

    /**
     * Method to initialize the test page
     */
    @BeforeTest
    public abstract void setUpPage();

    /**
     * THIS METHOD RUNS BEFORE ANY OTHER METHODS
     */
    @BeforeSuite
    public void setUpAppium() throws MalformedURLException {
        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

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

        driver = new AndroidDriver<MobileElement>(new URL(URL_STRING), capabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    /**
     * Quit the driver
     */
    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    /**
     * Restart the app after every test class to go back to the main screen
     * and reset the behavior
     */
    @AfterClass
    public void restartApp() {
        driver.resetApp();
    }
}
