package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssignmentPage extends ParentPage {
    public AssignmentPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[data-testid='assignments-tab']")
    public WebElement assignmentsTab;

    @FindBy(css = ".assignment-list-container")
    public WebElement assignmentListContainer;

    @FindBy(css = ".search-input")
    public WebElement searchInput;

    @FindBy(css = ".search-button")
    public WebElement searchButton;

    @FindBy(css = ".sort-due-date-asc")
    public WebElement sortByDueDateAsc;

    @FindBy(css = ".sort-status-incomplete-first")
    public WebElement sortByStatusIncompleteFirst;

    @FindBy(css = ".submit-button")
    public WebElement submitButton;

    @FindBy(css = ".submission-success-message")
    public WebElement successMessage;

    @FindBy(css = ".discussion-start-button")
    public WebElement startDiscussionButton;

    @FindBy(css = ".assignment-item")
    public List<WebElement> assignmentItems;

    public List<String> getVisibleAssignmentTitles() {
        List<String> titles = new ArrayList<>();
        for (WebElement item : assignmentItems) {
            WebElement titleElement = item.findElement(By.cssSelector(".assignment-title"));
            titles.add(titleElement.getText());
        }
        return titles;
    }

    public List<String> getVisibleAssignmentDueDates() {
        List<String> dates = new ArrayList<>();
        for (WebElement item : assignmentItems) {
            WebElement dateElement = item.findElement(By.cssSelector(".assignment-due-date"));
            dates.add(dateElement.getText().trim());
        }
        return dates;
    }

    public List<String> getSortedDatesAsc(List<String> dateList) {
        List<String> sorted = new ArrayList<>(dateList);
        Collections.sort(sorted);
        return sorted;
    }

    public List<String> getVisibleAssignmentStatuses() {
        List<String> statuses = new ArrayList<>();
        for (WebElement item : assignmentItems) {
            WebElement statusElement = item.findElement(By.cssSelector(".assignment-status"));
            statuses.add(statusElement.getText().trim());
        }
        return statuses;
    }
}
