package ru.stqa.pft.web.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePointCorrections extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoMountpointsPage();
    }

    @Test
    public void testChangePointCorrections() {
        String pointName    = "test_3";
        String correctionSet   = "RTK RTCM {20,21,23,24}";
        app.getMountpointHelper().changeCorrectionSet(pointName, correctionSet);
//        Assert.assertEquals(app.getMountpointHelper().getPointCorrectionInfo(pointName), correctionSet);
    }
}
