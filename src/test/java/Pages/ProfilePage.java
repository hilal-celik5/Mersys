package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends ParentPage {

    public ProfilePage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = ".user-button")
    public WebElement profile;

    @FindBy(xpath = "//span[text()='Settings']")
    public WebElement settings;

    @FindBy(css = ".profile-image")
    public WebElement profilePhoto;

    @FindBy(css = "[class*='mdc-fab mat-mdc-fab-base']")
    public WebElement uploadPicture;

    @FindBy(xpath = "//span[text()=' Upload ']")
    public WebElement upload;

    @FindBy(css = "[type='file']")
    public WebElement fileInput;

    @FindBy(xpath = "//*[@id='ms-button-0']/button/span[1]")
    public WebElement save;

    @FindBy(xpath = "//div[text()='Profile successfully updated']")
    public WebElement successMessage;

    @FindBy(css = "[formcontrolname='theme']")
    public WebElement theme;

    @FindBy(xpath = "//span[text()=' Dark Purple Theme ']")
    public WebElement darkPurpleTheme;
}
