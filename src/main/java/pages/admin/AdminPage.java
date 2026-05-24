package pages.admin;

import org.openqa.selenium.By;
import pages.BasePage;
import reports.ExtentLogger;

public class AdminPage extends BasePage {

    private final By pageHeader = By.xpath("//h6[text()='Admin']");
    private final By userManagementMenu = By.xpath("//span[text()='User Management ']/ancestor::li");

    @Override
    protected By getUniqueElement() {
        return pageHeader;
    }

    public UserManagementPage clickUserManagement(){
        click(userManagementMenu);
        ExtentLogger.info("");
        UserManagementPage userManagementPage = new UserManagementPage();
        userManagementPage.waitForPageLoaded();
        return userManagementPage;
    }

}