package ru.stqa.pft.web.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.web.data.PointData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    @Parameter(names = "-c", description = "Point count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main (String[] args) throws IOException {
        DataGenerator generator = new DataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        }catch (ParameterException ex){
            jCommander.usage();
            return;
        }

        generator.run();
    }

    private void run() throws IOException {
        List<PointData> points = generatePoints(count);
        if(format.equals("csv")) {
            saveAsCSV(points, new File(file+".csv"));
        } else if (format.equals("xml")) {
            saveAsXML(points, new File(file+".xml"));
        } else if (format.equals("json")) {
            saveAsJSON(points, new File(file+".json"));            
        } else {
            System.out.println("Unrecognized format" + format);
        }
    }

    private void saveAsJSON(List<PointData> points, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(points);
 //       try(Writer writer = new FileWriter(file)) {  //for autoclosing file after its using
        Writer writer = new FileWriter(file);
        writer.write(json);
 //       }
    }


    private List<PointData> generatePoints(int count) {

        List<PointData> points = new ArrayList<PointData>();
        for (int i = 0; i < count; i++) {
            points.add(new PointData().withName(String.format("test_%s", i))
                    .withCorrections("RTK RTCM3 MSM").withServer("server_1"));

        }
        return points;
    }

    private void saveAsXML(List<PointData> points, File file) throws IOException {

       XStream xstream = new XStream();
//        xstream.alias("point", PointData.class);
        String xml = xstream.toXML(points);
        try(Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private void saveAsCSV(List<PointData> points, File file) throws IOException {
        try(Writer writer = new FileWriter(file)) {
            for (PointData point : points) {
                writer.write(String.format("%s;%s;%s\n", point.getName(), point.getCorrections(), point.getServer()));
            }
        }
    }

}
