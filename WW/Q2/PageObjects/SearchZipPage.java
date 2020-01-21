package Q2.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchZipPage {

    private WebDriver driver;
    private By locationDistance = By.className("location__distance");
    private By wwStudioLocations = By.className("meeting-location");

    public SearchZipPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSearchZipPageTitle() {
        return driver.getTitle();
    }

    /**
     * Verify loaded page title contains correct title
     * @return true if so and false if not
     */
    public boolean verifyFindAStudioPageTitle(String expectedTitle) {
        return getSearchZipPageTitle().contains(expectedTitle);
    }


    /**
     * Click on the first search result
     * @return
     */
    public WWStudioPage findWWStudio() {
        WebElement wwStudioElement = driver.findElement(wwStudioLocations);
        WebElement wwStudioDistance = driver.findElement(locationDistance);
        /*
         * Prints the title of the first result(WW Studio) and the distance
         * (located on the right of location title/name) of it already searched by zip
         */
        System.out.println("WW Studio Location: " + wwStudioElement.getText());
        System.out.println("WW Studio Distance: " + wwStudioDistance.getText());

        System.out.println("Clicking First WW Studio: ");
        if(wwStudioElement.isDisplayed() || wwStudioElement.isEnabled()){
            wwStudioElement.click();
        } else {
            System.err.println("ERROR: Element not found");
        }
        return new WWStudioPage(driver);
    }

}
