package driver_command;

import driver_session.CreateDriverSession;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class working_with_keys {
    public static void main(String[] args) throws Exception {
        // it should be check for text the keyboard is open or not
        // open the app
        MobileDriver driver = CreateDriverSession.initializedDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // click on views button
        By views = MobileBy.AccessibilityId("Views");
        By textfields = MobileBy.AccessibilityId("TextFields");
        By editText = MobileBy.id("io.appium.android.apis:id/edit");
        driver.findElement(views).click();
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int endX = startX;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        // scroll to text field
        for (int i = 0; i < 5; i++) {
            TouchAction t = new TouchAction(driver);
            t.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(endX, endY)).
                    release()
                    .perform();
        }


        // click text file
        driver.findElement(textfields).click();
        driver.findElement(editText).click();
        Thread.sleep(2000);


        // click on the keyboard
        System.out.println(((AndroidDriver) driver).isKeyboardShown());

        // type text in text field using native key

        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.R));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.S));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.H));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.I));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.D));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.U));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.L));

        /*
        * click on Home button
        * ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        * click on back button
        * ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        * press key using selenium
        * driver.getKeyBoard().sendKeys("Hello");
        * */

        driver.hideKeyboard();
    }


}
