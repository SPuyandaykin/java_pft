package ru.stqa.pft.web.data;

public class PointData {
    private String name;
    private String corrections;
    private String server;

    public PointData(){

    }

    public PointData(String name, String corrections, String server){
        this.name = name;
        this.corrections = corrections;
        this.server = server;
    }

    public PointData withName(String name) {
        this.name = name;
        return this;
    }

    public PointData withCorrections(String corrections) {
        this.corrections = corrections;
        return this;
    }

    public PointData withServer(String server) {
        this.server = server;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCorrections(String corrections) {
        this.corrections = corrections;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getCorrections() {
        return corrections;
    }

    public String getServer() {
        return server;
    }

    public String getName() {
        return name;
    }
}
