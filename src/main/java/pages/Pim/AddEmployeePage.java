package pages.Pim;

import org.openqa.selenium.By;
import pages.BasePage;

public class AddEmployeePage extends BasePage {
    private final By pageHeader = By.xpath("//h6[text()='Add Employee']");
    private final By firstNameTextbox = By.name("firstName");
    private final By lastNameTextbox = By.name("lastName");
    private final By saveButton = By.xpath("//button[@type='submit']");

    @Override
    protected By getUniqueElement() {
        return pageHeader;
    }

    public AddEmployeePage enterFistName(String firstName){
        typeText(firstNameTextbox, firstName);
        return this;
    }

    public AddEmployeePage enterLastName(String lastName){
        typeText(lastNameTextbox, lastName);
        return this;
    }

    public PersonalDetailsPage clickSave(){
        click(saveButton);
        PersonalDetailsPage personalDetailsPage =  new PersonalDetailsPage();
        personalDetailsPage.waitForPageLoaded();
        return personalDetailsPage;
    }
}