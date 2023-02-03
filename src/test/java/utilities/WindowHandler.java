package utilities;

import org.openqa.selenium.WebDriver;

public class WindowHandler {
     static WebDriver driver;
    static String mainWindowId;

    public static void moveToChildWindow(){
        driver = Driver.getDriver();
        mainWindowId = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!windowHandle.equals(mainWindowId)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    public static void switchBackToParentWindow(){
        driver.switchTo().window(mainWindowId);
    }

}
