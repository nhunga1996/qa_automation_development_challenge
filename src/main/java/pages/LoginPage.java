package pages;

import org.openqa.selenium.By;
import reports.ExtentLogger;

public class LoginPage extends BasePage {

    private final By usernameTextBox = By.name("username");

    private final By passwordTextBox  = By.name("password");

    private final By loginButton = By.xpath("//button[@type='submit']");

    private final By loginForm = By.cssSelector(".orangehrm-login-form");

    private final By demoCredentialsUserNameValue = By.xpath("//div[contains(@class,'orangehrm-demo-credentials')]//p[1]");

        private final By demoCredentialsPasswordValue = By.xpath("//div[contains(@class,'orangehrm-demo-credentials')]//p[2]");

    private static final String LOGIN_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Override
    protected By getUniqueElement() {
        return loginForm;
    }

    public LoginPage open() {
        driver.get(LOGIN_URL);
        waitForPageLoaded();
        return this;
    }

    public LoginPage enterUsername(String username){
        typeText(usernameTextBox, username);
        ExtentLogger.info(username);
        return this;
    }

    public LoginPage enterPassword(String password){
        typeText(passwordTextBox, password);
        ExtentLogger.info(password);
        return this;
    }

    public OrangeHrmHomePage clickLogin(){
        click(loginButton);
        ExtentLogger.info("");
        OrangeHrmHomePage orangeHrmHomePagePage = new OrangeHrmHomePage();
        orangeHrmHomePagePage.waitForPageLoaded();
        return orangeHrmHomePagePage;
    }

    public String getUserNameVaLue() {
        String value = getText(demoCredentialsUserNameValue).split(":")[1].trim();
        ExtentLogger.info(value);
        return value;
    }

    public String getPasswordVaLue() {
        String value = getText(demoCredentialsPasswordValue).split(":")[1].trim();
        ExtentLogger.info(value);
        return value;
    }
}