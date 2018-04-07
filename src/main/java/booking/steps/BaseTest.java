package booking.steps;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by zsmirnova on 4/6/18.
 */
public class BaseTest {

    private static WebDriver webDriver;

    @BeforeClass
    public static void browserInitialization(){
        webDriver = new ChromeDriver();
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    @After
    public void close(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }


}
