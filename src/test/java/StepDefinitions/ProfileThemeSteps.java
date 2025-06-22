package StepDefinitions;

import Pages.ProfilePage;
import Utilities.GWD;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class ProfileThemeSteps {

        WebDriver driver = GWD.getDriver();
        ProfilePage pp = new ProfilePage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        @Then("the Default Theme dropdown is visible")
        public void defaultThemeDropdownIsVisible() {
            wait.until(ExpectedConditions.visibilityOf(pp.themeDropdown));
            assertTrue(pp.themeDropdown.isDisplayed());
        }

        @When("student clicks the Default Theme dropdown")
        public void studentClicksTheDefaultThemeDropdown() {
            wait.until(ExpectedConditions.elementToBeClickable(pp.themeDropdown)).click();
        }

        @Then("there should be at least 3 theme options: purple, dark purple, indigo")
        public void thereShouldBeAtLeastThreeThemeOptions() {
            List<WebElement> opts = pp.themeOptions;
            assertTrue(opts.size() >= 3, "3'ten az seçenek var!");
            List<String> texts = opts.stream().map(WebElement::getText).toList();
            assertTrue(texts.contains("purple"));
            assertTrue(texts.contains("dark purple"));
            assertTrue(texts.contains("indigo"));
        }

        @When("student selects {string} from the Default Theme dropdown")
        public void studentSelectsTheme(String theme) {
            Select select = new Select(pp.themeDropdown);
            select.selectByVisibleText(theme);
        }

        @Then("the page DOM attribute {string} should equal {string}")
        public void thePageDomAttributeShouldEqual(String attr, String expected) {
            String actual = driver.findElement(By.tagName("body")).getAttribute(attr);
            assertEquals(expected, actual);
        }

        @When("student clicks the Save button")
        public void studentClicksTheSaveButton() {
            wait.until(ExpectedConditions.elementToBeClickable(pp.saveButton)).click();
        }

        @Then("success toast appears")
        public void successToastAppears() {
            wait.until(ExpectedConditions.visibilityOf(pp.toastMessage));
            assertTrue(pp.toastMessage.getText().toLowerCase().contains("success"));
        }
    }

