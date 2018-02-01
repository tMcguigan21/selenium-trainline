package helper;

import com.frameworkium.core.ui.pages.BasePage;
import org.apache.log4j.Logger;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import static com.google.common.truth.Truth.assert_;

public class RetryHelper
{
    private static Logger logger = Logger.getLogger(RetryHelper.class);

    @SuppressWarnings("unchecked")
    private static <T> T execute(Callable<?> condition, int maxRetryCount)
    {
        List<Throwable> exceptions = new ArrayList<>();

        //Run the lambda expression
        for (int i = 0; i < maxRetryCount; i++)
        {
            try
            {
                return (T) condition.call();
            }
            catch (Exception e)
            {
                exceptions.add(e.getCause());
            }
        }

        //If the process reaches this point, the retrying has failed, throwing the first exception.
        exceptions.forEach((e) ->
        {
            if (e != null)
                logger.error(String.format("Exception: %s StackTrace: %s", e.getMessage(), Arrays.toString(e.getStackTrace())));
        });

        assert_().fail("Callable expression failed within the retry helper, check the console output.");

        return null;
    }

    public static <T extends BasePage> T retryForPO(Callable<? extends BasePage> condition, int maxRetryCount)
    {
        return execute(condition, maxRetryCount);
    }

    public static <T extends HtmlElement> T retryForElement(Callable<? extends HtmlElement> condition, int maxRetryCount)
    {
        return execute(condition, maxRetryCount);
    }

    public static Boolean retryForBoolean(Callable<Boolean> condition, int maxRetryCount)
    {
        return execute(condition, maxRetryCount);
    }

    public static void retryVoid(Callable<?> condition, int maxRetryCount) {
        execute(condition, maxRetryCount);
    }
}
