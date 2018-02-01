package Register.element;

import Register.RegisterPage;
import helper.AppHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class AddressSelectionElements extends HtmlElement
{
    @Name("Address Button")
    @FindBy(className = "_bmozld")
    private WebElement addressButton;

    @Step("Click Address selection")
    public RegisterPage clickAddressSelection()
    {
        addressButton.click();
        AppHelper.waitForOnScreenAnimation();
        return helper.PageFactory.newInstance(RegisterPage.class);
    }

}
