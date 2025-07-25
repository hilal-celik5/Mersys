package StepDefinitions;

import Pages.AssignmentPage;

import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
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

    @Then("Submit icon should be visible on each assignment row")
    public void submitIconShouldBeVisibleOnEachAssignmentRow() {
        for (WebElement e : assignmentPage.submitList) {
            assignmentPage.wait.until(ExpectedConditions.visibilityOf(e));
            Assert.assertTrue(e.isDisplayed());
        }
    }

    @When("Clicks on an assignment and uploads a file")
    public void clicksOnAnAssignmentAndUploadsAFile() {
        assignmentPage.wait.until(ExpectedConditions.elementToBeClickable(assignmentPage.submitButton));
        assignmentPage.clickWithJavaScript(assignmentPage.submitButton);

        assignmentPage.myClick(assignmentPage.attachFilesButton);
        assignmentPage.myClick(assignmentPage.fromMyFiles);

        assignmentPage.wait.until(ExpectedConditions.visibilityOf(assignmentPage.checkBox));
        assignmentPage.clickWithJavaScript(assignmentPage.checkBox);

        assignmentPage.myClick(assignmentPage.select);
        assignmentPage.myClick(assignmentPage.saveAsDraft);
        assignmentPage.myClick(assignmentPage.submit);
        assignmentPage.myClick(assignmentPage.confirmYes);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        assignmentPage.wait.until(ExpectedConditions.visibilityOf(assignmentPage.successMessages));
        String message = assignmentPage.successMessages.getText();
        Assert.assertTrue(message.toLowerCase().contains("success"));
    }

    @When("The student clicks the New Submission button on an assignment detail page")
    public void theStudentClicksTheNewSubmissionButtonOnAnAssignmentDetailPage() {
        assignmentPage.myClick(assignmentPage.infoButton);
        assignmentPage.myClick(assignmentPage.newSubmission);
    }

    @Then("A text editor should appear as a popup")
    public void aTextEditorShouldAppearAsAPopup() {
        assignmentPage.wait.until(ExpectedConditions.visibilityOf(assignmentPage.textEditor));
        Assert.assertTrue(assignmentPage.textEditor.isDisplayed());
    }

    @And("Selects a random assignment row and checks the visibility and clickable of action icons")
    public void selectsARandomAssignmentRowAndChecksTheVisibilityAndClickableOfActionIcons() throws InterruptedException {
        int size = assignmentPage.assignmentRows.size();
        Assert.assertTrue(size > 0, "Ödev listesi boş, işlem yapılamaz.");

        int num = assignmentPage.random.nextInt(size);
        WebElement selectedLesson = assignmentPage.assignmentRows.get(num);

        WebElement infoIcon = selectedLesson.findElement(By.cssSelector("[icon='info']"));
        WebElement submitIcon = selectedLesson.findElement(By.cssSelector("[icon='file-import']>button"));
        WebElement markIcon = selectedLesson.findElement(By.cssSelector("[icon='file-import']>button"));

        Assert.assertTrue(infoIcon.isDisplayed() && infoIcon.isEnabled());
        Assert.assertTrue(submitIcon.isDisplayed() && submitIcon.isEnabled());
        Assert.assertTrue(markIcon.isDisplayed() && markIcon.isEnabled());
    }

    @Then("Clicks on the information icon and verifies redirection to the assignment info page")
    public void clicksOnTheInformationIconAndVerifiesRedirectionToTheAssignmentInfoPage() {
        assignmentPage.wait.until(ExpectedConditions.elementToBeClickable(assignmentPage.defaultDetail));
        assignmentPage.myClick(assignmentPage.defaultDetail);

        assignmentPage.wait.until(ExpectedConditions.urlContains("assignments/info"));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("assignments/info"));
    }
}