package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttendancePage extends ParentPage {
    public AttendancePage() {
        PageFactory.initElements(GWD.getDriver(),this);
    }
    @FindBy(xpath = "(//span[text()='Attendance'])[1]")
    public WebElement atendance;

    @FindBy(xpath = "//span[text()=' ATTENDANCE EXCUSES ']")
    public WebElement atendanceExcuse;

    @FindBy(xpath = "//ms-add-button[@class='ng-star-inserted']/button")
    public WebElement addButton;

    @FindBy(xpath = "//span[text()=' 30 ']")
    public WebElement date;

    @FindBy(xpath = "(//button[@class='mdc-icon-button mat-mdc-icon-button mat-mdc-button-base mat-unthemed'])[2]")
    public WebElement calendar;

    @FindBy(css = "[placeholder='Message']")
    public WebElement message;

    @FindBy(xpath = "//span[text()='Send']")
    public WebElement send;

    @FindBy(css = "[role='cell']>div>ms-edit-button>button")
    public WebElement edit;

    @FindBy(xpath = "//div[text()=' Your Message: ']/div")
    public WebElement yourMessage;
}
