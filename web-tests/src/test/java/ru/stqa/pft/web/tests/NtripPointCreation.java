package ru.stqa.pft.web.tests;

import org.testng.annotations.Test;

public class NtripPointCreation extends TestBase {

    @Test
    public void testNtripPointCreation(){
        app.getNavigationHelper().gotoNtripPage();
        app.getNtripHelper().addBasePoint();
    }
}
