package ru.stqa.pft.web.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.web.data.PointData;

import java.util.List;

public class FullPointList extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoMountpointsPage();
    }

    @Test
    public void getFullPointList() {

        List<PointData> pointNames;

//        String baseURL = app.getNtripHelper().setHowManyPointToShow(100);
        pointNames = app.getMountpointHelper().getAllPointsName();  // only on the first page (5 points)
    }
}
