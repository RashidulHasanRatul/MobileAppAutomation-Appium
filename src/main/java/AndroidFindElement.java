
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AndroidFindElement {
//    @FindBy(id = "android:id/text1") private static WebElement text1;
//    public  AndroidFindElement(AppiumDriver driver) {
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//    }
    public static void main(String[] args) throws Exception {

       // AndroidFindElement app = new AndroidFindElement(new AppiumDriver());
//       text1.getText();

        AppiumDriver driver = CreateDriverSession.initializedDriver("Android");

        MobileElement myElement = (MobileElement) driver.findElementByAccessibilityId("Accessibility");
        System.out.println(myElement.getText());


        myElement = (MobileElement) driver.findElementsById("android:id/text1").get(1);
        System.out.println(myElement.getText());

        // WebElement to find the element
        WebElement element = driver.findElementByAccessibilityId("Accessibility");
        System.out.println(element.getText());

        // By to find the element

        By myBY = MobileBy.AccessibilityId("NFC");
        System.out.println(driver.findElement(myBY).getText());

        By myBY2 = MobileBy.xpath("//*[@text='OS']");
        System.out.println(driver.findElement(myBY2).getText());


    }
}
