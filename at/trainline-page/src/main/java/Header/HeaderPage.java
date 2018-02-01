package Header;

import HomePage.MainHomePage;
import Register.RegisterPage;
import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import com.gargoylesoftware.htmlunit.Page;
import helper.AppHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class HeaderPage extends BasePage<HeaderPage>
{
    @Visible
    @Name("Company Logo")
    @FindBy(css = "[data-test*='header-homepage-link']")
    private static WebElement companyLogo;

    @Name("Register link")
    @FindBy(css = "[data-test*='register-link']")
    private WebElement registerTextButton;

    @Step("Is company logo present")
    public boolean isCompanyLogoPresent()
    {
        return companyLogo.isDisplayed();
    }

    @Step("Click the Company logo")
    public MainHomePage clickCompanyLogo()
    {
        AppHelper.scrollToView(companyLogo);
        companyLogo.click();
        return PageFactory.newInstance(MainHomePage.class);
    }

    @Step("Click Register text button")
    public RegisterPage clickRegisterButton()
    {
        AppHelper.scrollToView(registerTextButton);
        registerTextButton.click();
        return PageFactory.newInstance(RegisterPage.class);
    }
}
