package Q2.tests;

import Q2.PageObjects.SearchZipPage;
import Q2.PageObjects.WWStudioPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WWStudioPageTest extends BaseTestSetup{
    private WebDriver driver;
    private WWStudioPage wwsp;

    @Parameters({ "site4" })
    @BeforeClass
    public void setUp(String site4) {
        initTestBaseSetup(site4);
        driver = getDriver();
    }

    @Parameters({ "studioPageTitle" })
    //@Test
    public void testTilePage(String studioPageTitle){
        wwsp = new WWStudioPage(driver);
        Assert.assertTrue(wwsp.verifyLocationName(studioPageTitle),"WW studio page title doesn't match");
    }

    @Test
    public void testHrsOps(){
        wwsp = new WWStudioPage(driver);
        removePopUp();
        String res = wwsp.printHrsOfOp();
        String hrs = "SUN\n" +
                "8:00 AM – 1:00 PM\n" +
                "MON\n" +
                "7:45 AM – 2:00 PM\n" +
                "5:30 PM – 7:00 PM\n" +
                "TUE\n" +
                "8:00 AM – 2:00 PM\n" +
                "4:45 PM – 7:45 PM\n" +
                "WED\n" +
                "8:00 AM – 1:15 PM\n" +
                "5:00 PM – 6:30 PM\n" +
                "THU\n" +
                "7:45 AM – 2:00 PM\n" +
                "4:45 PM – 7:15 PM\n" +
                "FRI\n" +
                "7:45 AM – 2:00 PM\n" +
                "5:00 PM – 6:30 PM\n" +
                "SAT\n" +
                "8:00 AM – 12:30 PM\n";
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(res, hrs);

    }

    @Parameters({"dayOfTheWeek"})
    @Test
    public void testMeetings(String dayOfTheWeek){
        wwsp = new WWStudioPage(driver);
        removePopUp();
        Assert.assertEquals(wwsp.printMeetings(dayOfTheWeek),"DANA F. 1\nLISA S. 2\n");
    }

}
