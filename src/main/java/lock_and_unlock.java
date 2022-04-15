import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

public class lock_and_unlock {
    public static void main(String[] args) throws Exception {
        MobileDriver driver = CreateDriverSession.initializedDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // with out Lock
        ((AndroidDriver) driver).lockDevice();
        System.out.println(((AndroidDriver) driver).isDeviceLocked());
        Thread.sleep(5000);
        ((AndroidDriver) driver).unlockDevice();
        Thread.sleep(5000);
        driver.quit();

        // For PIn you need to set the pin capability in the Driver initialize  file
        // capabilities.setCapability("unlockType", "pin");
        // capabilities.setCapability("unlockKey", "1234");

        // capabilities.setCapability("unlockType", "pattern");

    }
}
