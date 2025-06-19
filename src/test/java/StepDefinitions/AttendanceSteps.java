package StepDefinitions;

import Pages.AttendancePage;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AttendanceSteps {
    AttendancePage atendancePage = new AttendancePage();

    @Given("Navigate to Atendance page")
    public void navigate_to_atendance_page() throws InterruptedException {

        atendancePage.myClick(atendancePage.atendance);
        atendancePage.wait.until(ExpectedConditions.visibilityOf(atendancePage.atendanceExcuse));
        atendancePage.js.executeScript("arguments[0].click();", atendancePage.atendanceExcuse);
    }

    @When("Add an excuse message {string}")
    public void add_an_excuse_message(String message) {
        atendancePage.wait.until(ExpectedConditions.visibilityOf(atendancePage.addButton));
        atendancePage.js.executeScript("arguments[0].click();", atendancePage.addButton);
        atendancePage.wait.until(ExpectedConditions.visibilityOf(atendancePage.calendar));
        atendancePage.js.executeScript("arguments[0].click();", atendancePage.calendar);
        atendancePage.wait.until(ExpectedConditions.visibilityOf(atendancePage.date));
        atendancePage.js.executeScript("arguments[0].click();", atendancePage.date);
        atendancePage.mySendKeys(atendancePage.message, message);
    }

    @Then("User should send excuse message")
    public void user_should_send_excuse_message() {
        atendancePage.actions.sendKeys(Keys.TAB).perform();
        atendancePage.wait.until(ExpectedConditions.visibilityOf(atendancePage.send));
        atendancePage.js.executeScript("arguments[0].click();", atendancePage.send);
    }

    @When("Click on the edit message button")
    public void clickOnTheEditMessageButton(){
        atendancePage.wait.until(ExpectedConditions.visibilityOf(atendancePage.edit));
        atendancePage.js.executeScript("arguments[0].click();", atendancePage.edit);
    }

    @Then("Excuse message {string} should be send")
    public void excuseMessageShouldBeSend(String message) {
        atendancePage.wait.until(ExpectedConditions.visibilityOf(atendancePage.yourMessage));
        String sent = atendancePage.yourMessage.getText();
        System.out.println(sent);
        Assert.assertEquals(message, sent);

    }
}
