package stepdefinitions.ui;


import Constant.ContextKey;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.commons.lang3.StringUtils;
import pages.OrangeHrmHomePage;
import pages.Pim.EmployeeListPage;
import pages.Pim.PimPage;

public class PimSteps{
    private final TestContext testContext;
    private final EmployeeListPage employeeListPage;
    private final PimPage pimPage;
    private final OrangeHrmHomePage orangeHrmHomePage;

    public PimSteps(TestContext testContext) {
        this.testContext = testContext;
        this.employeeListPage = testContext
                .getPageObjectManager()
                .getEmployeeListPage();
        this.pimPage = testContext
                .getPageObjectManager()
                .getPimPage();
        this.orangeHrmHomePage = testContext
                .getPageObjectManager()
                .getHomePage();
    }

    @And("an employee exists for user creation")
    public void createEmployeeIfNoExist() {
        String employeeNameDefault = "Employee automation";
        testContext.getScenarioContext().get(ContextKey.CREATED_USER);

        orangeHrmHomePage.clickPimMenu();
        employeeListPage.enterEmployeeName(employeeNameDefault)
                .clickSearch()
                .waitForPageLoadingComplete();
        if(!employeeListPage.isEmployeeDisplayed(employeeNameDefault.split(" ")[0], employeeNameDefault.split(" ")[1])){
            pimPage.clickAddEmployeeMenu()
                    .enterFistName(employeeNameDefault.split(" ")[0])
                    .enterLastName(employeeNameDefault.split(" ")[1])
                    .clickSave();
        }
    }
}
