package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends ParentPage {

    public CalendarPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "button[class*='mat-mdc-menu-trigger'] fa-icon")
    public WebElement hamburgerMenuButton;

    @FindBy(css = ".mat-mdc-menu-content")
    public WebElement hamburgerMenuPanel;

    @FindBy(xpath = "//span[text()='Video Conference']")
    public WebElement videoConference;

    @FindBy(xpath = "//span[text()='Video Meetings']")
    public WebElement videoMeetings;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement calendarButton;

    @FindBy(xpath = "//span[text()=' This year ']")
    public WebElement thisYearLink;

    @FindBy(xpath = "//span[text()='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "(//button[@matbadgecolor='accent'])[2]")
    public WebElement recording;

    @FindBy(xpath = "//iframe[@class='ng-star-inserted'] ")
    public WebElement iframe;

}
