package orangehrm;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class BaseTest extends BaseClass {


        @Before
        public void startBrowser() {
            driver = new FirefoxDriver();
            //opening the Firefox Browser
            driver.get("http://demo.orangehrmlive.com/");
            //Maximise he Window
            driver.manage().window().maximize();
            //Wait for page to load
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }

        @After
        public void stopBrowser() {
            //Killing the Driver object
            driver.quit();
        }
    }

}
