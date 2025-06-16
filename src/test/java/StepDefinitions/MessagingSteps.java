package StepDefinitions;

import Pages.MessagingPage;
import io.cucumber.datatable.DataTable;
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
}