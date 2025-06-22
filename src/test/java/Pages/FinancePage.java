package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinancePage extends ParentPage{

    public FinancePage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }
    @FindBy(css = "[class*='mat-mdc-menu-trigger'] fa-icon")
    public WebElement hamburgerMenuButton;

    @FindBy(css = ".mat-mdc-menu-content")
    public WebElement hamburgerMenuPanel;

    @FindBy(xpath = "//span[text()='Finance']")
    public WebElement finance;

    @FindBy(xpath = "//span[text()='My Finance']")
    public WebElement myFinance;

    @FindBy(xpath = "//button[contains(@class, 'mat-mdc-menu-trigger')]//fa-icon")
    public WebElement hamburgerMenu;

    @FindBy(xpath = "//tbody[@role='rowgroup']/tr[2]")
    public WebElement student;

    @FindBy(xpath = "//span[text()='Fee/Balance Detail']")
    public WebElement balanceDetail;

    @FindBy(xpath = "//span[text()='Online Payment']")
    public WebElement onlinePayment;

    @FindBy(xpath = "//span[text()=' Student Fee ']")
    public WebElement payerInfo;

    @FindBy(xpath = "//label[text()='Stripe ']")
    public WebElement stripe;

    @FindBy(xpath = "//span[text()='Pay']")
    public WebElement payment;

    @FindBy(css = "[role='cell']>div>div>button")
    public WebElement threeDot;

    @FindBy(xpath = "//span[text()=' Excel Export ']")
    public WebElement excelExport;

    @FindBy(xpath = "//span[text()=' Pdf Export ']")
    public WebElement pdfExport;
}