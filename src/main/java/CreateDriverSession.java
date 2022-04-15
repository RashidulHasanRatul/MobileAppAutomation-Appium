import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import java.net.URL;


public class CreateDriverSession {


    public static AppiumDriver initializedDriver(String PlatformName) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PlatformName);
        capabilities.setCapability("newCommandTimeout", "300");
        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        switch (PlatformName) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
                capabilities.setCapability("avd", "Pixel_4_API_27");
                capabilities.setCapability("avdLaunchTimeout", "180000");
                String AndroidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
                capabilities.setCapability(MobileCapabilityType.APP, AndroidAppUrl);
                capabilities.setCapability("unlockType", "pin");
                capabilities.setCapability("unlockKey", "1234");
                return new AndroidDriver(url, capabilities);

            case "iOS":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability(MobileCapabilityType.UDID, "8b8b8b8b8b8b8b8b8b8b8b8b8b8b8b8b8b8b8b8b");
                String IOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
                capabilities.setCapability(MobileCapabilityType.APP, IOSAppUrl);
                return new IOSDriver(url, capabilities);

            default:
                throw new Exception("Platform not supported");

        }
    }


    // Create driver object
    // AppiumDriver driver = new AndroidDriver(url, capabilities);
}
