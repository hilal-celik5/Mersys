package StepDefinitions;

import Pages.ProfilePage;
import Utilities.GWD;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileSteps {

    WebDriver driver = GWD.getDriver();
    ProfilePage pp   = new ProfilePage();
    String imgPath   = System.getProperty("user.dir") + "/src/test/resources/img/pngimg.com - white_dove_PNG39.png";

    @When("student opens {string}")
    public void openMenu(String path){
        for (String item : path.split(">")){
            driver.findElement(By.xpath("//*[normalize-space()='"+item.trim()+"']")).click();
        }
    }
    @When("student clicks the profile image")
    public void clickProfileImg(){ pp.profileImg.click(); }

    @When("student uploads {string} smaller than 5 MB")
    public void upload(String ignore){
        pp.fileInput.sendKeys(imgPath);
    }

    @Then("success toast appears")
    public void toast(){
        assert pp.toastMessage.isDisplayed();
    }
}

