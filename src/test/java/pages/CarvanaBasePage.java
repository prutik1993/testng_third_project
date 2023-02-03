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


}
