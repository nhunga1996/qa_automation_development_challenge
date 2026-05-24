package stepdefinitions.ui;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.OrangeHrmHomePage;
import pages.admin.AdminPage;

public class AdminSteps {
    private final TestContext testContext;
    private final AdminPage adminPage;
    private final OrangeHrmHomePage orangeHrmHomePage;

    public AdminSteps(TestContext testContext) {
        this.testContext = testContext;
        this.adminPage = testContext
                .getPageObjectManager()
                .getAdminPage();
        this.orangeHrmHomePage = testContext
                .getPageObjectManager()
                .getHomePage();
    }

    @And("the user is on the User Management page")
    public void navigateToTheUserManagementPage() {
        orangeHrmHomePage.clickAdminMenu();
        adminPage.clickUserManagement();
    }
}
