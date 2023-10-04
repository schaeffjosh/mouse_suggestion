package org.example;

public class Mouse {
    private String brand;
    private String model;
    private double length;
    private double width;
    private double height;
    private int weight;
    private String shape;
    private String connectivity;
    private String sensor;
    private int dpi;
    private int pollingRate;

    public String getBrand() {return brand;}
    public void setBrand(String brand) {this.brand = brand;}

    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}

    public double getLength() {return length;}
    public void setLength(double length) {this.length = length;}

    public double getWidth() {return width;}
    public void setWidth(double width) {this.width = width;}

    public double getHeight() {return height;}
    public void setHeight(double height) {this.height = height;}

    public double getWeight() {return weight;}
    public void setWeight(int weight) {this.weight = weight;}

    public String isSymmetrical() {return shape;}
    public void setShape(String shape) {this.shape = shape;}

    public String isWireless() {return connectivity;}
    public void setConnectivity(String connectivity) {this.connectivity = connectivity;}

    public String getSensor() {return sensor;}
    public void setSensor(String sensor) {this.sensor = sensor;}

    public int getDpi() {return dpi;}
    public void setDpi(int dpi) {this.dpi = dpi;}

    public int getPollingRate() {return pollingRate;}
    public void setPollingRate(int pollingRate) {this.pollingRate = pollingRate;}

    public Mouse(){};

    public Mouse(String brand, String model, double length, double width, double height, int weight, String symmetrical, String wireless, String sensor, int dpi, int pollingRate){
        this.brand = brand;
        this.model = model;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.sensor = sensor;
        this.dpi = dpi;
        this.pollingRate = pollingRate;
        this.shape = symmetrical;
        this.connectivity = wireless;
    }

    public String toString(){
        return String.format("Brand: %s\nModel: %s\nDimensions: L: %.2f W: %.2f H: %.2f\nWeight: %d\nSensor: %s\nMax DPI: %d\nMax Polling Rate: %d\nShape: %s\nConnectivity: %s",
                this.brand, this.model, this.length, this.width, this.height, this.weight, this.sensor, this.dpi, this.pollingRate, this.shape, this.connectivity);
    }
}
