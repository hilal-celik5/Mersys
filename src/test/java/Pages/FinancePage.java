package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinancePage extends ParentPage {
    public FinancePage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }
    @FindBy(xpath = "//button[contains(@class, 'mat-mdc-menu-trigger')]//fa-icon")
    public WebElement hamburgerMenu;

    @FindBy(xpath = "//span[text()='Finance']")
    public WebElement Finance;

    @FindBy(xpath = "//span[text()='My Finance']")
    public WebElement MyFinance;

    @FindBy(css = "[class='mdc-data-table__content ng-star-inserted']")
    public WebElement Student;

    @FindBy(xpath = "//span[text()='Fee/Balance Detail']")
    public WebElement BalanceDetail;

    @FindBy(xpath = "//span[text()='Online Payment']")
    public WebElement OnlinePayment;

    @FindBy(xpath = "//span[text()=' Student Fee ']")
    public WebElement PayerInfo;

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
