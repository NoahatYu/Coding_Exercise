package Q2.tests;

import Q2.PageObjects.BaseWWPage;
import Q2.PageObjects.FindAStudioPage;
import Q2.PageObjects.SearchZipPage;
import Q2.PageObjects.WWStudioPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchZipPageTest extends BaseTestSetup {
    private WebDriver driver;
    private SearchZipPage szp;
    //private String titlePage;

    @Parameters({ "site3" })
    @BeforeClass
    public void setUp(String site3) {
        initTestBaseSetup(site3);
        driver = getDriver();
    }

    @Parameters({ "zipPageTitle" })
    @Test
    public void testZipPage(String zipPageTitle){
        szp = new SearchZipPage(driver);
        String titlePage = szp.getSearchZipPageTitle();
        Assert.assertEquals(zipPageTitle,titlePage);
        WWStudioPage wwsp = szp.findWWStudio();
        removePopUp();
        Assert.assertNotNull(wwsp);
        Assert.assertEquals(szp.getStudioTitle(),wwsp.getLocalName());
        Assert.assertEquals(szp.getStudioDistance(),"0.49 mi.");
    }


}
