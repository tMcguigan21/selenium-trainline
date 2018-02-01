package HomePage;

import Header.HeaderPage;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import com.frameworkium.core.ui.tests.BaseTest;
import ru.yandex.qatools.allure.annotations.Step;
import static constant.Trainline.TRAINLINE_URL;

public class MainHomePage extends BasePage<MainHomePage>
{
    @Step("Open the Browser onto the Home page")
    public static MainHomePage open()
    {
        BaseTest.getDriver().get(TRAINLINE_URL);
        return PageFactory.newInstance(MainHomePage.class);
    }

    @Step("Get Header page object")
    public HeaderPage getHeader()
    {
        return PageFactory.newInstance(HeaderPage.class);
    }
}
