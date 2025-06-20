package StepDefinitions;

import Pages.FinancePage;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class FinanceSteps {
    FinancePage financePage = new FinancePage();
    @Given("Click on the Hamburger Icon")
    public void click_on_the_hamburger_icon(){
        financePage.wait.until(ExpectedConditions.visibilityOf(financePage.hamburgerMenu));
        financePage.myClick(financePage.hamburgerMenu);
        financePage.actions.moveToElement(financePage.Finance).pause(Duration.ofMillis(1000)).build().perform();
        financePage.myClick(financePage.MyFinance);
    }
    @Given("Navigate to Finance page")
    public void navigate_to_finance_page() {
        financePage.myClick(financePage.Student);
    }
    @When("Click on the Fee Balance Detail button")
    public void click_on_the_fee_balance_detail_button() {
        financePage.wait.until(ExpectedConditions.visibilityOf(financePage.BalanceDetail));
        Assert.assertTrue(financePage.BalanceDetail.isDisplayed());
        financePage.myClick(financePage.BalanceDetail);
    }
    @Then("Installment schedule should be visible")
    public void installment_schedule_should_be_visible() {
        financePage.wait.until(ExpectedConditions.visibilityOf(financePage.PayerInfo));
        Assert.assertTrue(financePage.PayerInfo.isDisplayed());
        financePage.myClick(financePage.OnlinePayment);
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
            File screenshot = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File("screenshots/payment_error.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

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
        File screenshot = ((TakesScreenshot)GWD.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshots/balance_check_error.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assert.fail("Balance check could not be performed because the payment was unsuccessful.");
    }
}
