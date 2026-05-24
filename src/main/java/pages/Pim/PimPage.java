package pages.Pim;

import org.openqa.selenium.By;
import pages.BasePage;
import pages.admin.UserManagementPage;
import reports.ExtentLogger;

public class PimPage extends BasePage {

    private final By pageHeader = By.xpath("//h6[text()='PIM']");
    private final By addEmployeeMenu = By.xpath("//a[text()='Add Employee']");

    @Override
    protected By getUniqueElement() {
        return pageHeader;
    }

    public AddEmployeePage clickAddEmployeeMenu(){
        click(addEmployeeMenu);
        ExtentLogger.info("");
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        addEmployeePage.waitForPageLoaded();
        return addEmployeePage;
    }
}