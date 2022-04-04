import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MainTest {
    private final String menuItemNamePlaceholder = "#menuItemName";
    private final String menuItemXpath = "//android.view.ViewGroup[@content-desc=\""+menuItemNamePlaceholder+"\"]/android.view.ViewGroup/android.widget.TextView";
    private final String buttonItemXpath = "//android.view.ViewGroup[@content-desc=\""+menuItemNamePlaceholder+"\"]/android.view.ViewGroup";

    private final String btnRegister = "//android.view.ViewGroup[@content-desc=\"btnRegister\"]/android.view.ViewGroup";
    private final String btnLogin = "//android.view.ViewGroup[@content-desc=\"btnLogin\"]/android.view.ViewGroup";

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

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


    @Test(groups = "a")
    public void loginBtnTest() {
        By loginButton = By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "btnLogin"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

        Assert.assertEquals(driver.findElement(loginButton).getText(), "Login");
    }

    @Test(groups = "a")
    public void registerBtnTest() {
        By registerBtn = By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "btnRegister"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(registerBtn));

        Assert.assertEquals(driver.findElement(registerBtn).getText(), "Daftar");
    }

    @Test(dependsOnGroups = "a")
    public void clickRegister() {
        By registerBtn = By.xpath(buttonItemXpath.replace(menuItemNamePlaceholder, "btnRegister"));
        By titleDaftar = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(registerBtn));

        driver.findElement(registerBtn).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(titleDaftar));

        Assert.assertEquals(driver.findElement(titleDaftar).getText(), "Daftar");
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
