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

    @FindBy(xpath= "(//div[@fxlayout='row wrap']/bdi)[last()]")
    public WebElement lastMessage;
}