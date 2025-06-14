package StepDefinitions;

import Pages.LoginPage;
import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("Navigate to login page")
    public void navigate_to_login_page() {
        GWD.getDriver().get("https://test.mersys.io/");
    }

    @Given("Enter valid username and password")
    public void enter_valid_username_and_password() {

        String path = "src/test/java/apachePOI/TestUserData.xlsx";
        String sheet = "Users";

        ArrayList<ArrayList<String>> data = ExcelUtility.getData(path, sheet, 2);

        String username = data.get(1).get(0);
        String password = data.get(1).get(1);

        loginPage.mySendKeys(loginPage.username, username);
        loginPage.mySendKeys(loginPage.password, password);
    }

    @When("Click login button")
    public void click_login_button() {
        loginPage.myClick(loginPage.loginButton);
    }

    @Then("User should login successfully")
    public void user_should_login_successfully() {
        loginPage.wait.until(ExpectedConditions.visibilityOf(loginPage.userIcon));
        Assert.assertTrue(loginPage.userIcon.isDisplayed());
    }

    @And("Enter invalid username and password")
    public void enterInvalidUsernameAndPassword() {
        loginPage.mySendKeys(loginPage.username, "wrongUser");
        loginPage.mySendKeys(loginPage.password, "wrongPass");
    }

    @Then("User should display error message")
    public void userShouldDisplayErrorMessage() {
        loginPage.wait.until(ExpectedConditions.visibilityOf(loginPage.errorMessage));
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Hata mesajı görüntülenmedi!");
    }
}