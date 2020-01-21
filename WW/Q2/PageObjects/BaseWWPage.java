package Q2.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Question 2:
 * ----------
 *
 * The following exercise does not require user login. Please use ID or class as selectors.
 *
 * Steps:
 * 1. Navigate to https://www.weightwatchers.com/us/
 * 2. Verify loaded page title matches “WW (Weight Watchers): Weight Loss & Wellness Help”
 * 3. On the right corner of the page, click on “Find a Studio”
 * 4. Verify loaded page title contains “Find WW Studios & Meetings Near You | WW USA”
 * 5. In the search field, search for meetings for zip code: 10011
 * 6. Print the title of the first result and the distance (located on the right of location title/name)
 * 7. Click on the first search result and then, verify displayed location name/title matches with the name of the first searched result that was clicked.
 * 8. From this location page, print TODAY’s hours of operation (located towards the bottom of the page)
 * 9. Create a method to print the number of meeting the each person(under the scheduled time) has a particular day of the week
 * e.g. printMeetings("Sun")
 * Output should be:
 * Person A  3
 * Person B  1
 *
 * Write an automated test for this scenario using WebDriver.
 *
 */

public class BaseWWPage {
    private WebDriver driver;
    private String website = "https://www.weightwatchers.com/us/";
    private By findAStudioButton = By.className("find-a-meeting");
    private String expectedPageTitle = "WW (Weight Watchers): Weight Loss & Wellness Help";

    /**
     * Constructor
     */
    public BaseWWPage(WebDriver driver){
        this.driver = driver;
    }


    /**
     * Launch Driver and Navigate to https://www.weightwatchers.com/us/
     * @param site website
     * @return WebDriver
     */
    public void LaunchDriver(String site){
        //setting the driver executable
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        //Applied wait time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize window
        driver.manage().window().maximize();
        //open browser with desired URL
        driver.get(site);

    }
    public void quitDriver(WebDriver driver){
        driver.quit();
    }


    /**
     * Gets the page title
     * @return
     */
    public String getBasePageTitle(){
        return driver.getTitle();
    }

    /**
     * Verify loaded page title matches "WW (Weight Watchers): Weight Loss & Wellness Help"
     * @param expectedPageTitle
     * @return
     */
    public boolean verifyBasePageTitle(String expectedPageTitle) {
        String pageTitle = getBasePageTitle();
        return pageTitle.contains(expectedPageTitle);
    }

    public FindAStudioPage clickFindAStudioBtn() {
        System.out.println("Clicking on Find a Studio button");
        WebElement findAStudioBtnElement = driver.findElement(findAStudioButton);
        if(findAStudioBtnElement.isDisplayed() || findAStudioBtnElement.isEnabled())
            findAStudioBtnElement.click();
        else {
            System.err.println("ERROR: Element not found");
        }
        return new FindAStudioPage(driver);
    }




    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //T1 launch driver to main page
        BaseWWPage bp = new BaseWWPage(driver);
        bp.LaunchDriver(bp.website);
        //T2 verify page title is correct
        bp.verifyBasePageTitle(bp.getBasePageTitle());
        //T3 click find a studio btn
        FindAStudioPage fp = bp.clickFindAStudioBtn();
        //T4 verify page is correct title
        fp.verifyFindAStudioPageTitle(fp.getFindAStudioPageTitle());
        //T5 search for zip
        SearchZipPage sp = fp.SearchZip();

        //T6 verify page is correct title

        //T7

        //End of Tests
        bp.quitDriver(driver);





    }
}
