package Q2.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBaseSetup {

    private WebDriver driver;
    static String driverPath = "./chromedriver";

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Launch Driver and Navigate to site
     * @param site website
     * @return WebDriver
     */
    @BeforeClass
    public void LaunchDriver(String site){
        //setting the driver executable
        System.setProperty("webdriver.chrome.driver", driverPath);
        //Applied wait time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize window
        driver.manage().window().maximize();
        //open browser with desired URL
        driver.get(site);

    }
    @AfterClass
    public void quitDriver(){
        driver.quit();
    }

}
