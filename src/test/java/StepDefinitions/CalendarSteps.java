package StepDefinitions;

import Pages.CalendarPage;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CalendarSteps {
    CalendarPage calendarPage = new CalendarPage();

    @Given("Navigate to calendar page")
    public void navigate_to_calendar_page() {
        GWD.getDriver().get("https://test.mersys.io/calendar");
    }

    @When("User switches to weekly view")
    public void user_switches_to_weekly_view() {
        calendarPage.myClick(calendarPage.weeklyViewButton);
    }

    @Then("Calendar should display weekly schedule")
    public void calendar_should_display_weekly_schedule() {
        calendarPage.wait.until(ExpectedConditions.visibilityOf(calendarPage.calendarDay));
        Assert.assertTrue(calendarPage.calendarDay.isDisplayed());
    }

    @And("User sees ended recording label")
    public void user_sees_ended_recording_label() {
        calendarPage.wait.until(ExpectedConditions.visibilityOf(calendarPage.endedRecordingMessage));
        Assert.assertTrue(calendarPage.endedRecordingMessage.isDisplayed());
    }
}
