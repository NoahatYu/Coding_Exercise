package Q2.tests;
import Q2.PageObjects.BaseWWPage;
import Q2.PageObjects.FindAStudioPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.annotation.ParametersAreNonnullByDefault;

public class BaseWWPageTest extends BaseTestSetup {
    private BaseWWPage bp;

    /**
     * WebDriver driver = new ChromeDriver();
     *         //T1 launch driver to main page
     *         BaseWWPage bp = new BaseWWPage(driver);
     *         bp.LaunchDriver(bp.website);
     *         //T2 verify page title is correct
     *         bp.verifyBasePageTitle(bp.getBasePageTitle());
     *         //T3 click find a studio btn
     *         FindAStudioPage fp = bp.clickFindAStudioBtn();
     *         //T4 verify page is correct title
     *         fp.verifyFindAStudioPageTitle(fp.getFindAStudioPageTitle());
     *         //T5 search for zip
     *         SearchZipPage sp = fp.SearchZip();
     *
     *         //T6 verify page is correct title
     *
     *         //T7
     *
     *         //End of Tests
     *         bp.quitDriver(driver);
     */

    private WebDriver driver;
    //private String website = "https://www.weightwatchers.com/us/";
    @Parameters({ "site" })
    @BeforeClass
    public void setUp(String site) {
        initTestBaseSetup(site);
        driver = getDriver();
    }
    @Parameters({ "basePageTitle" })
    @Test
    public void testBaseTitle(String basePageTitle) {
        bp = new BaseWWPage(driver);
        removePopUp();
        Assert.assertTrue(bp.verifyBasePageTitle(basePageTitle),"WW page title doesn't match");
    }
    @Test
    public void testStudioBtn(){
        FindAStudioPage fsp = bp.clickFindAStudioBtn();
        removePopUp();
        Assert.assertNotNull(fsp);
    }
}
