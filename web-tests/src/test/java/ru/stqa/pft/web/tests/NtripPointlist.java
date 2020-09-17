package ru.stqa.pft.web.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NtripPointlist extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoMountpointsPage();
    }

    @Test
    public void testNtripPointlist() {

        app.getMountpointHelper().selectPointFromListByIndex(1);
    }
}
