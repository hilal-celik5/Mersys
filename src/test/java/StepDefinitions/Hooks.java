package StepDefinitions;

import Pages.LoginPage;
import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Hooks {

    public static WebDriver driver;

    @Before("@LoginRequired")
    public void login() {
        LoginPage loginPage = new LoginPage();

        GWD.getDriver().get("https://test.mersys.io/");

        String path = "src/test/java/apachePOI/TestUserData.xlsx";
        String sheet = "Users";

        ArrayList<ArrayList<String>> data = ExcelUtility.getData(path, sheet, 2);
        String username = data.get(1).get(0);
        String password = data.get(1).get(1);

        loginPage.mySendKeys(loginPage.username, username);
        loginPage.mySendKeys(loginPage.password, password);
        loginPage.myClick(loginPage.loginButton);
    }

    @After
    public void after() {
        GWD.quitDriver();
    }
}
