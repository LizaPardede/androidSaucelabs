package Saucelabs.util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Capabilities extends DesiredCapabilities {
    protected AndroidDriver androidDriver;
    private AppiumDriverLocalService service;

    protected void preparation() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ASUS_X00QD");
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", "/Users/liza/Downloads/mda-1.0.13-15.apk");
        caps.setCapability("appPackage", "com.saucelabs.mydemoapp.android");
        caps.setCapability("appWaitActivity", "SplashActivity, SplashActivity,OtherActivity, *, *.SplashActivity");
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        String service_url = service.getUrl().toString();
        System.out.println("Appium Service Address: " + service_url);
        androidDriver = new AndroidDriver(new URL(service_url), caps);
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void stopServer() {
        service.stop();
    }
}
