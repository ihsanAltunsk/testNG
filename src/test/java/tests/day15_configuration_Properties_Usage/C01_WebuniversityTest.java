package tests.day15_configuration_Properties_Usage;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebuniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_WebuniversityTest {
    // 1- Go to the address "http://webdriveruniversity.com/"
    // 2- Scroll down to "Login Portal"
    // 3- Click on "Login Portal"
    // 4- Switch to the new window
    // 5- Enter values into the "username" and "password" boxes
    // 6- Click the "login" button
    // 7- Test that the text in the popup is "validation failed"
    // 8- Close the popup by clicking "Ok"
    // 9- Go back to the first page
    // 10- Test that the return to the first page is successful

    @Test
    public void test(){
        // 1- Go to the address "http://webdriveruniversity.com/"
        Driver.getDriver().get("http://webdriveruniversity.com/");

        // 2- Scroll down to "Login Portal"
        WebuniversityPage webuniversityPage = new WebuniversityPage();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",webuniversityPage.loginPortalLink);

        // 3- Click on "Login Portal"
        ReusableMethods.waitabit(2);
        webuniversityPage.loginPortalLink.click();

        // 4- Switch to the new window
        ReusableMethods.changePageWithTitle("Driver.getDriver().");

        // 5- Enter values into the "username" and "password" boxes
        Faker faker = new Faker();
        webuniversityPage.usernameBox.sendKeys(faker.name().username());
        webuniversityPage.passwordBox.sendKeys(faker.internet().password());

        // 6- Click the "login" button
        webuniversityPage.loginButton.click();

        // 7- Test that the text in the popup is "validation failed"
        String expectedAlert = "validation failed";
        String actualAlert = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(actualAlert,expectedAlert);

        // 8- Close the popup by clicking "Ok"
        Driver.getDriver().switchTo().alert().accept();

        // 9- Go back to the first page
        String firstPageTitle = "WebDriverUniversity.com";
        ReusableMethods.changePageWithTitle(firstPageTitle);

        // 10- Test that the return to the first page is successful
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,firstPageTitle);

        Driver.quitDriver();
    }
}
