package ru.stqa.pft.web.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NtripPointModification extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoMountpointsPage();
    }

    @Test
    public void testNtripPointModification() {

        app.getMountpointHelper().modifyNtripCorrectionSource("Test1", "RTCM3 MSM Max");
    }
}
