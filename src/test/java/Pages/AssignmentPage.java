package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignmentPage extends ParentPage {

    public AssignmentPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[data-testid='assignments-tab']")
    public WebElement assignmentsTab;

    @FindBy(css = ".assignment-item")
    public WebElement assignmentItem;

    @FindBy(css = ".assignment-title")
    public WebElement assignmentTitle;

    @FindBy(css = ".submit-button")
    public WebElement submitButton;

    @FindBy(css = ".submission-success-message")
    public WebElement successMessage;

    @FindBy(css = ".discussion-start-button")
    public WebElement startDiscussionButton;
}
