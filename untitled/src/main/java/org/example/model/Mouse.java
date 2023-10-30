package org.example.model;

public class Mouse {
    private int id;
    private String brand;
    private String model;
    private double length;
    private double width;
    private double height;
    private int weight;
    private boolean shape;
    private boolean connectivity;
    private String sensor;
    private int dpi;
    private int pollingRate;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

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

    public boolean isSymmetrical() {return shape;}
    public void setShape(boolean shape) {this.shape = shape;}

    public boolean isWireless() {return connectivity;}
    public void setConnectivity(boolean connectivity) {this.connectivity = connectivity;}

    public String getSensor() {return sensor;}
    public void setSensor(String sensor) {this.sensor = sensor;}

    public int getDpi() {return dpi;}
    public void setDpi(int dpi) {this.dpi = dpi;}

    public int getPollingRate() {return pollingRate;}
    public void setPollingRate(int pollingRate) {this.pollingRate = pollingRate;}


    public Mouse(){};

    public Mouse(String brand, String model, double length, double width, double height, int weight, String shape, String wireless, String sensor, int dpi, int pollingRate){
        this.brand = brand;
        this.model = model;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.sensor = sensor;
        this.dpi = dpi;
        this.pollingRate = pollingRate;
        this.shape = shape.equalsIgnoreCase("symmetrical");
        this.connectivity = wireless.equals("wireless");
    }

    public String toString(){
        return String.format("('%s','%s',%.2f,%.2f,%.2f,%d,%b,%b,'%s',%d,%d)",
                this.brand, this.model, this.length, this.width, this.height, this.weight, this.shape, this.connectivity, this.sensor, this.pollingRate, this.dpi);
    }
}
//"Brand: %s\nModel: %s\nDimensions: L: %.2f W: %.2f H: %.2f\nWeight: %d\nSensor: %s\nMax DPI: %d\nMax Polling Rate: %d\nShape: %s\nConnectivity: %s"
