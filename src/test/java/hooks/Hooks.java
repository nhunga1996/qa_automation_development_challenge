package hooks;

import com.aventstack.extentreports.ExtentTest;
import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import reports.ExtentLogger;
import reports.ExtentReportManager;
import reports.ExtentTestManager;

public class Hooks {

    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setup(Scenario scenario) {
        ExtentTest extentTest =
                ExtentReportManager
                        .getInstance()
                        .createTest(
                                scenario.getName()
                        );
        ExtentTestManager.setTest(extentTest);
        ExtentLogger.info(
                "Scenario Started: "
                        + scenario.getName()
        );

        // Only initialize driver if scenario has @ui tag
        if (scenario.getSourceTagNames().contains("@ui") && testContext != null && testContext.getDriverManager() != null) {
                testContext.getDriverManager().initDriver();
                // Maximize the browser window
                if (testContext.getDriverManager().getDriver() != null) {
                    testContext.getDriverManager().getDriver().manage().window().maximize();
                }
            }


    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            if (testContext != null && testContext.getDriverManager() != null
                    && testContext.getDriverManager().getDriver() != null) {
                try {
                    String screenshot = testContext.getDriverManager().getScreenshotAsBase64();
                    ExtentLogger.failWithScreenshot("Scenario Failed", screenshot);
                } catch (Exception e) {
                    ExtentLogger.fail("Scenario Failed - Unable to capture screenshot: " + e.getMessage());
                }
            } else {
                ExtentLogger.fail("Scenario Failed");
            }
        } else {
            ExtentLogger.pass("Scenario Passed");
        }

        ExtentReportManager
                .getInstance()
                .flush();
        if (testContext != null && testContext.getDriverManager() != null) {
            testContext.getDriverManager().quitDriver();
        }
    }

    @AfterAll
    public static void afterAll() {
        ExtentReportManager.flushReports();
    }
}