package ru.stqa.pft.web.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.web.data.PointData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class PointDatabaseCreation extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoMountpointsPage();
    }

    @DataProvider
    public Iterator<Object[]> validPointsFromXML() throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/points.xml"))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }

            Class<?>[] classes = new Class[]{PointData.class};
            XStream xstream = new XStream();
            XStream.setupDefaultSecurity(xstream);
            xstream.allowTypes(classes);
            xstream.processAnnotations(PointData.class);
            List<PointData> points = (List<PointData>) xstream.fromXML(xml);
            return points.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validPointsFromJSON() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/points.json"))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }

            Gson gson = new Gson();
            List<PointData> points = gson.fromJson(json, new TypeToken<List<PointData>>() {
            }.getType()); // List <PointData>.class
            return points.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }


    @Test(dataProvider = "validPointsFromJSON")
    public void testPointDatabaseCreation(PointData points) {

//        app.getNtripHelper().addNtripServer("server_1");
        app.getMountpointHelper().addPointWithBaseNtripSource(points.getName(),
                points.getCorrections(), points.getServer());

//        int before = app.getMountpointHelper().getMountpointsTotalNumber();
//        app.getNtripHelper().addBaseNtripSource(points.getName());
//        app.getNavigationHelper().gotoNtripPage();
    }
}