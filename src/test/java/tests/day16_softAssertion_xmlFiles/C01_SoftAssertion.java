package tests.day16_softAssertion_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuFormPage;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SoftAssertion {
    /*
    TestNG offers two alternatives for tests containing multiple assertions:

    You can use methods similar to those in JUnit.
    The test stops running at the first failed assertion,
    and we cannot determine whether the remaining assertions passed or not.
    After fixing the failed assertion, we can then examine the others.
    When using this method, for each failed assertion,
    we need to make corrections and rerun the test.

    You can use the same assert methods from the SoftAssert class.
    When using SoftAssert, TestNG continues to execute even if assertions fail,
    taking note of the situation. When you ask for a report,
    TestNG reviews all the assertions it made.
    It reports the failed assertions and stops execution if there are any failures.
        - Create a SoftAssert object.
        - Perform all assertions using the SoftAssert object.
        - Request a report using assertAll() after completing the assertions.
     */
    @Test
    public void test01(){
        // 1- Navigate to the homepage of the "testotomasyonu"
        Driver.getDriver().get("https://testotomasyonu.com");

        // 2- Test that the Title contains "Test"
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Driver.getDriver().getTitle().contains("Test"));

        // 3- Test that the URL is https://www.testautomation.com
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl() , "https://www.testautomation.com");

        // 4- Test that the search box is in a usable state
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        softAssert.assertTrue(testOtomasyonuPage.searchBox.isEnabled());

        // 5- Search for a specified keyword and test that a product is found
        testOtomasyonuPage.searchBox.sendKeys(
                ConfigReader.getProperty(
                        "toSearchWord") +
                        Keys.ENTER);
        int foundResultNumber = testOtomasyonuPage.foundProductsElementsList.size();
        softAssert.assertTrue(foundResultNumber >0);

        // 6- Search for "Nutella" and test that no product is found
        testOtomasyonuPage.searchBox.clear();
        testOtomasyonuPage.searchBox.sendKeys("Nutella" + Keys.ENTER);
        foundResultNumber = testOtomasyonuPage.foundProductsElementsList.size();
        softAssert.assertTrue(foundResultNumber>0);

        softAssert.assertAll();
        // 7- Close the page
        Driver.quitDriver();

    }
}
