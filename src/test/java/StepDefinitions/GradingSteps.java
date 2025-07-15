package StepDefinitions;

import Pages.GradingPage;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

public class GradingSteps {
    GradingPage gradingPage = new GradingPage();

    @Given("the student navigates to the grading page")
    public void the_student_navigates_to_the_grading_page() {
        gradingPage.myClick(gradingPage.grading);
    }

    @Then("the grades table should be displayed")
    public void the_grades_table_should_be_displayed() {
        gradingPage.wait.until(ExpectedConditions.visibilityOf(gradingPage.gradeTable));
        Assert.assertTrue(gradingPage.gradeTable.isDisplayed());
    }

    @When("the student clicks the print icon")
    public void theStudentClicksThePrintIcon() {
        gradingPage.myClick(gradingPage.print);
    }

    @Then("the PDF document should be displayed")
    public void thePDFDocumentShouldBeDisplayed() {
        String mainWindowHandle = GWD.getDriver().getWindowHandle();

        gradingPage.wait.until(driver -> GWD.getDriver().getWindowHandles().size() > 1);
        Set<String> windowHandles = GWD.getDriver().getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                GWD.getDriver().switchTo().window(windowHandle);
                break;
            }
        }

        Assert.assertTrue(gradingPage.pdfDocument.isDisplayed());
    }

    @When("the student clicks the download button")
    public void theStudentClicksTheDownloadButton() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000 * 2);
            gradingPage.actions.sendKeys(Keys.TAB).perform();
        }

        gradingPage.actions.sendKeys(Keys.ENTER).perform();
    }

    @Then("the download button should trigger a file download")
    public void theDownloadButtonShouldTriggerAFileDownload() throws AWTException {
        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
