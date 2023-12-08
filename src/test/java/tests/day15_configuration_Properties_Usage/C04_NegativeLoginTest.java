package tests.day15_configuration_Properties_Usage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginTest {
    //1- Go to the homepage of https://www.testotomasyonu.com/.
    //2- Click on the login link.
    //3- Create three different test scenarios:
    //      -Valid username, invalid password
    //      -Invalid username, valid password
    //      -Invalid username, invalid password.
    //4- Log in by clicking the login button.
    //5- Test and confirm that login is not successful.

    @Test
    public void invalidPassword(){
        //1- Go to the homepage of https://www.testotomasyonu.com/.
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- Click on the login link.
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        //      -Valid username, invalid password
        testOtomasyonuPage.emailBox.sendKeys(ConfigReader.getProperty("toCorrectEmail"));
        testOtomasyonuPage.passwordBox.sendKeys(ConfigReader.getProperty("toIncorrectPassword"));
        testOtomasyonuPage.loginButton.click();

        Assert.assertTrue(testOtomasyonuPage.emailBox.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void invalidEmail(){
        //1- Go to the homepage of https://www.testotomasyonu.com/.
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- Click on the login link.
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        //      -Invalid username, valid password
        testOtomasyonuPage.emailBox.sendKeys(ConfigReader.getProperty("toIncorrectEmail"));
        testOtomasyonuPage.passwordBox.sendKeys(ConfigReader.getProperty("toCorrectPassword"));
        testOtomasyonuPage.loginButton.click();

        Assert.assertTrue(testOtomasyonuPage.emailBox.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void bothInvalid(){
        //1- Go to the homepage of https://www.testotomasyonu.com/.
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- Click on the login link.
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        //      -Invalid username, invalid password.
        testOtomasyonuPage.emailBox.sendKeys(ConfigReader.getProperty("toIncorrectEmail"));
        testOtomasyonuPage.passwordBox.sendKeys(ConfigReader.getProperty("toIncorrectPassword"));
        testOtomasyonuPage.loginButton.click();

        Assert.assertTrue(testOtomasyonuPage.emailBox.isDisplayed());
        Driver.closeDriver();
    }
}
