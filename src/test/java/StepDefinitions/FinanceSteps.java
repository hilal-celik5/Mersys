package StepDefinitions;

import Pages.FinancePage;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class FinanceSteps {
    FinancePage fp = new FinancePage();
    Actions actions = new Actions(GWD.getDriver());

    @Given("Click on the Hamburger Icon")
    public void click_on_the_hamburger_icon() throws InterruptedException {
        Thread.sleep(Duration.ofMillis(3000));
        fp.myClick(fp.hamburgerMenu);
        actions.moveToElement(fp.Finance).pause(Duration.ofMillis(1000)).build().perform();
        fp.myClick(fp.MyFinance);
    }

    @Given("Navigate to Finance page")
    public void navigate_to_finance_page() {
        fp.myClick(fp.Student);
    }

    @When("Click on the Fee Balance Detail button")
    public void click_on_the_fee_balance_detail_button() {
        fp.wait.until(ExpectedConditions.visibilityOf(fp.BalanceDetail));
        Assert.assertTrue(fp.BalanceDetail.isDisplayed());
        fp.myClick(fp.BalanceDetail);
    }

    @Then("Installment schedule should be visible")
    public void installment_schedule_should_be_visible() {
        fp.wait.until(ExpectedConditions.visibilityOf(fp.PayerInfo));
        Assert.assertTrue(fp.PayerInfo.isDisplayed());
        fp.myClick(fp.OnlinePayment);
    }

    @When("Click on the stripe")
    public void clickOnTheStripe() {
        fp.myClick(fp.stripe);
    }

    @Then("Student should be able to do payment")
    public void studentShouldBeAbleToDoPayment() {
        String beforeclick = GWD.getDriver().getCurrentUrl();
        fp.myClick(fp.payment);
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

        fp.myClick(fp.excelExport);
        fp.myClick(fp.threeDot);
        fp.myClick(fp.pdfExport);
        String originalWindow = GWD.getDriver().getWindowHandle();
        fp.wait.until(driver -> GWD.getDriver().getWindowHandles().size() > 1);
        Set<String> allWindows = GWD.getDriver().getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                GWD.getDriver().switchTo().window(window);
                break;
            }
        }
        Thread.sleep(2000);
        for (int i = 0; i <10 ; i++) {
            actions.sendKeys(Keys.TAB).pause(Duration.ofMillis(500));
        }
            actions.sendKeys(Keys.ENTER).pause(Duration.ofMillis(1000));
            actions.sendKeys(Keys.ENTER).pause(Duration.ofMillis(1000));

        actions.perform();
    }

    @When("Click on the three dot")
    public void clickOnTheThreeDot() throws InterruptedException {
        fp.myClick(fp.threeDot);
        fp.wait.until(ExpectedConditions.visibilityOf(fp.pdfExport));
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
