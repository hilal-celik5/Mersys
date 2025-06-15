package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ParentPage {

    public HomePage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "/html/body/app/student-layout/div/student-toolbar-horizontal/mat-toolbar/div/div[1]/div/div[1]/img")
    public WebElement companyLogo;

    @FindBy(css = "[icon='chalkboard-teacher']")
    public WebElement coursesButton;

    @FindBy(css = "[icon='calendar-week']")
    public WebElement calendarButton;

    @FindBy(css = "[icon='users-class']")
    public WebElement attendanceButton;

    @FindBy(css = "[icon='tasks']")
    public WebElement assignmentsButton;

    @FindBy(css = "[icon='analytics']")
    public WebElement gradingButton;

    @FindBy(css = "button[class*='mat-mdc-menu-trigger'] fa-icon")
    public WebElement hamburgerMenuButton;

    @FindBy(xpath = "//button[contains(@class, 'mdc-icon-button')]")
    public WebElement announcements;

    @FindBy(xpath = "(//button[contains(@class, 'mdc-icon-button')])[2]")
    public WebElement messages;

    @FindBy(css = ".user-button")
    public WebElement profile;

    @FindBy(css = ".mat-grid-list")
    public WebElement courses;

    @FindBy(xpath = "//span[text()=' Calendar ']")
    public WebElement calendarHeader;

    @FindBy(xpath = "//span[text()=' Attendance ']")
    public WebElement attendanceHeader;

    @FindBy(xpath = "//span[text()=' Assignments ']")
    public WebElement assignmentsHeader;

    @FindBy(xpath = "//span[text()=' Grading ']")
    public WebElement gradingHeader;

    @FindBy(css = ".mat-mdc-menu-content")
    public WebElement hamburgerMenuPanel;

    @FindBy(xpath = "//span[text()=' Announcements']")
    public WebElement announcementsPanel;

    @FindBy(xpath = "//span[text()=' Messages']")
    public WebElement messagesPanel;

    @FindBy(css = ".mat-mdc-menu-content")
    public WebElement profilePanel;

    public WebElement getWebElement(String element) {
        switch (element) {
            case "courses":
                return this.coursesButton;
            case "calendar":
                return this.calendarButton;
            case "attendance":
                return this.attendanceButton;
            case "assignments":
                return this.assignmentsButton;
            case "grading":
                return this.gradingButton;
            case "hamburger menu":
                return this.hamburgerMenuButton;
            case "announcements":
                return this.announcements;
            case "messages":
                return this.messages;
            case "profile":
                return this.profile;
        }
        return null;
    }

    public WebElement getVerifierElement(String element) {
        switch (element) {
            case "courses":
                return this.courses;
            case "calendar":
                return this.calendarHeader;
            case "attendance":
                return this.attendanceHeader;
            case "assignments":
                return this.assignmentsHeader;
            case "grading":
                return this.gradingHeader;
            case "hamburger menu":
                return this.hamburgerMenuPanel;
            case "announcements":
                return this.announcementsPanel;
            case "messages":
                return this.messagesPanel;
            case "profile":
                return this.profilePanel;
        }
        return null;
    }
}