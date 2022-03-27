
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;



public class AndroidFindElement {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializedDriver("Android");

        MobileElement myElement = (MobileElement) driver.findElementByAccessibilityId("Accessibility");
        System.out.println(myElement.getText());


        myElement = (MobileElement) driver.findElementsById("android:id/text1").get(1);
        System.out.println(myElement.getText());

    }
}
