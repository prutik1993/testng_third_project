package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WindowHandler;

import java.util.List;

public class SearchCarsPage extends CarvanaBasePage{
    public SearchCarsPage(){
        super();
    }
    @FindBy(css = "div[data-qa= 'menu-flex']>button")
    public List<WebElement> filterOptions;
    @FindBy(css = "input[data-qa='search-bar-input']")
    public WebElement searchInput;
    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;
}
