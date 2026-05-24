package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    private static final int DEFAULT_TIMEOUT = 15;

    /**
     * Common loading spinner locator
     * Update this locator if application changes
     */
    private final By loadingSpinner =
            By.cssSelector(".oxd-loading-spinner");

    public BasePage() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(DEFAULT_TIMEOUT)
        );
        actions = new Actions(driver);
    }

    /**
     * Each page must provide a unique locator
     * used for page load validation
     */
    protected abstract By getUniqueElement();

    /**
     * Main page loading strategy
     */
    public void waitForPageLoaded() {

        waitForDocumentReady();

        waitForLoadingDisappear();

        waitForElementVisible(getUniqueElement());
    }

    /**
     * Wait until browser page fully loaded
     */
    private void waitForDocumentReady() {

        wait.until(driverObject ->
                ((JavascriptExecutor) driver)
                        .executeScript(
                                "return document.readyState"
                        )
                        .equals("complete")
        );
    }

    /**
     * Wait until loading spinner disappears
     */
    protected void waitForLoadingDisappear() {

        try {

            wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(
                            loadingSpinner
                    )
            );

        } catch (TimeoutException ignored) {
        }
    }

    protected WebElement waitForElementVisible(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        locator
                )
        );
    }


    public void selectDropdownOption(By dropdownLocator, By optionLocator ){
        wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(optionLocator))
                .click();
    }

    protected WebElement waitForElementClickable(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(
                        locator
                )
        );
    }

    protected void click(By locator) {

        waitForElementClickable(locator)
                .click();
    }

    protected void typeText(By locator, String text) {

        WebElement element =
                waitForElementVisible(locator);

        element.clear();

        element.sendKeys(text);
    }

    protected boolean isElementDisplayed(By locator) {

        try {

            wait.until(
                    ExpectedConditions
                            .visibilityOfElementLocated(locator)
            );

            return driver
                    .findElement(locator)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    protected String getText(By locator) {

        return waitForElementVisible(locator)
                .getText()
                .trim();
    }

    protected void waitForSpinnerToDisappear(By spinner) {
        wait.until(
                ExpectedConditions
                        .invisibilityOfElementLocated(spinner)
        );
    }

    protected boolean isDisplayed(By locator) {

        try {

            return waitForElementVisible(locator)
                    .isDisplayed();

        } catch (TimeoutException e) {

            return false;
        }
    }

    protected void scrollIntoView(By locator) {

        WebElement element =
                waitForElementVisible(locator);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView(true);",
                        element
                );
    }


    protected void jsClick(By locator) {

        WebElement element =
                waitForElementClickable(locator);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        element
                );
    }

    protected String getPageTitle() {

        return driver.getTitle();
    }

    protected String getCurrentUrl() {

        return driver.getCurrentUrl();
    }
}