package ru.stqa.pft.web.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddPointWithBaseNtripSource extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoMountpointsPage();
    }

    @Test
    public void testAddPointWithBaseNtripSource() {
        String pointName = "test_5";
        String correctionSet   = "RTK RTCM {20,21,23,24}";
        String sourceName   = "server_1";
        app.getMountpointHelper().addPointWithBaseNtripSource(pointName, correctionSet, sourceName);
        Assert.assertEquals(app.getMountpointHelper().isMountpointExists(pointName), true);
    }
}
