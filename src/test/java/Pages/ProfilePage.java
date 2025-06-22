package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

        public ProfilePage(){ PageFactory.initElements(GWD.getDriver(), this); }

        @FindBy(css="img.profile-picture")          public WebElement profileImg;
        @FindBy(css="input[type='file']")           public WebElement fileInput;
        @FindBy(css=".toast-message")               public WebElement toastMessage;

        @FindBy(id = "theme-dropdown")
        public WebElement themeDropdown;

        @FindBy(css = "#theme-dropdown option")
        public java.util.List<WebElement> themeOptions;

        @FindBy(css = "button[type='submit']")
        public WebElement saveButton;
}




