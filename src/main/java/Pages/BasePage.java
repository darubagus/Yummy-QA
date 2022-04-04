package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    private static final int KEYBOARD_ANIMATION_DELAY = 1000;
    private static final int XML_REFRESH_DELAY = 1000;
    /**
     * The driver
     * */
    protected final AppiumDriver driver;


    /**
     * Constructor
     *
     * The page structure is being used within this test in order to separate the page objects from the test code.
     *
     * Use AppiumFieldDecorator class within the pagefactory. This way annotations
     * like @AndroidFindBy can be used.
     *
     * @param driver The driver created in the beforesuite method
     * */
    protected BasePage(AppiumDriver driver) {
        this.driver = driver;
        AppiumFieldDecorator fd = new AppiumFieldDecorator(driver, Duration.ofSeconds(10));
        PageFactory.initElements(fd, this);
    }

    protected boolean sendKeysToElmt(String input, WebElement element, boolean appendNewLine) throws InterruptedException {
        final int MAX_ATTEMPTS = 3;
        int attempt = 0;

        do {
            element.clear();
            Thread.sleep(KEYBOARD_ANIMATION_DELAY);

            if (appendNewLine) {
                element.sendKeys(input + "\n");
            } else {
                element.sendKeys(input);
            }

            Thread.sleep(XML_REFRESH_DELAY);
        } while (!element.getText().contains(input) && ++attempt < MAX_ATTEMPTS);

        return element.getText().contains(input);
    }

}
