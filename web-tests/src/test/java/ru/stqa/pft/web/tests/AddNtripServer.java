package ru.stqa.pft.web.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNtripServer extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoNtripsServerPage();
    }

    @Test
    public void testAddNtripServer() {
        String serverName = "server_1";
        app.getNtripHelper().addNtripServer(serverName);
        Assert.assertEquals(app.getNtripHelper().isNtripServerExists(serverName), true);

    }
}
