package Q2.PageObjects;

import org.openqa.selenium.WebDriver;


public class FindAStudioPage {
    private WebDriver driver;
    private String expectedTitle = "Find WW Studios & Meetings Near You | WW USA";

    public FindAStudioPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFindAStudioPageTitle(String expectedTitle) {
        return driver.getTitle();
    }

    /**
     * Verify loaded page title contains “Find WW Studios & Meetings Near You | WW USA”
     * @return true if so and false if not
     */
    public boolean verifyFindAStudioPageTitle() {
        return getFindAStudioPageTitle(expectedTitle).contains(expectedTitle);
    }

    /**
     * In the search field, search for meetings for zip code: 10011
     */

}
