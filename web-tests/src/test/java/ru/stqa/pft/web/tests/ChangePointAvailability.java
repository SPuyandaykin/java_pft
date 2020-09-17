package ru.stqa.pft.web.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePointAvailability extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoMountpointsPage();
    }

    @Test
    public void testChangePointAvailability() {
        String pointName        = "test_1";
        boolean pointPublish    = true;
        app.getMountpointHelper().changeAvailability(pointName, pointPublish);
    }
}
