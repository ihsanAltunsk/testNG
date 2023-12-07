package tests.day14_testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_SearchTest {
    // Make the necessary settings
    // Create 3 test methods
    // 1- Navigate to the homepage of the test automation
    //    Test that we have reached the correct address
    // 2- Search for "phone"
    //    Test that a product can be found in the search results
    // 3- Click on the first product
    //    On the opened product page, test that the product name contains "phone" case-insensitively

    WebDriver driver;
    @Test (priority = 1)
    public void mainPageTest(){
        // 1- Navigate to the homepage of the test automation
        //    Test that we have reached the correct address
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // 1- Navigate to the homepage of the test automation
        driver.get("https://www.google.com");

        //    Test that we have reached the correct address
        String expectedUrl ="https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

    }
    @Test (dependsOnMethods = "mainPageTest")
    public void searchTest(){
        // 2- Search for "phone"
        //    Test that a product can be found in the search results
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        WebElement resultElement = driver.findElement(By.className("product-count-text"));
        String unexpectedResult = "0 Products Found";
        String actualResult = resultElement.getText();
        Assert.assertNotEquals(unexpectedResult, actualResult);
    }
    @Test (dependsOnMethods = "searchTest")
    public void productNameTest(){
        // 3- Click on the first product
        //    On the opened product page, test that the product name contains "phone" case-insensitively
        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]"))
                .click();

        WebElement productElement = driver.findElement(By.xpath(" //div[@class=' heading-sm mb-4']"));
        String expectedName = "phone";
        String actualName = productElement.getText().toLowerCase();
        Assert.assertTrue(actualName.contains(expectedName));

        driver.quit();
    }
}
