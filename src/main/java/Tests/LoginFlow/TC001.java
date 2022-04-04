package Tests.LoginFlow;

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

public class TC001 {
    private final String menuItemNamePlaceholder = "#menuItemName";
    private final String menuItemXpath = "//android.view.ViewGroup[@content-desc=\""+menuItemNamePlaceholder+"\"]/android.view.ViewGroup/android.widget.TextView";
    private final String buttonItemXpath = "//android.view.ViewGroup[@content-desc=\""+menuItemNamePlaceholder+"\"]/android.view.ViewGroup";
    private final String textFieldXpath = "//android.widget.EditText[@content-desc=\""+menuItemNamePlaceholder+"\"]";

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

    @Test(priority = 1)
    public void landingHome() {
        By registerButton = By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "btnRegister"));
        By loginButton = By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "btnLogin"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

        Assert.assertEquals(driver.findElement(registerButton).getText(), "Daftar");
        Assert.assertEquals(driver.findElement(loginButton).getText(), "Login");
    }

    @Test(priority = 2)
    public void clickLogin() {
        By loginButton = By.xpath(buttonItemXpath.replace(menuItemNamePlaceholder, "btnLogin"));
        By loginLabel = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

        driver.findElement(loginButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginLabel));

        Assert.assertEquals(driver.findElement(loginLabel).getText(), "Login");
    }

    @Test(priority = 3)
    public void clickLanjutkan() throws InterruptedException {
        By continueLoginButton = By.xpath(buttonItemXpath.replace(menuItemNamePlaceholder, "continueLogin"));
        By errorMessage = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[4]");
        By textField = By.xpath(textFieldXpath.replace(menuItemNamePlaceholder, "fieldLogin"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(continueLoginButton));

        wait.until(ExpectedConditions.visibilityOfElementLocated(textField));

        driver.findElement(textField).click();

        driver.findElement(textField).sendKeys("");

        driver.findElement(continueLoginButton).click();

        /**
         * Have to add line 95 because the error message and "atau" has the same xpath
         * otherwise the test will fail
         */
        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));

        Assert.assertEquals(driver.findElement(errorMessage).getText(), "Email atau No. Whatsapp harus di isi");
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
