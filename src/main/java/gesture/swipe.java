package gesture;

import driver_session.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class swipe {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializedDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        By views = MobileBy.AccessibilityId("Views");
        driver.findElement(views).click();

        Dimension size = driver.manage().window().getSize();

        int startx = size.width / 2;
        int endx = size.height / 2;

        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.2);

        // With Hardcoded values
        TouchAction t = new TouchAction(driver);
        t.press(PointOption.point(540, 1906))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(493, 386))
                .release()
                .perform();

        // with dynamic values
        driver.navigate().back();
        driver.findElement(views).click();
        TouchAction t2 = new TouchAction(driver);
        t2.press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endx, endy))
                .release()
                .perform();
        // gesture.swipe multiple times for reaching the end of the list
        driver.navigate().back();
        driver.findElement(views).click();
        TouchAction t3 = new TouchAction(driver);

        for (int i = 0; i < 5; i++) {
            t3.press(PointOption.point(startx, starty))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(endx, endy))
                    .release()
                    .perform();
        }

        // gesture.swipe one element to another element
        driver.navigate().back();
        driver.findElement(views).click();
        TouchAction t4 = new TouchAction(driver);

        By grid = MobileBy.AccessibilityId("Grid");
        By annimation = MobileBy.AccessibilityId("Animation");
        t4.press(ElementOption.element(driver.findElement(grid)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(ElementOption.element(driver.findElement(annimation)))
                .release()
                .perform();

    }
}


// x 540
// y 1906


//494
//386