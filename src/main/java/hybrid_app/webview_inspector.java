package hybrid_app;

import driver_session.CreateDriverSession;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class webview_inspector {
    public static void main(String[] args) throws Exception {
        MobileDriver driver = CreateDriverSession.initializedDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By views = MobileBy.AccessibilityId("Views");
        By webView = MobileBy.AccessibilityId("WebView2");
        // click on views button
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

        // click on webview
        driver.findElement(webView).click();
        System.out.println(driver.findElement(MobileBy.xpath("//android.webkit.Webview/android.view.View[1]")).getText());
    }
}
