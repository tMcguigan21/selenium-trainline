package Register;

import HomePage.MainHomePage;
import Register.element.AddressSelectionElements;
import Register.modal.AddressSelectionModal;
import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import helper.AppHelper;
import helper.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.CheckBox;

import static constant.Trainline.LONG_PAGE_WAIT_HIGH;

public class RegisterPage extends BasePage<RegisterPage>
{
    @Visible
    @Name("Email Address text field")
    @FindBy(id = "email")
    private WebElement emailAddressField;

    @Visible
    @Name("Password text field")
    @FindBy(id = "password")
    private WebElement passwordField;

    @Visible
    @Name("First name text field")
    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @Visible
    @Name("Last name text field")
    @FindBy(id = "surname")
    private WebElement lastNameField;

    @Visible
    @Name("Postcode text field")
    @FindBy(id = "postcode")
    private WebElement postcodeField;

    @Name("Find Address button")
    @FindBy(css = "[data-test*='find-address-by-postcode-button']")
    private WebElement findAddressButton;

    @Visible
    @Name("Create account button")
    @FindBy(id = "dpa1984Consent")
    private WebElement createAccountButton;

    @Visible
    @Name("Email new and offers checkbox")
    @FindBy(id = "dpa1984Consent")
    private CheckBox emailNewsAndOffers;

    @Visible
    @Name("Company Logo")
    @FindBy(css = "[href='https://www.thetrainline.com/']")
    private WebElement companyLogo;

    @Step("Click Company Logo")
    public MainHomePage clickCompanyLogo()
    {
        companyLogo.click();
        return PageFactory.newInstance(MainHomePage.class);
    }

    @Step("Set Email address field")
    public RegisterPage setEmailAddress(String emailAddress)
    {
        emailAddressField.clear();
        emailAddressField.sendKeys(emailAddress);
        return this;
    }

    @Step("Set Password field")
    public RegisterPage setPassword(String password)
    {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Set FirstName field")
    public RegisterPage setFirstName(String name)
    {
        firstNameField.clear();
        firstNameField.sendKeys(name);
        return this;
    }

    @Step("Set Surname field")
    public RegisterPage setSurname(String name)
    {
        lastNameField.clear();
        lastNameField.sendKeys(name);
        return this;
    }

    @Step("Set Postcode field")
    public RegisterPage setPostcode(String postcode)
    {
        postcodeField.clear();
        postcodeField.sendKeys(postcode);
        return this;
    }

    @Step("Click Find address button")
    public AddressSelectionModal clickFindAddressButton()
    {
        findAddressButton.click();
        return PageFactory.newInstance(AddressSelectionModal.class);
    }

    @Step("Click Create account button")
    public MainHomePage clickCreateAccountButton()
    {
        AppHelper.scrollToView(createAccountButton);
        createAccountButton.click();
        AppHelper.waitForOnScreenAnimation(LONG_PAGE_WAIT_HIGH);
        return PageFactory.newInstance(MainHomePage.class);
    }

    @Step("Click Checkbox")
    public RegisterPage unTickCheckbox()
    {
        AppHelper.scrollToView(emailNewsAndOffers);
        emailNewsAndOffers.select();
        return this;
    }
}
