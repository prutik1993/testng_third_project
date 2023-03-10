package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SearchCarsPage;
import utilities.TestData;
import utilities.Waiter;
import utilities.WindowHandler;

import java.util.Objects;
import java.util.stream.IntStream;

public class SearchCarsTest extends CarvanaBase {

    @BeforeMethod
    public void setPage() {
        searchCarsPage = new SearchCarsPage();
        Waiter.pause(2);
        carvanaBasePage.searchCarsButton.click();
        WindowHandler.moveToChildWindow();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
    }

    /**
     * Test Case 5: Test name = Validate the search filter options and search button
     * Test priority = 5
     * Given user is on "https://www.carvana.com/"
     * When user clicks on "SEARCH CARS" link
     * Then user should be routed to "https://www.carvana.com/cars"
     * And user should see filter options
     * |PAYMENT & PRICE      |
     * |MAKE & MODEL      |
     * |BODY TYPE |
     * |YEAR & MILEAGE      |
     * |FEATURES      |
     * |MORE FILTERS |
     */

    @Test(priority = 1, description = "Validate the search filter options and search button",
            dataProvider = "searchData")
    public void validateSearchFilterOptions() {
        IntStream.range(0, searchCarsPage.filterOptions.size()).forEach
                (i -> Assert.assertTrue(searchCarsPage.filterOptions.get(i).isDisplayed()));
    }
    /**
     * Test Case 6: Test name = Validate the search result tiles
     * Test priority = 6
     * Given user is on "https://www.carvana.com/"
     * When user clicks on "SEARCH CARS" link
     * Then user should be routed to "https://www.carvana.com/cars"
     * When user enters "mercedes-benz" to the search input box
     * And user clicks on "GO" button in the search input box
     * Then user should see "mercedes-benz" in the url
     * And validate each result tile
     * VALIDATION OF EACH TILE INCLUDES BELOW
     * Make sure each result tile is displayed with below information
     * 1. an image
     * 2. add to favorite button
     * 3. tile body
     *
     * ALSO VALIDATE EACH TILE BODY:
     * Make sure each tile body has below information
     * 1. Inventory type - text should be displayed and should not be null or empty
     * 2. Year-Make-Model information - text should be displayed and should not be null or empty
     * 3. Trim-Mileage information - text should be displayed and should not be null or empty
     * 4. Price - Make sure that each price is more than zero
     * 5. Monthly Payment information - text should be displayed and should not be null or empty
     * 6. Down Payment information - text should be displayed and should not be null or empty
     * 7. Delivery chip must be displayed, and text is not null or empty
     */

    @Test(priority = 2,description = "Validate the search result tiles")
    public void validateSearchResultTitles(){

     searchCarsPage.searchInput.sendKeys(TestData.carMake);

     Waiter.waitForElementToBeClickable(searchCarsPage.goButton,5);
     searchCarsPage.goButton.click();

     Waiter.waitUntilUrlIs("mercedes-benz",10);

     Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));
        String priceResult;
        for (int i = 0; i < searchCarsPage.images.size(); i++) {
            Assert.assertTrue(searchCarsPage.images.get(i).isDisplayed());

            Assert.assertTrue(searchCarsPage.favoriteButton.get(i).isDisplayed());

            Assert.assertTrue(searchCarsPage.inventoryType.get(i).isDisplayed());
            Assert.assertFalse(searchCarsPage.inventoryType.get(i).getText().isEmpty());

            Assert.assertTrue(searchCarsPage.yearMakeModel.get(i).isDisplayed());
            Assert.assertFalse(searchCarsPage.yearMakeModel.get(i).getText().isEmpty());

            Assert.assertTrue(searchCarsPage.trimMileage.get(i).isDisplayed());
            Assert.assertFalse(searchCarsPage.trimMileage.get(i).getText().isEmpty());

            priceResult = searchCarsPage.price.get(i).getText();
            priceResult = priceResult.replaceAll("[^0-9]","");
            Assert.assertTrue(Integer.parseInt(priceResult) > 0);

            Assert.assertTrue(searchCarsPage.monthlyPayment.get(i).isDisplayed());
            Assert.assertFalse(searchCarsPage.monthlyPayment.get(i).getText().isEmpty());

            Assert.assertTrue(searchCarsPage.downPayment.get(i).isDisplayed());
            Assert.assertFalse(searchCarsPage.downPayment.get(i).getText().isEmpty());
            Assert.assertTrue(searchCarsPage.deliveryChip.get(i).isDisplayed());
            Assert.assertFalse(searchCarsPage.deliveryChip.get(i).getText().isEmpty());
        }
    }
}
