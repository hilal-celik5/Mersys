package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagingPage extends ParentPage {

    public MessagingPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[class*='mat-mdc-menu-trigger'] fa-icon")
    public WebElement hamburgerMenuButton;

    @FindBy(css = ".mat-mdc-menu-content")
    public WebElement hamburgerMenuPanel;

    @FindBy(xpath = "//span[text()='Messaging']")
    public WebElement messaging;

    @FindBy(xpath = "//span[text()='Send Message']")
    public WebElement sendMessage;

    @FindBy(xpath = "//span[text()='Inbox']")
    public WebElement inbox;

    @FindBy(xpath = "//span[text()='Outbox']")
    public WebElement outbox;

    @FindBy(xpath = "//span[text()='Trash']")
    public WebElement trash;

    @FindBy(css = "[tooltip='USER_MESSAGES.BUTTONS.RECEIVER']")
    public WebElement addReceiver;

    @FindBy (css = "[class='mdc-data-table__content ng-star-inserted']")
    public WebElement select10;

    @FindBy(xpath = "//span[text()='Add & Close']")
    public WebElement addClose;

    @FindBy(css = "[class='mat-mdc-input-element mat-mdc-form-field-input-control mdc-text-field__input cdk-text-field-autofill-monitored']")
    public WebElement subject;

    @FindBy(css = "[icon='save']")
    public WebElement save;

    @FindBy(xpath = "//div[text()='team']")
    public WebElement writing;

    @FindBy(css = "[icon='shopping-basket'][id='ms-button-2']")
    public WebElement productNameList;

    @FindBy(xpath = "//span[text()=' Yes ']")
    public WebElement yes;

    @FindBy(xpath = "//div[text()='Message successfully moved to trash!']")
    public WebElement confirmationMessage;

    @FindBy (css = "[icon='trash-restore'][class='ng-star-inserted'][id='ms-standard-button-2']")
    public WebElement restore;

    @FindBy (xpath = "//div[text()='Message successfully restored from trash']")
    public WebElement undo;

    public WebElement getWebElement(String element) {

        switch (element) {
            case "hamburger menu":
                return this.hamburgerMenuButton;
            case "messaging":
                return this.messaging;
            case "Send Message":
                return this.sendMessage;
            case "Inbox":
                return this.inbox;
            case "Outbox":
                return this.outbox;
            case "Trash":
                return this.trash;
        }
        return null;
    }
}