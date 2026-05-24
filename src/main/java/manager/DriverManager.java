package manager;

import drivers.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    public void initDriver() {
        DriverFactory.initDriver();
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void quitDriver() {
        DriverFactory.closeDriver();
    }

    public String getScreenshotAsBase64() {
        WebDriver driver = getDriver();
        if (driver != null) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        }
        return null;
    }
}
