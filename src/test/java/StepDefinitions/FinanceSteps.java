package StepDefinitions;

import Pages.FinancePage;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.time.Duration;
import java.util.Set;


public class FinanceSteps {
    FinancePage financePage = new FinancePage();

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        financePage.myClick(financePage.hamburgerMenuButton);
    }

    @And("the user has finance access permissions")
    public void the_user_has_finance_access_permissions() {
        financePage.wait.until(ExpectedConditions.visibilityOf(financePage.hamburgerMenuPanel));
        financePage.myClick(financePage.finance);
    }

    @When("the user navigates to the Finance page")
    public void the_user_navigates_to_the_finance_page() {
        financePage.myClick(financePage.myFinance);
        financePage.wait.until(ExpectedConditions.urlContains("finance"));
    }

    @Given("Click on the Hamburger Icon")
    public void click_on_the_hamburger_icon(){
        financePage.wait.until(ExpectedConditions.elementToBeClickable(financePage.hamburgerMenu));
        financePage.myClick(financePage.hamburgerMenu);
        financePage.actions.moveToElement(financePage.finance).pause(Duration.ofMillis(2000)).build().perform();
        financePage.myClick(financePage.myFinance);
    }
    @Given("Navigate to Finance page")
    public void navigate_to_finance_page() {
        financePage.wait.until(ExpectedConditions.elementToBeClickable(financePage.student));
        financePage.myClick(financePage.student);
    }
    @When("Click on the Fee Balance Detail button")
    public void click_on_the_fee_balance_detail_button() {
        financePage.wait.until(ExpectedConditions.visibilityOf(financePage.balanceDetail));
        Assert.assertTrue(financePage.balanceDetail.isDisplayed());
        financePage.myClick(financePage.balanceDetail);
    }

    @Then("Installment schedule should be visible")
    public void installment_schedule_should_be_visible() {
        financePage.wait.until(ExpectedConditions.visibilityOf(financePage.payerInfo));
        Assert.assertTrue(financePage.payerInfo.isDisplayed());
        financePage.myClick(financePage.onlinePayment);
    }

    @When("Click on the stripe")
    public void clickOnTheStripe() {
        financePage.myClick(financePage.stripe);
    }
    @Then("Student should be able to do payment")
    public void studentShouldBeAbleToDoPayment() {
        String beforeclick = GWD.getDriver().getCurrentUrl();
        financePage.myClick(financePage.payment);
        String afterclick = GWD.getDriver().getCurrentUrl();

        if (beforeclick.equals(afterclick)) {
            Assert.fail("Payment failed: URL did not change after clicking the payment button.");
        }
    }
    @Then("Student should be able to download report form from Three-dot menu button")
    public void studentShouldBeAbleToDownloadReportFormFromThreeDotMenuButton() throws InterruptedException {

        financePage.myClick(financePage.excelExport);
        financePage.myClick(financePage.threeDot);
        financePage.myClick(financePage.pdfExport);
        String originalWindow = GWD.getDriver().getWindowHandle();
        financePage.wait.until(driver -> GWD.getDriver().getWindowHandles().size() > 1);
        Set<String> allWindows = GWD.getDriver().getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                GWD.getDriver().switchTo().window(window);
                break;
            }
        }
        Thread.sleep(2000);
        for (int i = 0; i <10 ; i++) {
            financePage.actions.sendKeys(Keys.TAB).pause(Duration.ofMillis(500));
        }
        financePage.actions.sendKeys(Keys.ENTER).pause(Duration.ofMillis(1000));
        financePage.actions.sendKeys(Keys.ENTER).pause(Duration.ofMillis(1000));

        financePage.actions.perform();
    }

    @When("Click on the three dot")
    public void clickOnTheThreeDot() throws InterruptedException {
        financePage.myClick(financePage.threeDot);
        financePage.wait.until(ExpectedConditions.visibilityOf(financePage.pdfExport));
    }
    @Then("Student should be able to see updated balance")
    public void studentShouldBeAbleToSeeUpdatedBalance() {
        Assert.fail("Balance check could not be performed because the payment was unsuccessful.");
    }
}