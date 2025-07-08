package StepDefinitions;

import Pages.GradingPage;
import Utilities.GWD;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class GradingSteps {
    WebDriver driver = GWD.getDriver();
    GradingPage gp = new GradingPage();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("student opens {string}")
    public void openGradingPage(String menu) {
        wait.until(ExpectedConditions.elementToBeClickable(gp.gradingLink)).click();
    }

    @Then("the {string}, {string} and {string} tabs should be visible and clickable")
    public void verifyGradingTabs(String tab1, String tab2, String tab3) {
        wait.until(ExpectedConditions.visibilityOf(gp.courseGradeTab));
        assertTrue(gp.courseGradeTab.isDisplayed());
        assertTrue(gp.courseGradeTab.isEnabled());

        wait.until(ExpectedConditions.visibilityOf(gp.studentTranscriptTab));
        assertTrue(gp.studentTranscriptTab.isDisplayed());
        assertTrue(gp.studentTranscriptTab.isEnabled());

        wait.until(ExpectedConditions.visibilityOf(gp.transcriptBySubjectTab));
        assertTrue(gp.transcriptBySubjectTab.isDisplayed());
        assertTrue(gp.transcriptBySubjectTab.isEnabled());

    }
}
