package stepdefinitions.ui;

import context.TestContext;
import pages.OrangeHrmHomePage;

public class HomePageSteps {
    private final TestContext testContext;
    private final OrangeHrmHomePage homePage;

    public HomePageSteps(TestContext testContext) {
        this.testContext = testContext;
        this.homePage = testContext
                .getPageObjectManager()
                .getHomePage();
    }
}
