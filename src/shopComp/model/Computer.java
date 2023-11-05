package shopComp.model;

public abstract class Computer {
    // поля класса
    protected int barcode;
    protected String brand;
    protected double price;
    protected String cpu;
    protected int ram;
    protected int ssd;


    // конструктор
    public Computer(int barcode, String brand, double price, String cpu, int ram, int ssd) {
        this.barcode = barcode;
        this.brand = brand;
        this.price = price;
        this.cpu = cpu;
        this.ram = ram;
        this.ssd = ssd;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Computer computer = (Computer) o;

        return barcode == computer.barcode;
    }

    @Override
    public int hashCode() {
        return barcode;
    }

    @Override
    public String toString() {
        return "Computer - " +
                "barcode: " + barcode +
                ", cpu: " + cpu +
                ", ram: " + ram +
                ", ssd: " + ssd +
                ", brand: " + brand;
    }
}
