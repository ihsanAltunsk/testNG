package tests.day14_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_DependsOnMethods {
    /*
    The dependsOnMethods attribute does not interfere with the priority order.

    If a test method depends on another method with dependsOnMethods,
    it first checks whether the dependent test has run and passed.
    If the dependent test does not run or runs but fails,
    the dependent test method will not run; it is marked as ignored.

    Typically, each test method can run independently. However,
    when two methods are dependent on each other with dependsOnMethods,
    running the dependent method ensures that the method it depends on runs first.
    If the dependent method runs and passes, the dependent method itself will also run.
    */

    @Test(dependsOnMethods = "testAutomationTest")
    public void youtubeTest(){
        System.out.println("Youtube test PASSED.");
    }
    @Test
    public void testAutomationTest(){
        Assert.assertTrue(false);
        System.out.println("Test Automation test PASSED.");
    }
    @Test
    public void amazonTest(){
        System.out.println("Amazon Test PASSED.");
    }
}
