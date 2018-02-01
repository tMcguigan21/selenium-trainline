package Register.modal;

import Register.RegisterPage;
import Register.element.AddressSelectionElements;
import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.List;

public class AddressSelectionModal extends BasePage<AddressSelectionModal>
{
    @Visible
    @Name("Close button")
    @FindBy(css = "[data-test*='modal-close']")
    private WebElement closeButton;

    @Name("Address List")
    @FindBy(css = "[data-name*='ListSelector-']")
    private List<AddressSelectionElements> addressList;

    @Step("Click Close Button")
    public RegisterPage clickCloseButton()
    {
        closeButton.click();
        return PageFactory.newInstance(RegisterPage.class);
    }

    @Step("Get Address list elements")
    public List<AddressSelectionElements> getAddressList()
    {
        return addressList;
    }

    @Step("Get address by text")
    public AddressSelectionElements getAddressByText(String address)
    {
        return getAddressList().stream()
                .filter(o -> o.getText().contains(address))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Error"));
    }
}
