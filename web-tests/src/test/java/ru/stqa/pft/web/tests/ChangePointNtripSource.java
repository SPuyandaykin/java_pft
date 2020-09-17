package ru.stqa.pft.web.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePointNtripSource extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoMountpointsPage();
    }

    @Test
    public void testChangePointNtripSource() {
        String pointName    = "test_3";
        String sourceName   = "Test_OSR2";
        app.getMountpointHelper().changePointSource(pointName, sourceName);
//        Assert.assertEquals(app.getMountpointHelper().getPointSourceInfo(pointName), sourceName);
    }
}
