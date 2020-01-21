package Q2.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTestSetup {

    private WebDriver driver;
    static String driverPath = "./chromedriver";


    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String site) {
        driver = initChromeDriver(site);
    }

    /**
     * Helper class to remove WW popup that could mess up the Q2.tests
     */
    public void removePopUp(){
        driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
    }

    private static WebDriver initChromeDriver(String site) {
        //System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(site);
        return driver;
    }

    public void initTestBaseSetup(String site) {
        try {
            setDriver(site);
        } catch (Exception e) {
            System.out.println("Error:" + e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
