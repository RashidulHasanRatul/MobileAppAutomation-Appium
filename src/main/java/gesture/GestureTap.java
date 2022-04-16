package gesture;

import driver_session.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GestureTap {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializedDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        By accessibilityId = MobileBy.AccessibilityId("Accessibility");
        By nfcId = MobileBy.AccessibilityId("NFC");

        //Tap
        TouchAction action = new TouchAction(driver);
        action.tap(ElementOption.element(driver.findElement(accessibilityId))).perform();

       driver.navigate().back();

        //
        // Long press
        action.press(ElementOption.element(driver.findElement(nfcId))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).release().perform();
        driver.navigate().back();

        //

    }
}
