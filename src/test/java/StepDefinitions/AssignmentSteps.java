package StepDefinitions;

import Pages.AssignmentPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AssignmentSteps {
    AssignmentPage assignmentPage = new AssignmentPage();

    @Given("Click on the assignments link")
    public void clickOnTheAssignmentsLink() {
        assignmentPage.myClick(assignmentPage.assignments);
    }

    @Then("The user must successfully log in and exit the site safely.")
    public void the_user_must_successfully_log_in_and_exit_the_site_safely() {
        for (WebElement e : assignmentPage.lessons) {
            assignmentPage.wait.until(ExpectedConditions.visibilityOf(e));
            Assert.assertTrue(e.isDisplayed());
        }
    }

    @When("You can see all tasks, messages and people assigned to you by entering your username and password and clicking the login button.")
    public void youCanSeeAllTasksMessagesAndPeopleAssignedToYouByEnteringYourUsernameAndPasswordAndClickingTheLoginButton() {

        assignmentPage.wait.until(ExpectedConditions.elementToBeClickable(assignmentPage.discussion));
        assignmentPage.myClick(assignmentPage.discussion);
        assignmentPage.wait.until(ExpectedConditions.elementToBeClickable(assignmentPage.chats));
        assignmentPage.myClick(assignmentPage.chats);
        assignmentPage.wait.until(ExpectedConditions.elementToBeClickable(assignmentPage.contacts));
        assignmentPage.myClick(assignmentPage.contacts);
        assignmentPage.wait.until(ExpectedConditions.elementToBeClickable(assignmentPage.attachFiles));
        assignmentPage.myClick(assignmentPage.attachFiles);
        assignmentPage.actions.sendKeys(Keys.ESCAPE);
    }

    @Then("The user must log in to the site securely, complete the given tasks and exit.")
    public void theUserMustLogInToTheSiteSecurelyCompleteTheGivenTasksAndExit() {
        assignmentPage.mySendKeys(assignmentPage.message, "hello : :D");
        assignmentPage.myClick(assignmentPage.sendButton);
        Assert.assertEquals(assignmentPage.lastMessage.getText(), "hello : :D");
    }
}