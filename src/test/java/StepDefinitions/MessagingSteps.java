package StepDefinitions;

import Pages.MessagingPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class MessagingSteps {
    MessagingPage messagingPage = new MessagingPage();

    @When("The user clicks on the Hamburger Menu and hovers over the Messaging link")
    public void theUserClicksOnTheHamburgerMenuAndHoversOverTheMessagingLink() {
        messagingPage.wait.until(ExpectedConditions.elementToBeClickable(messagingPage.hamburgerMenuButton));
        messagingPage.myClick(messagingPage.hamburgerMenuButton);

        messagingPage.wait.until(ExpectedConditions.visibilityOf(messagingPage.hamburgerMenuPanel));
        messagingPage.actions.moveToElement(messagingPage.messaging).perform();
    }

    @Then("the following submenu items should be visible and clickable:")
    public void theFollowingSubmenuItemsShouldBeVisibleAndClickable(DataTable dataTable) {
        List<String> linkList = dataTable.asList();

        for (String link : linkList) {
            WebElement menuElement = messagingPage.getWebElement(link);

            messagingPage.wait.until(ExpectedConditions.visibilityOf(menuElement));
            Assert.assertTrue(menuElement.isDisplayed(), link + "is not visible");

            messagingPage.wait.until(ExpectedConditions.elementToBeClickable(menuElement));
        }
    }

    @Given("Click on the hamburger menu")
    public void click_on_the_hamburger_menu() {
        messagingPage.wait.until(ExpectedConditions.visibilityOf(messagingPage.hamburgerMenuButton));
        messagingPage.myClick(messagingPage.hamburgerMenuButton);
        messagingPage.myClick(messagingPage.messaging);
        messagingPage.myClick(messagingPage.sendMessage);
        messagingPage.myClick(messagingPage.addReceiver);
        messagingPage.myClick(messagingPage.select10);
    }

    @And("Enter Valid Information")
    public void enter_valid_ınformation() {
        messagingPage.myClick(messagingPage.addClose);
        messagingPage.mySendKeys(messagingPage.subject, "team");
        messagingPage.myClick(messagingPage.save);
    }

    @When("Verify that Valid Information has been entered")
    public void verify_that_valid_ınformation_has_been_entered() {
        messagingPage.myClick(messagingPage.hamburgerMenuButton);
        messagingPage.myClick(messagingPage.messaging);
        messagingPage.myClick(messagingPage.outbox);
        messagingPage.wait.until(ExpectedConditions.visibilityOf(messagingPage.writing));
        Assert.assertEquals("team", messagingPage.writing.getText());
    }

    @Given("Click on Trash under the Messages section from the Hamburger Menu.")
    public void click_on_trash_under_the_messages_section_from_the_hamburger_menu() {
        messagingPage.wait.until(ExpectedConditions.visibilityOf(messagingPage.hamburgerMenuButton));
        messagingPage.myClick(messagingPage.hamburgerMenuButton);
        messagingPage.myClick(messagingPage.messaging);
    }

    @Given("Delete one of the messages you moved to the Trash.")
    public void delete_one_of_the_messages_you_moved_to_the_trash() {
        messagingPage.myClick(messagingPage.trash);
        messagingPage.myClick(messagingPage.restore);
    }

    @Then("Get the confirmation message after deleting it.")
    public void get_the_confirmation_message_after_deleting_it() {
        messagingPage.wait.until(ExpectedConditions.visibilityOf(messagingPage.undo));
        Assert.assertEquals("Message successfully restored from trash", messagingPage.undo.getText());
    }

    @Given("Have the student click on Hamburger Menu, then go to Messaging, and select Outbox.")
    public void have_the_student_click_on_hamburger_menu_then_go_to_messaging_and_select_outbox() {

        messagingPage.myClick(messagingPage.hamburgerMenuButton);
        messagingPage.wait.until(ExpectedConditions.visibilityOf(messagingPage.hamburgerMenuPanel));
        messagingPage.myClick(messagingPage.messaging);
    }

    @Given("Go to the Outbox and view the pages.")
    public void go_to_the_outbox_and_view_the_pages () {
        messagingPage.myClick(messagingPage.outbox);
        messagingPage.wait.until(ExpectedConditions.visibilityOf(messagingPage.productNameList));
        messagingPage.myClick(messagingPage.productNameList);
        messagingPage.myClick(messagingPage.yes);
    }

    @Then("Confirmation message after deletion")
    public void confirmation_message_after_deletion () {
        messagingPage.wait.until(ExpectedConditions.visibilityOf(messagingPage.confirmationMessage));
        Assert.assertEquals("Message successfully moved to trash!", messagingPage.confirmationMessage.getText());
    }
}