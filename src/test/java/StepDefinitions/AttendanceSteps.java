package StepDefinitions;

import Pages.AttendancePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AttendanceSteps {
    AttendancePage attendancePage = new AttendancePage();
    @Given("Navigate to Attendance page")
    public void navigate_to_attendance_page(){
        attendancePage.myClick(attendancePage.attendance);
        attendancePage.wait.until(ExpectedConditions.visibilityOf(attendancePage.attendanceExcuse));
        attendancePage.js.executeScript("arguments[0].click();", attendancePage.attendanceExcuse);
    }
    @When("Add an excuse message {string}")
    public void add_an_excuse_message(String message) {
        attendancePage.wait.until(ExpectedConditions.visibilityOf(attendancePage.addButton));
        attendancePage.js.executeScript("arguments[0].click();", attendancePage.addButton);
        attendancePage.wait.until(ExpectedConditions.visibilityOf(attendancePage.calendar));
        attendancePage.js.executeScript("arguments[0].click();", attendancePage.calendar);
        attendancePage.wait.until(ExpectedConditions.visibilityOf(attendancePage.date));
        attendancePage.js.executeScript("arguments[0].click();", attendancePage.date);
        attendancePage.mySendKeys(attendancePage.message, message);
    }
    @Then("User should send excuse message")
    public void user_should_send_excuse_message() {
        attendancePage.actions.sendKeys(Keys.TAB).perform();
        attendancePage.wait.until(ExpectedConditions.visibilityOf(attendancePage.send));
        attendancePage.js.executeScript("arguments[0].click();", attendancePage.send);
    }
    @When("Click on the edit message button")
    public void clickOnTheEditMessageButton(){
        attendancePage.wait.until(ExpectedConditions.visibilityOf(attendancePage.edit));
        attendancePage.js.executeScript("arguments[0].click();", attendancePage.edit);
    }
    @Then("Excuse message {string} should be send")
    public void excuseMessageShouldBeSend(String message) {
        attendancePage.wait.until(ExpectedConditions.visibilityOf(attendancePage.yourMessage));
        String sent = attendancePage.yourMessage.getText();
        System.out.println(sent);
        Assert.assertEquals(message, sent);
    }
}
