package tests.day14_testNG;

import org.testng.annotations.Test;

public class C01_Priority {
    /*
    TestNG runs test methods by default in natural order. However, if we want to run the tests in a specific order, we can use the priority attribute to assign priorities to test methods.
       -The test method with a smaller priority value runs first.
       -If two test methods have the same priority, they run in natural order.
       -If no priority is assigned to a method, the default priority value is 0.
    */

    @Test (priority = -10)
    public void youtubeTest(){
        System.out.println("Youtube test PASSED.");
    }
    @Test (priority = -10)
    public void testAutomationTest(){
        System.out.println("Test Automation test PASSED.");
    }
    @Test
    public void amazonTest(){
        System.out.println("Amazon Test PASSED.");
    }
}
