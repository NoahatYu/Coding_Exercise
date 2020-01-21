package Q2.tests;

import Q2.PageObjects.BaseWWPage;
import Q2.PageObjects.FindAStudioPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FindAStudioPageTest extends BaseTestSetup {
    private WebDriver driver;
    private FindAStudioPage fsp;

    @Parameters({"site2"})
    @BeforeClass
    public void setUp(String site2) {
        initTestBaseSetup(site2);
        driver = getDriver();
    }

    @Parameters({"findAStudioPageTitle"})
    @Test
    public void testTilePageAndSearchZip(String findAStudioPageTitle) {
        fsp = new FindAStudioPage(driver);
        removePopUp();
        fsp.verifyFindAStudioPageTitle(findAStudioPageTitle);
        Assert.assertTrue(fsp.verifyFindAStudioPageTitle(findAStudioPageTitle), "Find A Studio title doesn't match");
        Assert.assertNotNull(fsp.searchZip());
    }

}
