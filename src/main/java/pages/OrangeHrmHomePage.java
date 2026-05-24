package pages;

import org.openqa.selenium.By;
import pages.Pim.PimPage;
import pages.admin.AdminPage;

public class OrangeHrmHomePage extends BasePage {

    private final By adminMenu = By.xpath("//span[text()='Admin']/ancestor::li");
    private final By pimMenu = By.xpath("//a[contains(@href,'Pim')]/ancestor::li");
    private final By userDropdownName = By.cssSelector(".oxd-userdropdown-name");

    @Override
    protected By getUniqueElement() {
        return adminMenu;
    }

    public String getLoggedInUsername() {
        return getText(userDropdownName);
    }

    public AdminPage clickAdminMenu(){
        click(adminMenu);
        AdminPage adminPage = new AdminPage();
        adminPage.waitForPageLoaded();
        return adminPage;
    }

    public PimPage clickPimMenu(){
        click(pimMenu);
        PimPage adminPage = new PimPage();
        adminPage.waitForPageLoaded();
        return adminPage;
    }
}