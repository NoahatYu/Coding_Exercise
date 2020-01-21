package Q2.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FindAStudioPage {
    private WebDriver driver;
    private String zipCode = "10011";
    private By zipTextBox = By.id("meetingSearch");
    private By zipSearchBtn = By.className("btn spice-translated");

    public FindAStudioPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFindAStudioPageTitle() {
        return driver.getTitle();
    }

    /**
     * Verify loaded page title contains “Find WW Studios & Meetings Near You | WW USA”
     * @return true if so and false if not
     */
    public boolean verifyFindAStudioPageTitle(String expectedTitle) {
        System.out.println(getFindAStudioPageTitle());
        return getFindAStudioPageTitle().equals(expectedTitle);
    }


    /**
     * In the search field, enter zip for meetings
     * @return
     */
    public void enterZip() {
        WebElement zipSearchBoxElement = driver.findElement(zipTextBox);
        if(zipSearchBoxElement.isDisplayed()) {
            zipSearchBoxElement.sendKeys(zipCode);
        }
    }

    /**
     * Search for WW studios with given zip
     * @return
     */
    public SearchZipPage searchZip() {
        System.out.println("Searching for zip: ");
        enterZip();
        WebElement zipSearchBtnElement = driver.findElement(zipTextBox);
        if(zipSearchBtnElement.isDisplayed() || zipSearchBtnElement.isEnabled()){
            zipSearchBtnElement.sendKeys(Keys.ENTER);
       } else {
            System.err.println("ERROR: Element not found");
            return null;
        }
        return new SearchZipPage(driver);
    }

}
