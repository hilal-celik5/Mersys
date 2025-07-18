package StepDefinitions;

import Pages.ProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ProfileSteps {
    ProfilePage profilePage = new ProfilePage();

    @Given("the student navigates to the profile settings page")
    public void the_student_navigates_to_the_profile_settings_page() {
        profilePage.myClick(profilePage.profile);
        profilePage.myClick(profilePage.settings);
    }

    @When("the student uploads a profile picture")
    public void the_student_uploads_a_profile_picture() throws AWTException {
        Robot robot = new Robot();

        profilePage.myClick(profilePage.profilePhoto);
        profilePage.myClick(profilePage.uploadPicture);

        String filePath = "C:\\Users\\Hilal ÇELİK\\Pictures\\Camera Roll\\WIN_20250619_10_45_43_Pro.jpg";
        profilePage.fileInput.sendKeys(filePath);

        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

        profilePage.myClick(profilePage.upload);
        profilePage.clickWithJavaScript(profilePage.save);
    }

    @Then("the student should see a {string} message")
    public void theStudentShouldSeeASuccessMessage(String expectedMessage) {
        profilePage.wait.until(ExpectedConditions.visibilityOf(profilePage.successMessage));
        String actualMessage = profilePage.successMessage.getText();
        Assert.assertTrue(actualMessage.toLowerCase().contains(expectedMessage.toLowerCase()));
    }

    @When("the student changes the theme")
    public void theStudentChangesTheTheme() {
        profilePage.myClick(profilePage.theme);
        profilePage.myClick(profilePage.darkPurpleTheme);
        profilePage.clickWithJavaScript(profilePage.save);
    }
}
