package StepDefinitions;

import Pages.AssignmentPage;
import Pages.LoginPage;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class AssignmentSteps {
    AssignmentPage assignmentPage = new AssignmentPage();
    LoginPage loginPage = new LoginPage();

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        GWD.getDriver().get("https://test.mersys.io/");
    }

    @And("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        loginPage.mySendKeys(loginPage.username, "Student_10");
        loginPage.mySendKeys(loginPage.password, "S12345");
        loginPage.myClick(loginPage.loginButton);
        loginPage.wait.until(ExpectedConditions.visibilityOf(loginPage.userIcon));
    }

    @Given("User is on the Assignments page")
    public void user_is_on_the_assignments_page() {
        GWD.getDriver().get("https://test.mersys.io/assignments");
        assignmentPage.wait.until(ExpectedConditions.visibilityOf(assignmentPage.assignmentListContainer));
    }

    @When("User types {string} into the search bar")
    public void user_types_into_the_search_bar(String keyword) {
        assignmentPage.mySendKeys(assignmentPage.searchInput, keyword);
        assignmentPage.myClick(assignmentPage.searchButton);
    }

    @Then("All assignments with titles containing {string} should be listed")
    public void all_assignments_with_titles_containing_should_be_listed(String keyword) {
        for (String title : assignmentPage.getVisibleAssignmentTitles()) {
            Assert.assertTrue(title.toLowerCase().contains(keyword.toLowerCase()),
                    "Title does not contain keyword: " + title);
        }
    }

    @When("User selects {string}")
    public void user_selects(String option) {
        switch (option) {
            case "Sort by Due Date: Earliest First":
                assignmentPage.myClick(assignmentPage.sortByDueDateAsc);
                break;
            case "Sort by Status: Incomplete First":
                assignmentPage.myClick(assignmentPage.sortByStatusIncompleteFirst);
                break;
            default:
                Assert.fail("Unknown sort option: " + option);
        }
    }

    @Then("Assignments should be displayed in order from nearest to farthest due date")
    public void assignments_should_be_displayed_in_order_from_nearest_to_farthest_due_date() {
        List<String> dueDates = assignmentPage.getVisibleAssignmentDueDates();
        List<String> sorted = assignmentPage.getSortedDatesAsc(dueDates);
        Assert.assertEquals(dueDates, sorted, "Assignments are not sorted by due date ascending.");
    }

    @Then("Incomplete assignments should appear before completed ones")
    public void incomplete_assignments_should_appear_before_completed_ones() {
        List<String> statuses = assignmentPage.getVisibleAssignmentStatuses();
        boolean seenComplete = false;
        for (String status : statuses) {
            if (status.equalsIgnoreCase("Completed")) {
                seenComplete = true;
            }
            if (status.equalsIgnoreCase("Incomplete") && seenComplete) {
                Assert.fail("Incomplete assignment listed after a completed one.");
            }
        }
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