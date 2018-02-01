package helper;

import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static constant.Trainline.GLOBAL_PAGE_LOAD_TIMEOUT;

public class PageFactory extends com.frameworkium.core.ui.pages.PageFactory
{

    public static <T extends BasePage<T>> T newInstanceWithTimeout(Class<T> clazz, long timeoutInSeconds)
    {
        BaseTest.newWaitWithTimeout(timeoutInSeconds).until(
                ExpectedConditions.invisibilityOfElementLocated(By.tagName("spinner"))
        );
        return com.frameworkium.core.ui.pages.PageFactory.newInstance(clazz, timeoutInSeconds);
    }

    public static <T extends BasePage<T>> T newInstance(Class<T> clazz)
    {
        return PageFactory.newInstanceWithTimeout(clazz, GLOBAL_PAGE_LOAD_TIMEOUT);
    }

}
