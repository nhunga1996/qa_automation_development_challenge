package context;

import pages.OrangeHrmHomePage;
import pages.Pim.EmployeeListPage;
import pages.Pim.PimPage;
import pages.admin.AddUserPage;
import pages.admin.AdminPage;
import pages.admin.UserManagementPage;
import pages.LoginPage;

public class PageObjectManager {

    private LoginPage loginPage;
    private EmployeeListPage employeeListPage;
    private PimPage pimPage;
    private AdminPage adminPage;
    private OrangeHrmHomePage homePage;
    private UserManagementPage userManagementPage;
    private AddUserPage addUserPage;

    public LoginPage getLoginPage() {

        if (loginPage == null) {

            loginPage = new LoginPage();
        }

        return loginPage;
    }

    public EmployeeListPage getEmployeeListPage() {

        if (employeeListPage == null) {

            employeeListPage = new EmployeeListPage();
        }

        return employeeListPage;
    }

    public PimPage getPimPage() {

        if (pimPage == null) {

            pimPage = new PimPage();
        }

        return pimPage;
    }

    public AdminPage getAdminPage() {

        if (adminPage == null) {

            adminPage = new AdminPage();
        }

        return adminPage;
    }

    public OrangeHrmHomePage getHomePage() {

        if (homePage == null) {

            homePage = new OrangeHrmHomePage();
        }

        return homePage;
    }
    public UserManagementPage getUserManagementPage() {

        if (userManagementPage == null) {

            userManagementPage = new UserManagementPage();
        }

        return userManagementPage;
    }

    public AddUserPage getAddUserPage() {

        if (addUserPage == null) {

            addUserPage = new AddUserPage();
        }

        return addUserPage;
    }
}

