import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;


public class AndroidFindElement {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializedDriver("Android");

        WebElement element = driver.findElement(new AppiumBy.ByAccessibilityId("Access'ibility"));
       // element.click();
        System.out.println(element.getText());





    }
}
