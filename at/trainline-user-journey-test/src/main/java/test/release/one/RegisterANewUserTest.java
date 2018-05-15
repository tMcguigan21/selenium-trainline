package test.release.one;

import Register.RegisterPage;
import com.frameworkium.core.ui.tests.BaseTest;
import org.testng.annotations.Test;
import HomePage.*;

import static com.google.common.truth.Truth.assert_;

public class RegisterANewUserTest extends BaseTest
{
    @Test(description = "Test to see if the user can Register and be taken back to the homepage")
    public void registerTest()
    {
        String emailAddress = "hello.world2@gmail.com",
                password = "somePassword123",
                firstName = "Automated",
                lastName = "Test",
                postCode = "LS42LT";

        MainHomePage mainHomePage = MainHomePage.open();

        RegisterPage registerPage = mainHomePage
                .getHeader()
                .clickRegisterButton();

        registerPage
                .setEmailAddress(emailAddress)
                .setPassword(password)
                .setFirstName(firstName)
                .setSurname(lastName)
                .setPostcode(postCode)
                .clickFindAddressButton()
                .getAddressByText("6,BEECHWOOD GROVE")
                .clickAddressSelection()
                .unTickCheckbox()
                .clickCreateAccountButton();

        assert_().withFailureMessage("The Sign out button on the homepage is not visible after registration")
                .that(mainHomePage.getHeader().isSignOutButtonDisplayed())
                .isEqualTo(true);

        registerPage
                .clickCreateAccountButton();
    }
}
