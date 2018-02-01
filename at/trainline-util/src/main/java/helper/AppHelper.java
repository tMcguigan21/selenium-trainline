package helper;

import com.frameworkium.core.ui.js.JavascriptWait;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.frameworkium.core.ui.tests.BaseTest.getDriver;

public class AppHelper
{
    public static void waitForModal()
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        try
        {
            wait.withTimeout(3, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-overlay")));
        }
        catch (TimeoutException ignore)
        {
            //Ignore
        }
        wait.withTimeout(10, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-overlay")));
    }

    public static void waitForOnScreenAnimation(int durationInMilliseconds)
    {
        //Tried every dynamic implementation of trying to get this stable, but zero ways worked... I want to cry.
        try
        {
            Thread.sleep(durationInMilliseconds);
        }
        catch (InterruptedException e)
        {
            //Ignore
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.pollingEvery(2000, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animate")));
        new JavascriptWait(getDriver(), wait).waitForJavascriptFramework();
    }

    public static void waitForOnScreenAnimation() {
        waitForOnScreenAnimation(300);
    }

    private static void scrollToBottom(String elementSelector)
    {
        getDriver().executeScript(String.format("document.querySelector('%s').scrollTop = 50000", elementSelector));
    }

    public static void scrollToBottom()
    {
        scrollToBottom(".main-container");
    }

    public static void scrollModalToBottom() {
        scrollToBottom("aside");
    }

    public static void clickTopMiddle() {
        WebElement userName = getDriver().findElement(By.id("info-header-username"));
        new Actions(getDriver())
                .moveToElement(userName)
                .click()
                .perform();
    }

    public static void scrollToView(WebElement element) {
        getDriver().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static Boolean isElementDisplayedAndPresent(WebElement element) {
        try
        {
            return element.isDisplayed();
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
}
