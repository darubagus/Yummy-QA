package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
    private final String menuItemNamePlaceholder = "#menuItemName";
    private final String menuItemXpath = "//android.view.ViewGroup[@content-desc=\""+menuItemNamePlaceholder+"\"]/android.view.ViewGroup/android.widget.TextView";
    private final String buttonItemXpath = "//android.view.ViewGroup[@content-desc=\""+menuItemNamePlaceholder+"\"]/android.view.ViewGroup";
    private final String editTextXpath = "//android.widget.EditText[@content-desc=\""+menuItemNamePlaceholder+"\"]";

    private final String loginBtn = buttonItemXpath.replace(menuItemNamePlaceholder, "continueLogin");
    private final String socMedBtn = buttonItemXpath.replace(menuItemNamePlaceholder, "loginSocialMedia");
    private final String fieldLogin = editTextXpath.replace(menuItemNamePlaceholder, "fieldLogin");
    private final String backBtn = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup";

    public AndroidDriver<MobileElement> driver;

    public LoginPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void clickLoginBtn() {
        driver.findElementByXPath(loginBtn).click();
    }

    public void clickSocMedBtn() {
        driver.findElementByXPath(socMedBtn).click();
    }

    public void clickBackBtn() {
        driver.findElementByXPath(backBtn).click();
    }

    public void setFieldLogin(String text) {
        driver.findElementByXPath(fieldLogin).sendKeys(text);
    }

    public void login(String text) {
        setFieldLogin(text);
        clickLoginBtn();
    }
}
