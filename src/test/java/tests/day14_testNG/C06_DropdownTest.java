package tests.day14_testNG;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;

public class C06_DropdownTest {
    // Go to the address https://testotomasyonu.com/form.
    // 1. Choose 5 from the day options in the birth date using index.
    // 2. Choose April from the month options in the birth date using value.
    // 3. Choose 1990 from the year options in the birth date using visible text.
    // 4. Print the selected values on the console.
    // 5. Print all values (value) in the month dropdown menu.
    // 6. Test that the size of the month dropdown menu is 13.

    @Test
    public void dropdownTest(){
        // Go to the address https://testotomasyonu.com/form.
        Driver.getDriver().get("https://testotomasyonu.com/form");

        // 1. Choose 5 from the day options in the birth date using index.
        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();
        Select selectDay = new Select(testOtomasyonuFormPage.dropdownMenuElementsList.get(0));
        selectDay.selectByIndex(5);

        // 2. Choose "Nisan" from the month options in the birth date using value.
        Select selectMonth = new Select(testOtomasyonuFormPage.dropdownMenuElementsList.get(1));
        selectMonth.selectByValue("nisan");

        // 3. Choose 1990 from the year options in the birth date using visible text.
        Select selectYear = new Select(testOtomasyonuFormPage.dropdownMenuElementsList.get(2));
        selectYear.selectByVisibleText("1990");

        // 4. Print the selected values on the console.
        System.out.println(selectDay.getFirstSelectedOption().getText() + "/" +
                           selectMonth.getFirstSelectedOption().getText() + "/" +
                           selectYear.getFirstSelectedOption().getText());

        // 5. Print all values (value) in the month dropdown menu.
        selectMonth.getOptions();

        // 6. Test that the size of the month dropdown menu is 13.


    }
}
