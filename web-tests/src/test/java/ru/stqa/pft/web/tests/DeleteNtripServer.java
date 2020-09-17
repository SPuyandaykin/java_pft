package ru.stqa.pft.web.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteNtripServer extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoNtripsServerPage();
    }

    @Test
    public void testDeleteNtripServer() {
        String serverName = "server_2";
        app.getNtripHelper().deleteNtripServer(serverName);
        Assert.assertEquals(app.getNtripHelper().isNtripServerExists(serverName), false);

    }
}
