package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinancePage extends ParentPage {

    public FinancePage() {
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

    @FindBy(xpath = "//span[text()='Finance']")
    public WebElement Finance;

    @FindBy(xpath = "//span[text()='My Finance']")
    public WebElement MyFinance;

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
