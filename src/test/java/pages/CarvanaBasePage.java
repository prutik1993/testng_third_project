package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarvanaBasePage  {
    public CarvanaBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "div[data-qa='logo-wrapper'] svg")
    public WebElement logo;
    @FindBy(css = "div[data-qa='menu-wrapper']")
    public List<WebElement> mainSectionItems;
    @FindBy(css = "div[data-qa='desktop-wrapper']>a")
    public WebElement singInButton;
    @FindBy(id = "email")
    public WebElement emailInput;
    @FindBy(css = "button[data-testid='Button']")
    public WebElement continueButton;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(css = "div[class*='error-banner__cC']")
    public WebElement errorMessage;
    @FindBy(css = "a[data-cv-test='headerSearchLink']")
    public WebElement searchCarsButton;
}
