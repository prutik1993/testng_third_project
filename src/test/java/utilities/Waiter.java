package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    public static void pause(int seconds){
        try {
            Thread.sleep( 1000 * seconds);
        }catch (InterruptedException e){
            throw  new RuntimeException(e);
        }
    }
    public static void waitForVisibilityOfElements(WebElement element, int seconds){
        new WebDriverWait(Driver.getDriver(),seconds).until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitUntilUrlIs(String url, int seconds){
        new WebDriverWait(Driver.getDriver(),seconds).until(ExpectedConditions.urlContains(url));
    }
    public static void waitForElementToBeClickable(WebElement element, int seconds){
        new WebDriverWait(Driver.getDriver(),seconds).until(ExpectedConditions.elementToBeClickable(element));
    }
}
