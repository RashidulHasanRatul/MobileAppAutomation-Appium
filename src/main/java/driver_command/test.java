package driver_command;
import driver_session.CreateDriverSession;
import io.appium.java_client.AppiumDriver;

public class test {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializedDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);





    }
}
