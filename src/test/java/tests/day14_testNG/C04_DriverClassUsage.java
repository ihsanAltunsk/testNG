package tests.day14_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverClassUsage {
    @Test
    public void test(){
        /*
            Those preparing the Page Object Model (POM) have chosen
            to prefer creating the WebDriver object in a static method
            rather than obtaining it from the Testbase without the need for the extends keyword.
        */
        // Go to the test automation's homepage
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // Type "phone" into the search box and perform the search
        WebElement searchBox = Driver.getDriver().findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // Print the search results.
        WebElement resultElement = Driver.getDriver().findElement(By.className("product-count-text"));
        System.out.println(resultElement.getText());

        Driver.quitDriver();
    }
}
