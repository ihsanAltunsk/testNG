package tests.day15_configuration_Properties_Usage;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SingletonPattern {

    @Test
    public void test(){
        /*
        The SINGLETON pattern is one of the methods
        used to prevent the creation of objects from a class.

        To use the SINGLETON pattern,
        in the class where we want to prevent object creation,
        we create a visible constructor and set the access modifier
        of this constructor to PRIVATE.

        Driver driver = new Driver();
        driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        */
    }
}
