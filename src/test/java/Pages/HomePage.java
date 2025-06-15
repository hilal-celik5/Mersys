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
}