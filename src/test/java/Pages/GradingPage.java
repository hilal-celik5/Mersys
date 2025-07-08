package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GradingPage {

    public GradingPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(linkText = "Grading")
    public WebElement gradingLink;

    @FindBy(xpath = "//button[normalize-space()='Course Grade']")
    public WebElement courseGradeTab;

    @FindBy(xpath = "//button[normalize-space()='Student Transcript']")
    public WebElement studentTranscriptTab;

    @FindBy(xpath = "//button[normalize-space()='Transcript By Subject']")
    public WebElement transcriptBySubjectTab;

    @FindBy(css = "button[aria-label='Print']")
    public WebElement printIcon;

    @FindBy(css = "button[aria-label='Download']")
    public WebElement downloadButton;

}
