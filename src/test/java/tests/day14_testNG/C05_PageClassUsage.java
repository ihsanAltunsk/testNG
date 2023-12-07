package tests.day14_testNG;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C05_PageClassUsage {
    @Test
    public void searchTest(){
        // Go to the test automation's homepage
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // Search for "phone"
        TestOtomasyonuPage testAutomationPage = new TestOtomasyonuPage();
        testAutomationPage.searchBox.sendKeys("phone" + Keys.ENTER);

        // Test that the number of search results is more than 1
        Assert.assertTrue(testAutomationPage.foundProductsElementsList.size()>1);

        // Print the number of search results
        System.out.println(testAutomationPage.resultTextElement.getText());

        // Close the page
        Driver.quitDriver();
    }
}
