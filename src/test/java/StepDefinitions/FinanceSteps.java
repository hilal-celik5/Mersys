package StepDefinitions;

import Pages.FinancePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FinanceSteps {
    Pages.FinancePage FinancePage = new FinancePage();

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        FinancePage.myClick(FinancePage.hamburgerMenuButton);
    }

    @And("the user has finance access permissions")
    public void the_user_has_finance_access_permissions() {
        FinancePage.wait.until(ExpectedConditions.visibilityOf(FinancePage.hamburgerMenuPanel));
        FinancePage.myClick(FinancePage.Finance);
    }

    @When("the user navigates to the Finance page")
    public void the_user_navigates_to_the_finance_page() {
        FinancePage.myClick(FinancePage.MyFinance);
        FinancePage.wait.until(ExpectedConditions.urlContains("finance"));
    }
}
