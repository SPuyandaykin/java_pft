package ru.stqa.pft.web.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeletePoint extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoMountpointsPage();
    }

    @Test
    public void testAddPointWithBaseNtripSource() {
        String pointName = "Test3";
        app.getMountpointHelper().deletePointByName(pointName);
        Assert.assertEquals(app.getMountpointHelper().isMountpointExists(pointName), false);
    }
}
