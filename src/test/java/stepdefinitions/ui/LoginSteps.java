package stepdefinitions.ui;

import context.TestContext;
import io.cucumber.java.en.Given;
import pages.LoginPage;

public class LoginSteps {

    private final TestContext testContext;
    private final LoginPage loginPage;

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
        this.loginPage = testContext
                .getPageObjectManager()
                .getLoginPage();
    }

    @Given("the user is logged into the OrangeHRM system")
    public void theUserIsLoggedIntoTheOrangeHRMSystem() {
        loginPage.open();
        String username = loginPage.getUserNameVaLue();
        String password = loginPage.getPasswordVaLue();
        loginPage.enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }
}