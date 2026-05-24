package pages.Pim;

import org.openqa.selenium.By;
import pages.BasePage;
import pages.admin.UserManagementPage;

public class EmployeeListPage extends BasePage {
    private final By pageHeader = By.xpath("//h6[text()='Employee Information']");
    private final By employeeNameTextBox = By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By resultTable = By.cssSelector(".oxd-table-body");
    private final By loadingSpinner = By.cssSelector(".oxd-loading-spinner");
    private final String rowTable = "//div[@role='row']//div[contains(text(),'%s')]/ancestor::div//div[contains(text(),'%s')]";

    @Override
    protected By getUniqueElement() {
        return pageHeader;
    }

    public EmployeeListPage enterEmployeeName(String employeeName){
        typeText(employeeNameTextBox, employeeName);
        return this;
    }

    public EmployeeListPage clickSearch(){
        click(searchButton);
        return this;
    }

    public EmployeeListPage waitForPageLoadingComplete(){
        waitForSpinnerToDisappear(loadingSpinner);
        waitForElementVisible(resultTable);
        return this;
    }

    public boolean isEmployeeDisplayed(String firstName, String lastName) {
        return isElementDisplayed(By.xpath(String.format(rowTable, firstName, lastName)));
    }
}