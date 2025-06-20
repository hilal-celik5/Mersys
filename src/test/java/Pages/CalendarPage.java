package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CalendarPage extends ParentPage {
    public WebDriverWait wait;

    public CalendarPage() {
        PageFactory.initElements(GWD.getDriver(), this);
        wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
    }

    @FindBy(css = "div.calendar-body")
    public WebElement calendarBody;

    @FindBy(xpath = "//div[contains(@class, 'past-course-ended')]")
    public WebElement pastCourseWithNoAccess;

    @FindBy(xpath = "//div[@data-date='past-date']")
    public WebElement pastDateElement;

    @FindBy(xpath = "//div[contains(text(),'Access to recordings has ended')]")
    public WebElement endedRecordingMessage;

    @FindBy(css = "button.play-recording")
    public WebElement playButton;

    @FindBy(css = "div.warning-access-ended")
    public WebElement warningAccessEnded;

    @FindBy(xpath = "//div[contains(@class, 'future-course')]")
    public WebElement futureCourseElement;

    @FindBy(xpath = "//div[contains(text(), 'Course not started yet')]")
    public WebElement notStartedMessage;

    @FindBy(xpath = "//button[contains(@class, 'future-course-details')]")
    public WebElement futureCourseDetailsButton;

    @FindBy(xpath = "//button[contains(@class,'weekly-view-button')]")
    public WebElement weeklyViewButton;

    @FindBy(xpath = "//div[contains(@class,'calendar-week-day')]")
    public WebElement calendarDay;

    @FindBy(xpath = "//div[contains(@class,'calendar-week-day')]")
    public List<WebElement> weeklyDays;

    @FindBy(xpath = "//div[contains(@class,'calendar-day') and @data-clickable='true']")
    public WebElement specificDayElement;

    @FindBy(xpath = "//div[contains(@class,'day-details-container')]")
    public WebElement dayDetailsContainer;


    public void myClick(WebElement element) {
        element.click();
    }


    public void mySendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
}

