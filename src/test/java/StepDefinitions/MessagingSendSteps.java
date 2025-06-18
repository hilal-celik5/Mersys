package StepDefinitions;

import Pages.MessagingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MessagingSendSteps {

    MessagingPage messagingPage = new MessagingPage();

    @Given("Click on the hamburger menu")
    public void click_on_the_hamburger_menu() {
        messagingPage.wait.until(ExpectedConditions.visibilityOf(messagingPage.menü));
        messagingPage.myClick(messagingPage.menü);
        messagingPage.myClick(messagingPage.messaging);
        messagingPage.myClick(messagingPage.sendMessage);
        messagingPage.myClick(messagingPage.addReceiver);
        messagingPage.myClick(messagingPage.select10);
    }

    @And("Enter Valid Information")
    public void enter_valid_ınformation() {
        messagingPage.myClick(messagingPage.addclose);
        messagingPage.mySendKeys(messagingPage.subject, "team");
        messagingPage.myClick(messagingPage.Save);
    }

    @When("Verify that Valid Information has been entered")
    public void verify_that_valid_ınformation_has_been_entered() {
        messagingPage.myClick(messagingPage.menü);
        messagingPage.myClick(messagingPage.messaging);
        messagingPage.myClick(messagingPage.outbox);
        messagingPage.wait.until(ExpectedConditions.visibilityOf(messagingPage.writing));
        Assert.assertEquals("team", messagingPage.writing.getText());
    }
}