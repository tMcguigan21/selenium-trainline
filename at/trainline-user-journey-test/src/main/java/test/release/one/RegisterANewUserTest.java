package test.release.one;

import Register.RegisterPage;
import com.frameworkium.core.ui.tests.BaseTest;
import org.testng.annotations.Test;
import HomePage.*;

public class RegisterANewUserTest extends BaseTest
{
    @Test(description = "Test to see if the user can Register and be taken back to the homepage")
    public void registerTest()
    {
        MainHomePage mainHomePage = MainHomePage.open();

        RegisterPage registerPage = mainHomePage
                .getHeader()
                .clickRegisterButton();

        registerPage
                .setEmailAddress("hello.world@gmail.com")
                .setPassword("somePassword123")
                .setFirstName("Automated")
                .setSurname("Test")
                .setPostcode("LS42LT")
                .clickFindAddressButton()
                .getAddressByText("6,BEECHWOOD GROVE")
                .clickAddressSelection()
                .unTickCheckbox()
                .clickCreateAccountButton();
    }
}
