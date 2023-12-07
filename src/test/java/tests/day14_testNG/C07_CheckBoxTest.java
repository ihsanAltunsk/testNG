package tests.day14_testNG;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;

public class C07_CheckBoxTest {
    // a. Go to the given web page: https://testotomasyonu.com/form
    // b. Select the Back Pain and Cramps checkboxes.
    // c. Test that the Back Pain and Cramps checkboxes are selected.
    // d. Test that the Diabetes and Epilepsy checkboxes are not selected.

    @Test
    public void test(){
        // a. Go to the given web page: https://testotomasyonu.com/form
        Driver.getDriver().get("https://testotomasyonu.com/form");

        // b. Select the Back Pain and Cramps checkboxes.
        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();
        testOtomasyonuFormPage.crampCheckBox.click();
        testOtomasyonuFormPage.backPainCheckBox.click();

        // c. Test that the Back Pain and Cramps checkboxes are selected.
        Assert.assertTrue(testOtomasyonuFormPage.crampCheckBox.isSelected());
        Assert.assertTrue(testOtomasyonuFormPage.backPainCheckBox.isSelected());

        // d. Test that the Diabetes and Epilepsy checkboxes are not selected.
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertFalse(testOtomasyonuFormPage.diabetesCheckBox.isSelected());
        Assert.assertFalse(testOtomasyonuFormPage.epilepsyCheckBox.isSelected());

        Driver.quitDriver();
    }
}
