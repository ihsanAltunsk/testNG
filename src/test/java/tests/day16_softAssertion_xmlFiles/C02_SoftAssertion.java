package tests.day16_softAssertion_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_SoftAssertion {
    // 1- Go to the address "http://zero.webappsecurity.com/"
    // 2- Verify that you are on the webbappsecurity homepage
    // 3- Click on the Sign In button
    // 4- Enter "username" in the login box
    // 5- Enter "password" in the password box
    // 6- Click on the Sign In button
    // 7- Click on the Back button
    // 8- Verify that the login was successful
    // 9- Click on the Online Banking menu
    // 10- Go to the Pay Bills page
    // 11- Click on the "Purchase Foreign Currency" button
    // 12- Verify that the Currency dropdown menu is accessible
    // 13- Select Eurozone from the "Currency" dropdown menu
    // 14- Confirm that "Eurozone (euro)" is selected
    // 15- Verify that there are 16 options in the dropdown menu
    // 16- Verify that "Canada (dollar)" is present in the dropdown menu
    // 17- Close the page
    @Test
    public void test(){
        // 1- Go to the address "http://zero.webappsecurity.com/"
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));

        // 2- Verify that you are on the webbappsecurity homepage
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "http://zero.webappsecurity.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"You are not on the homepage.");

        // 3- Click on the Sign In button
        ZeroPage zeroPage = new ZeroPage();
        zeroPage.signInLink.click();

        // 4- Enter "username" in the login box
        zeroPage.usernameBox.sendKeys("username");

        // 5- Enter "password" in the password box
        zeroPage.passwordBox.sendKeys("password");

        // 6- Click on the Sign In button
        zeroPage.signInButton.click();

        // 7- Click on the Back button
        Driver.getDriver().navigate().back();

        // 8- Verify that the login was successful
        softAssert.assertTrue(zeroPage.onlineBankingLink.isDisplayed(),"Unsuccessful Login.");

        // 9- Click on the Online Banking menu
        zeroPage.onlineBankingLink.click();

        // 10- Go to the Pay Bills page
        zeroPage.payBillsLink.click();

        // 11- Click on the "Purchase Foreign Currency" button
        zeroPage.purchaseForeignCurrencyLink.click();

        // 12- Verify that the Currency dropdown menu is accessible
        softAssert.assertTrue(zeroPage.pcCurrencyDropdownElement.isEnabled(),"Currency dropdown in not accessible.");

        // 13- Select Eurozone from the "Currency" dropdown menu
        Select select = new Select(zeroPage.pcCurrencyDropdownElement);
        select.selectByValue("EUR");

        // 14- Confirm that "Eurozone (euro)" is selected
        String expectedOption = "Eurozone (euro)";
        String actualSeciliOption = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualSeciliOption,expectedOption,"Eurozone didn't select.");

        // 15- Verify that there are 16 options in the dropdown menu
        int expectedDropdownSize = 16;
        int actualDopdownSize = select.getOptions().size();
        softAssert.assertEquals(actualDopdownSize,expectedDropdownSize,"Dropdown is not the expected size.");

        // 16- Verify that "Canada (dollar)" is present in the dropdown menu
        List<WebElement> dropdownElementleriList = select.getOptions();
        List<String> dropdownYazilariList = ReusableMethods.convertToStringList(dropdownElementleriList);
        softAssert.assertTrue(dropdownYazilariList.contains("Canada (dollar)"),"Canada Dollar is not present in the dropdown.");

        // 17- Close the page
        softAssert.assertAll();
        Driver.quitDriver();

    }
}
