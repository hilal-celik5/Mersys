package StepDefinitions;

import Pages.LoginPage;
import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Hooks {

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
    public void after(Scenario scenario) {

        ExcelUtility.writeToExcel("src/test/java/ApachePOI/ScenarioResults.xlsx",
                scenario, GWD.getThreadBrowserName());

        File screenshot = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshots", scenario.getName() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        GWD.quitDriver();
    }
}
