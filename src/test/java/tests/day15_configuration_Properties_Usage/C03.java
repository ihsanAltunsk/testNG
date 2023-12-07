package tests.day15_configuration_Properties_Usage;

import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03 {
    // 1- Go to the homepage of https://www.testotomasyonu.com/.
    // 2- Click on the "account" link.
    // 3- Enter "wise@gmail.com" as the user email.
    // 4- Enter "12345" as the user password.
    // 5- Log in by clicking the login button.
    // 6- Test and confirm that login is successful.

    @Test
    public void test(){
        // 1- Go to the homepage of https://www.testotomasyonu.com/.
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2- Click on the "account" link.
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        // 3- Enter "wise@gmail.com" as the user email.
        testOtomasyonuPage.emailBox.sendKeys(ConfigReader.getProperty("toCorrectEmail"));

        // 4- Enter "12345" as the user password.
        testOtomasyonuPage.passwordBox.sendKeys(ConfigReader.getProperty("toCorrectPassword"));

        // 5- Log in by clicking the login button.
        testOtomasyonuPage.loginButton.click();

        // 6- Test and confirm that login is successful.


    }
}
