package ru.stqa.pft.web.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePointName  extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoMountpointsPage();
    }

    @Test
    public void testChangePointName() {
        String pointName    = "test_3";
        String pointNameNew = "test_4";
        app.getMountpointHelper().changeName(pointName, pointNameNew);
        Assert.assertEquals(app.getMountpointHelper().isMountpointExists(pointNameNew), true);

        app.getMountpointHelper().changeName(pointNameNew, pointName);  //restore previous value
    }
}
