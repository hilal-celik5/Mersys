package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GradingPage extends ParentPage {

    public GradingPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(text(), 'Grading')]")
    public WebElement grading;

    @FindBy(css = "#all-course")
    public WebElement gradeTable;

    @FindBy(css = "[icon='print']")
    public WebElement print;

    @FindBy(css = "body > embed")
    public WebElement pdfDocument;
}
