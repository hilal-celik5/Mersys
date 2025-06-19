package StepDefinitions;

import Pages.AssignmentPage;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AssignmentSteps {
    AssignmentPage assignmentPage = new AssignmentPage();

    @Given("Navigate to assignment page")
    public void navigate_to_assignment_page() {
        GWD.getDriver().get("https://test.mersys.io/assignments");
    }

    @When("User clicks submit button for assignment")
    public void user_clicks_submit_button_for_assignment() {
        assignmentPage.myClick(assignmentPage.submitButton);
    }

    @Then("User should see submission success message")
    public void user_should_see_submission_success_message() {
        assignmentPage.wait.until(ExpectedConditions.visibilityOf(assignmentPage.successMessage));
        Assert.assertTrue(assignmentPage.successMessage.isDisplayed());
    }

    @And("User clicks start discussion for assignment")
    public void user_clicks_start_discussion_for_assignment() {
        assignmentPage.myClick(assignmentPage.startDiscussionButton);
    }
}
