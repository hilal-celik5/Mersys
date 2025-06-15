package StepDefinitions;

import Pages.HomePage;
import Utilities.GWD;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Set;

public class HomeNavigationSteps {
    HomePage homePage = new HomePage();

    @When("The user clicks on the company logo")
    public void the_user_clicks_on_the_company_logo() {
        homePage.wait.until(ExpectedConditions.elementToBeClickable(homePage.companyLogo));
        homePage.myClick(homePage.companyLogo);
    }

    @Then("The user should be redirected to the Techno Study homepage")
    public void the_user_should_be_redirected_to_the_techno_study_homepage() {
        String mainWindowHandle = GWD.getDriver().getWindowHandle();

        homePage.wait.until(driver -> GWD.getDriver().getWindowHandles().size() > 1);
        Set<String> windowHandles = GWD.getDriver().getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                GWD.getDriver().switchTo().window(windowHandle);
            }
        }

        homePage.wait.until(ExpectedConditions.urlContains("techno"));

        Assert.assertEquals(GWD.getDriver().getCurrentUrl(), "https://techno.study/");
    }
}