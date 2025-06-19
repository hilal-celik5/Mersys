package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends ParentPage {

    public CalendarPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[data-testid='calendar-tab']")
    public WebElement calendarTab;

    @FindBy(css = ".calendar-view-toggle button[data-view='weekly']")
    public WebElement weeklyViewButton;

    @FindBy(css = ".calendar-day")
    public WebElement calendarDay;

    @FindBy(css = ".calendar-event")
    public WebElement calendarEvent;

    @FindBy(css = ".recording-ended-message")
    public WebElement endedRecordingMessage;
}
