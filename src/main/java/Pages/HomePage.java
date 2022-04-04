package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

public class HomePage extends BasePage {

    /*
    * Login Button
    * */
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"btnLogin\"]/android.view.ViewGroup")
    private WebElement loginButton;

    /*
    * Sign Up Button
    * */
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"btnRegister\"]/android.view.ViewGroup")
    private WebElement signUpButton;

    /**
     * Login Label
     *
     */
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"btnLogin\"]/android.view.ViewGroup/android.widget.TextView")
    private WebElement loginLabel;

    /**
     * Sign Up Label
     *
     */
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"btnRegister\"]/android.view.ViewGroup/android.widget.TextView")
    private WebElement signUpLabel;

    /*
    * Constructor
    * */
    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    /*
    * Click on Login Button
    * */
    public void clickLoginButton() {
        loginButton.click();
    }

    /*
    * Click on Sign Up Button
    * */
    public void clickSignUpButton() {
        signUpButton.click();
    }

    /**
     * Get Login Label
     */
    public String getLoginLabel() {
        return loginLabel.getText();
    }

    /**
     * Get Sign Up Label
     */
    public String getSignUpLabel() {
        return signUpLabel.getText();
    }
}
