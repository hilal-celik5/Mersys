package StepDefinitions;

import Pages.CalendarPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalendarSteps {
    CalendarPage calendarPage = new CalendarPage();

    @Given("Student clicks hamburger menu to reach lecture recording")
    public void student_clicks_hamburger_menu_to_reach_lecture_recording() {
        calendarPage.myClick(calendarPage.hamburgerMenuButton);

        calendarPage.wait.until(ExpectedConditions.visibilityOf(calendarPage.hamburgerMenuPanel));
        calendarPage.myClick(calendarPage.videoConference);
        calendarPage.myClick(calendarPage.videoMeetings);
    }

    @When("Student chooses correct date and clicks on the recording button")
    public void student_chooses_correct_date_and_clicks_on_the_recording_button() {
        calendarPage.wait.until(ExpectedConditions.elementToBeClickable(calendarPage.calendarButton));
        calendarPage.myClick(calendarPage.calendarButton);
        calendarPage.myClick(calendarPage.thisYearLink);
        calendarPage.actions.sendKeys(Keys.ENTER).perform();
        calendarPage.clickWithJavaScript(calendarPage.searchButton);

        calendarPage.wait.until(ExpectedConditions.elementToBeClickable(calendarPage.recording));
        calendarPage.clickWithJavaScript(calendarPage.recording);
    }

    @Then("Students should be able to watch recording")
    public void students_should_be_able_to_watch_recording() throws InterruptedException {
        calendarPage.wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(calendarPage.iframe));

        for (int i = 0; i < 6; i++) {
            Thread.sleep(1000L * 2);
            calendarPage.actions.sendKeys(Keys.TAB).perform();
        }

        calendarPage.actions.sendKeys(Keys.ENTER).perform();
    }
}
