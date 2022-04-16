package driver_command;
import driver_session.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Interact_with_apps {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializedDriver("Android");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        By views = MobileBy.AccessibilityId("Views");
        driver.findElement(views).click();
        Thread.sleep(5000);
        // Terminate the app
        //driver.terminateApp("io.appium.android.apis");
        // System.out.println("App terminated");
        // Install the app
        String AndroidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        driver.installApp(AndroidAppUrl, new AndroidInstallApplicationOptions().withReplaceEnabled());
        System.out.println("App installed or updated");

        // App installed or not
        if (driver.isAppInstalled("io.appium.android.apis")) {
            System.out.println("App is installed");

        } else {
            System.out.println("App is not installed");
        }

        // Run App in Background
        driver.runAppInBackground(Duration.ofSeconds(5));
        System.out.println("App is running in background");

        // query the app
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        driver.terminateApp("io.appium.android.apis");
        System.out.println("App terminated");
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        // Terminate  are used for checking the app is capable of running background or not
        //Terminate Method used for switch between two apps and check the app is running in background or not

    }
}
