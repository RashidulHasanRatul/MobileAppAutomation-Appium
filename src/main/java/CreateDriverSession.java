import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class CreateDriverSession {
    public static void main(String[] args) throws MalformedURLException {
        // Desire capability for Android
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability("avd", "Pixel_4_API_27");
        capabilities.setCapability("avdLaunchTimeout", "180000");
        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator +"main"+File.separator+"resources"+File.separator+ "ApiDemos-debug.apk";
        capabilities.setCapability(MobileCapabilityType.APP, appUrl);

        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        // Create driver object
        AppiumDriver driver = new AndroidDriver(url, capabilities);





    }
}
