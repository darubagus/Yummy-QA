package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    private final String menuItemNamePlaceholder = "#menuItemName";
    private final String menuItemXpath = "//android.view.ViewGroup[@content-desc=\""+menuItemNamePlaceholder+"\"]/android.view.ViewGroup/android.widget.TextView";
    private final String buttonItemXpath = "//android.view.ViewGroup[@content-desc=\""+menuItemNamePlaceholder+"\"]/android.view.ViewGroup";
    private final String editTextXpath = "//android.widget.EditText[@content-desc=\""+menuItemNamePlaceholder+"\"]";

//    private final static String registerBtn = buttonItemXpath.replace(menuItemNamePlaceholder, "registerAccount");
//    private final String socMedBtn = buttonItemXpath.replace(menuItemNamePlaceholder, "registSocialMedia");
//    private final String fieldRegister = editTextXpath.replace(menuItemNamePlaceholder, "fieldRegister");
//    private final static String backBtn = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup";

    public AndroidDriver<MobileElement> driver;

    public RegisterPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"registerAccount\"]/android.view.ViewGroup")
    private MobileElement registerButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"fieldRegister\"]")
    private MobileElement fieldRegister;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"registSocialMedia\"]/android.view.ViewGroup")
    private MobileElement socialMediaButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
    private MobileElement backButton;

    public void enterFieldRegister(String text) {
        fieldRegister.sendKeys(text);
    }
    
    public void registerUsingField(String text) {
        enterFieldRegister(text);
        registerButton.click();
    }

    public void clickBack() {
        backButton.click();
    }
}
