package context;

import manager.DriverManager;

public class TestContext {

    private final ScenarioContext scenarioContext;
    private final PageObjectManager pageObjectManager;
    private final DriverManager driverManager;

    public TestContext() {
        scenarioContext = new ScenarioContext();
        pageObjectManager = new PageObjectManager();
        driverManager = new DriverManager();
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public ScenarioContext setScenarioContext() {
        return scenarioContext;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }
}