package pages.admin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.BasePage;

import java.time.Duration;

public class AddUserPage extends BasePage {

    private final By addUserHeader = By.xpath("//h6[text()='Add User']");
    private final By employeeNameComboBox = By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By userNameTextBox = By.xpath("//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By passwordTextBox = By.xpath("//label[text()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By confirmPasswordTextBox = By.xpath("//label[text()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By saveButton = By.xpath("//button[@type='submit' and normalize-space()='Save']");
    private final By successToast = By.xpath("//p[contains(@class,'oxd-text') and text()='Successfully Saved']");
    private final String dropdown = "//label[normalize-space()='%s']/ancestor::div[contains(@class,'oxd-input-group')]" + "//div[contains(@class,'oxd-select-text')]";
    private final String option = "//div[@role='option']//span[normalize-space()='%s']";

    @Override
    protected By getUniqueElement() {
        return addUserHeader;
    }

    public AddUserPage selectUserRole(String role) {
        By dropdownElement  = By.xpath(String.format(dropdown, "User Role"));
        By optionElement = By.xpath(String.format(option, role));
        selectDropdownOption(dropdownElement, optionElement);
        return this;
    }

    public AddUserPage selectEmployeeName(String employeeName) {
        typeText(employeeNameComboBox, employeeName);
        waitForElementVisible(By.xpath(String.format(option, employeeName)));
        click(By.xpath(String.format(option, employeeName)));
        return this;
    }

    public AddUserPage selectStatus(String status) {
        By dropdownElement  = By.xpath(String.format(dropdown, "Status"));
        By optionElement = By.xpath(String.format(option, status));
        selectDropdownOption(dropdownElement, optionElement);
        return this;
    }

    public AddUserPage enterUsername(String username) {
        typeText(userNameTextBox, username);
        return this;
    }

    public AddUserPage enterPassword(String password) {
        typeText(passwordTextBox, password);
        return this;
    }

    public AddUserPage enterConfirmPassword(String confirmPassword) {
        typeText(confirmPasswordTextBox, confirmPassword);
        return this;
    }

    public UserManagementPage clickSaveButton() {
        click(saveButton);
        UserManagementPage userManagementPage =  new UserManagementPage();
        Assert.assertTrue(isDisplayed(successToast));
        return userManagementPage;
    }



    private void selectFirstEmployeeName() {
        WebElement input = waitForElementClickable(employeeNameComboBox);
        actions.click(input)
                .sendKeys("a")
                .pause(Duration.ofMillis(3000))
                .perform();

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//div[@role='option']"), 0
        ));
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }
}