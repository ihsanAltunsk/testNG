package tests.day15_configuration_Properties_Usage;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_HardAssertion {
    // 1- Navigate to the homepage of the test automation
    // 2- Test that the Title contains "Test"
    // 3- Test that the URL is https://www.testautomation.com
    // 4- Test that the search box is in a usable state
    // 5- Search for the specified keyword and test that a product is found
    // 6- Search for "Nutella" and test that a product is found
    // 7- Close the page

    @Test
    public void test(){
        // 1- Navigate to the homepage of the test automation
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2- Test that the Title contains "Test"
        String expectedTitle = "Test";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // 3- Test that the URL is https://www.testautomation.com
        String expectedUrl = "https://www.testautomation.com";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

        // 4- Test that the search box is in a usable state
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        Assert.assertTrue(testOtomasyonuPage.searchBox.isEnabled());

        // 5- Search for the specified keyword and test that a product is found
        testOtomasyonuPage.searchBox.sendKeys(
                ConfigReader.getProperty(
                        "toSearchWord") +
                            Keys.ENTER);
        int foundResultNumber = testOtomasyonuPage.foundProductsElementsList.size();
        Assert.assertTrue(foundResultNumber >10);

        // 6- Search for "Nutella" and test that a product is found
        testOtomasyonuPage.searchBox.clear();
        testOtomasyonuPage.searchBox.sendKeys("Nutella" + Keys.ENTER);
        foundResultNumber = testOtomasyonuPage.foundProductsElementsList.size();
        Assert.assertTrue(foundResultNumber>0);

        // 7- Close the page
        Driver.quitDriver();

    }
}
