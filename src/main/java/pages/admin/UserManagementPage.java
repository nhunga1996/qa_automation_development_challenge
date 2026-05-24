package pages.admin;

import org.openqa.selenium.By;
import pages.BasePage;
import reports.ExtentLogger;

public class UserManagementPage extends BasePage {

    private final By systemUsersHeader = By.xpath("//h5[text()='System Users']");
    private final By addButton = By.xpath("//button[normalize-space()='Add']");
    private final By usernameTextBox= By.xpath("//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By resultTable = By.cssSelector(".oxd-table-body");
    private final By loadingSpinner = By.cssSelector(".oxd-loading-spinner");
    private final String rowTable = "//div[@role='row']//div[text()='%s']";

    @Override
    protected By getUniqueElement() {
        return systemUsersHeader;
    }

    public AddUserPage clickAddUser() {
        click(addButton);
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.waitForPageLoaded();
        return addUserPage;
    }

    public UserManagementPage enterUserName(String username){
        typeText(usernameTextBox, username);
        ExtentLogger.info(username);
        return this;
    }

    public UserManagementPage clickSearch(){
        click(searchButton);
        ExtentLogger.info("");
        return this;
    }

    public UserManagementPage waitForPageLoadingComplete(){
        waitForSpinnerToDisappear(loadingSpinner);
        waitForElementVisible(resultTable);
        ExtentLogger.info("");
        return this;
    }

    public boolean isUserDisplayed(String username) {
        boolean isUserDisplayed = isElementDisplayed(By.xpath(String.format(rowTable, username)));
        ExtentLogger.info(String.valueOf(isUserDisplayed));
        return isUserDisplayed;
    }
}