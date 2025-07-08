package StepDefinitions;

import Pages.GradingPage;
import Utilities.GWD;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Set;

import static org.testng.AssertJUnit.assertTrue;

public class GradingDownloadSteps {
    WebDriver driver = GWD.getDriver();
    GradingPage gp = new GradingPage();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("student clicks the {string} tab")
    public void studentClicksTheSectionTab(String section) {
        if (section.equals("Course Grade")) {
            wait.until(ExpectedConditions.elementToBeClickable(gp.courseGradeTab)).click();
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(gp.studentTranscriptTab)).click();
        }
    }

    @When("student clicks the \"Print\" icon")
    public void studentClicksThePrintIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(gp.printIcon)).click();
    }

    @Then("a PDF viewer tab should open")
    public void pdfViewerTabShouldOpen() {
        String original = driver.getWindowHandle();
        wait.until(d -> d.getWindowHandles().size() > 1);

        Set<String> handles = driver.getWindowHandles();
        handles.remove(original);
        String pdfHandle = handles.iterator().next();
        driver.switchTo().window(pdfHandle);

        String url = driver.getCurrentUrl();
        assertTrue("PDF görüntüleyici açılmadı", url.toLowerCase().contains(".pdf"));
    }

    @When("student clicks the \"Download\" button")
    public void studentClicksTheDownloadButton() {
        wait.until(ExpectedConditions.elementToBeClickable(gp.downloadButton)).click();
    }

    @Then("the PDF file should be saved to the default download folder")
    public void pdfShouldBeSaved() throws Exception {

        Path downloads = Paths.get(System.getProperty("user.home"), "Downloads");

        boolean found = Files.list(downloads)
                .filter(p -> p.toString().toLowerCase().endsWith(".pdf"))
                .anyMatch(p -> {
                    try {
                        return Files.getLastModifiedTime(p)
                                .toMillis() > System.currentTimeMillis() - 5000;
                    } catch (Exception e) {
                        return false;
                    }
                });

        assertTrue("PDF dosyası indirilmedi!", found);

        driver.close();

        for (String h : driver.getWindowHandles()) {
            driver.switchTo().window(h);
            break;
        }
    }
}
