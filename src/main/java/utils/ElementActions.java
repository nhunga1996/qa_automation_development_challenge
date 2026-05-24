package utils;

import drivers.DriverFactory;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ElementActions {
    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
    }

    /**
     * Enters text into the input field located by the given locator.
     * Clears the field before entering text.
     */
    public static void enterText(By locator, String text) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = DriverFactory.getDriver().findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Clicks the element located by the given locator.
     */
    public static void click(By locator) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        DriverFactory.getDriver().findElement(locator).click();
    }

}