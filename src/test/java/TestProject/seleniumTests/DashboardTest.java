package TestProject.seleniumTests;

import TestProject.framework.testBase.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DashboardTest extends TestBase{

    @Test
    public void someTest(){
        DashboardTest dashboardTest = new DashboardTest();
        //dashboardPage.clickOnWomanCategory();
        assertEquals(true, true);
    }
}
