package pages.Pim;

import org.openqa.selenium.By;
import pages.BasePage;

public class PersonalDetailsPage extends BasePage {

    private final By pageHeader = By.xpath("//h6[text()='Personal Details']");

    @Override
    protected By getUniqueElement() {
        return pageHeader;
    }
}