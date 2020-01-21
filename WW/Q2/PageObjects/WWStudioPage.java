package Q2.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WWStudioPage {

    private WebDriver driver;
    private By hrsOfOp = By.className("hours-list-item");
    private By localName = By.className("location__name");
    private String expectedLocalName = "WW Studio Flatiron";
    private By dailySchedule = By.className("schedule-detailed-day");

    public WWStudioPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWWStudioPageTitle() {
        return driver.getTitle();
    }

    public String getLocalName() {
        WebElement localNameElement = driver.findElement(localName);
        return localNameElement.getText();
    }

    /**
     * Verify displayed location name/title matches
     * with the name of the first searched result that was clicked.
     * @return true if correct name and false otherwise
     */
    public boolean verifyLocationName(String expectedLocalName){
        return getLocalName().contains(expectedLocalName);

    }
    /**
     * Helper class to remove WW popup that could mess up the Q2.tests
     */
    private void removePopUp(){
        WebElement popUp = driver.findElement(By.className("bx-wrap"));
        WebElement popUpCloseBtn = driver.findElement(By.id("bx-close-inside-1110060"));
        if(popUp.isDisplayed() ){
            popUpCloseBtn.click();
        }
    }
    /**
     * From this location page, print TODAY’s hours of operation (located towards the bottom of the page)
     */
    public String printHrsOfOp(){
        List<WebElement> hrsOfOpElements = driver.findElements(hrsOfOp);
        System.out.println("Hours Of Operation:");
        StringBuilder stringBuilder = new StringBuilder();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //removePopUp();
        for (WebElement e : hrsOfOpElements) {
            System.out.println(e.getText());
            stringBuilder.append(e.getText() +"\n");
        }
        return stringBuilder.toString();

    }
    /**
     * Create a method to print the number of meeting the each person(under the scheduled time)
     * has a particular day of the week
     * @param dayOfWeek
     */
    public String printMeetings(String dayOfWeek){
        HashMap<String,Integer> meetingsMap = new HashMap<>();
        List<WebElement> dailyLst = driver.findElements(dailySchedule);
        for(WebElement day : dailyLst){
            String day_a = day.getText().substring(0,3);
            if(day_a.equalsIgnoreCase(dayOfWeek)){
                //every even add to hashmap
                String[] meetings = day.getText().split("\n");
                for(int i = 2; i <= meetings.length;i+=2){//increment by 2
                    if(meetingsMap.containsKey(meetings[i])){
                        meetingsMap.put(meetings[i],meetingsMap.get(meetings[i]) + 1);
                    }else{
                        meetingsMap.put(meetings[i],1);
                    }
                }
                //end loop since we found our day we were looking for
                break;
            }

        }
        StringBuilder sb = new StringBuilder();
        //Java 8 lambda to print out key and values of map
        System.out.println("Meetings for " + dayOfWeek + ":");
        meetingsMap.forEach((k,v) -> {
            sb.append(k + " " + v + "\n");
            System.out.println(k + " " + v);
        });
        return sb.toString();

    }

}
