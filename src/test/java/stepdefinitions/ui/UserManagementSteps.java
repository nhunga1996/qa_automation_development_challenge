package stepdefinitions.ui;

import Constant.ContextKey;
import context.TestContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.SystemUser;
import org.testng.Assert;
import pages.admin.UserManagementPage;
import randomizer.ObjectMother;
import randomizer.RandomizerSupport;

public class UserManagementSteps {

    private final TestContext testContext;
    private final UserManagementPage userManagementPage;

    public UserManagementSteps(TestContext testContext) {
        this.testContext = testContext;
        this.userManagementPage = testContext
                .getPageObjectManager()
                .getUserManagementPage();
    }

    @When("the user creates a new user with default information")
    public void createNewUser() {
        SystemUser systemUser = ObjectMother.next(SystemUser.class,
                obj -> {
                    obj.setPassword(RandomizerSupport.randomPassword());
                    obj.setEmployeeName("Employee automation");
                });
        testContext.getScenarioContext().set(ContextKey.CREATED_USER, systemUser);
        userManagementPage
                .clickAddUser()
                .selectUserRole(systemUser.getRole().getValue())
                .selectStatus(systemUser.getStatus().getValue())
                .selectEmployeeName(systemUser.getEmployeeName())
                .enterUsername(systemUser.getUsername())
                .enterPassword(systemUser.getPassword())
                .enterConfirmPassword(systemUser.getPassword())
                .clickSaveButton()
                .waitForPageLoadingComplete();
    }

    @And("the user searches for the newly created user by username")
    public void searchForNewlyCreatedUser() {
        SystemUser systemUser = testContext.getScenarioContext().get(ContextKey.CREATED_USER);
        var username = systemUser.getUsername();
        userManagementPage.enterUserName(username)
                .clickSearch()
                .waitForPageLoadingComplete();
    }

    @Then("the user should be found in the search results")
    public void verifyUserIsFound() {
        SystemUser systemUser = testContext.getScenarioContext().get(ContextKey.CREATED_USER);
        Assert.assertTrue(userManagementPage.isUserDisplayed(systemUser.getUsername()),"The user is displayed on the search result");
    }
}