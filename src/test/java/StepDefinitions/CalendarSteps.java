package StepDefinitions;

import Pages.CalendarPage;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CalendarSteps {

    CalendarPage calendarPage = new CalendarPage();


    @And("There are past courses with recording access ended")
    public void there_are_past_courses_with_recording_access_ended() {
        Assert.assertTrue(calendarPage.pastCourseWithNoAccess.isDisplayed());
    }

    @When("User opens the calendar and selects a past date")
    public void user_opens_the_calendar_and_selects_a_past_date() {
        calendarPage.myClick(calendarPage.pastDateElement);
    }

    @Then("User should see a label or message indicating access to recordings has ended")
    public void user_should_see_a_label_or_message_indicating_access_to_recordings_has_ended() {
        calendarPage.wait.until(ExpectedConditions.visibilityOf(calendarPage.endedRecordingMessage));
        Assert.assertTrue(calendarPage.endedRecordingMessage.isDisplayed());
    }

    @Given("User is on the calendar and selects a past course with ended access")
    public void user_is_on_the_calendar_and_selects_a_past_course_with_ended_access() {
        calendarPage.myClick(calendarPage.pastCourseWithNoAccess);
    }

    @When("User clicks on the play button for the recording")
    public void user_clicks_on_the_play_button_for_the_recording() {
        calendarPage.myClick(calendarPage.playButton);
    }

    @Then("User should see a warning that access has ended and cannot play the recording")
    public void user_should_see_a_warning_that_access_has_ended_and_cannot_play_the_recording() {
        calendarPage.wait.until(ExpectedConditions.visibilityOf(calendarPage.warningAccessEnded));
        Assert.assertTrue(calendarPage.warningAccessEnded.isDisplayed());
    }

    @Given("There is a future course that has not started yet")
    public void there_is_a_future_course_that_has_not_started_yet() {
        Assert.assertTrue(calendarPage.futureCourseElement.isDisplayed());
    }

    @When("User selects the course date on the calendar")
    public void user_selects_the_course_date_on_the_calendar() {
        calendarPage.myClick(calendarPage.futureCourseElement);
    }

    @Then("Calendar block should show “Course not started yet”")
    public void calendar_block_should_show_course_not_started_yet() {
        Assert.assertTrue(calendarPage.notStartedMessage.isDisplayed());
    }

    @Given("Calendar displays a course that is not yet started")
    public void calendar_displays_a_course_that_is_not_yet_started() {
        Assert.assertTrue(calendarPage.futureCourseElement.isDisplayed());
    }

    @When("User tries to open its details or video")
    public void user_tries_to_open_its_details_or_video() {
        calendarPage.myClick(calendarPage.futureCourseDetailsButton);
    }

    @Then("User should see a message like “Course has not started yet”")
    public void user_should_see_a_message_like_course_has_not_started_yet() {
        Assert.assertTrue(calendarPage.notStartedMessage.isDisplayed());
    }

    @When("User switches to weekly view")
    public void user_switches_to_weekly_view() {
        calendarPage.myClick(calendarPage.weeklyViewButton);
    }

    @Then("Calendar should show 7 days horizontally with all scheduled sessions")
    public void calendar_should_show_days_horizontally_with_all_scheduled_sessions() {
        calendarPage.wait.until(ExpectedConditions.visibilityOf(calendarPage.calendarDay));
        Assert.assertEquals(calendarPage.weeklyDays.size(), 7, "7 gün görünmelidir");
    }

    @Given("User is in weekly calendar view")
    public void user_is_in_weekly_calendar_view() {
        calendarPage.myClick(calendarPage.weeklyViewButton);
        calendarPage.wait.until(ExpectedConditions.visibilityOf(calendarPage.calendarDay));
    }

    @When("User clicks on a specific day")
    public void user_clicks_on_a_specific_day() {
        calendarPage.myClick(calendarPage.specificDayElement);
    }

    @Then("System should expand and show details of the classes scheduled for that day")
    public void system_should_expand_and_show_details_of_the_classes_scheduled_for_that_day() {
        calendarPage.wait.until(ExpectedConditions.visibilityOf(calendarPage.dayDetailsContainer));
        Assert.assertTrue(calendarPage.dayDetailsContainer.isDisplayed());
    }

}
