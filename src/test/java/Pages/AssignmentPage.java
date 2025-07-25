package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AssignmentPage extends ParentPage {

    public AssignmentPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@aria-hidden='true' and @data-prefix='fal'])[4]")
    public WebElement assignments;

    @FindBy(xpath = "//strong[starts-with(text(), '11A')]")
    public List<WebElement> lessons;

    @FindBy(xpath = "(//button[@matbadgesize='medium'])[4]")
    public WebElement discussion;

    @FindBy(xpath = "(//button[@matbadgesize='medium'])[27]")
    public WebElement chats;

    @FindBy(xpath = "(//button[@matbadgesize='medium'])[28]")
    public WebElement contacts;

    @FindBy(xpath = "(//button[@matbadgesize='medium'])[31]")
    public WebElement attachFiles;

    @FindBy(xpath = "(//button[@matbadgesize='medium'])[33]")
    public WebElement sendButton;

    @FindBy(css = "[formcontrolname='commentText']")
    public WebElement message;

    @FindBy(xpath = "(//div[@fxlayout='row wrap']/bdi)[last()]")
    public WebElement lastMessage;

    @FindBy(xpath = "//span[text()='Attach Files...']")
    public WebElement attachFilesButton;

    @FindBy(xpath = "(//button[@role='menuitem'])[9]")
    public WebElement fromMyFiles;

    @FindBy(xpath = "#mat-mdc-checkbox-1-input")
    public WebElement checkBox;

    @FindBy(xpath = "//*[text()='Select']")
    public WebElement select;

    @FindBy(xpath = "//span[text()='Submit']")
    public WebElement submit;

    @FindBy(xpath = "//*[text()='Save as Draft']")
    public WebElement saveAsDraft;

    @FindBy(xpath = "(//*[text()='Submit'])[2]")
    public WebElement button;

    @FindBy(css = "button[type='submit'] >:nth-child(2)")
    public WebElement confirmYes;

    @FindBy(xpath = " //*[text()='New Submission']")
    public WebElement newSubmission;

    @FindBy(css = "[icon='file-import']")
    public List<WebElement> submitList;

    @FindBy(xpath = "(//*[@icon='file-import']/button)[1]")
    public WebElement submitButton;

    @FindBy(css = "[class='mat-accordion']")
    public WebElement successMessages;

    @FindBy(xpath = "//*[contains(@class, 'mat-mdc-dialog-container')]")
    public WebElement textEditor;

    @FindBy(css = "[class='assignment']")
    public List<WebElement> assignmentRows;

    @FindBy(xpath = "(//div[@fxlayout='row'])[18]")
    public WebElement defaultDetail;

    @FindBy(css = "[icon='info']")
    public WebElement infoButton;
}