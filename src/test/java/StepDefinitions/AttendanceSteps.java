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
    AttendancePage atp = new AttendancePage();
    Actions actions = new Actions(GWD.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

    @Given("Navigate to Atendance page")
    public void navigate_to_atendance_page() throws InterruptedException {

        atp.myClick(atp.atendance);
        atp.wait.until(ExpectedConditions.visibilityOf(atp.atendanceExcuse));
        js.executeScript("arguments[0].click();", atp.atendanceExcuse);
    }

    @When("Add an excuse message {string}")
    public void add_an_excuse_message(String message) {
        atp.wait.until(ExpectedConditions.visibilityOf(atp.addButton));
        js.executeScript("arguments[0].click();", atp.addButton);
        atp.wait.until(ExpectedConditions.visibilityOf(atp.calendar));
        js.executeScript("arguments[0].click();", atp.calendar);
        atp.wait.until(ExpectedConditions.visibilityOf(atp.date));
        js.executeScript("arguments[0].click();", atp.date);
        atp.mySendKeys(atp.message, message);
    }

    @Then("User should send excuse message")
    public void user_should_send_excuse_message() {
        actions.sendKeys(Keys.TAB).perform();
        atp.wait.until(ExpectedConditions.visibilityOf(atp.send));
        js.executeScript("arguments[0].click();", atp.send);
    }

    @When("Click on the edit message button")
    public void clickOnTheEditMessageButton(){
        atp.wait.until(ExpectedConditions.visibilityOf(atp.edit));
        js.executeScript("arguments[0].click();", atp.edit);
    }

    @Then("Excuse message {string} should be send")
    public void excuseMessageShouldBeSend(String message) {
        atp.wait.until(ExpectedConditions.visibilityOf(atp.yourMessage));
        String sent = atp.yourMessage.getText();
        System.out.println(sent);
        Assert.assertEquals(message, sent);

    }
}
