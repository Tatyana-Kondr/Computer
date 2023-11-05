package shopComp.model;

public class Smartphone extends Laptop {
    // поля класса
    private long imei;

    // конструктор
    public Smartphone(int barcode, String brand, double price, String cpu, int ram, int ssd, double hours, double weight, long imei) {
        super(barcode, brand, price, cpu, ram, ssd, hours, weight);
        this.imei = imei;
    }

    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }

    @Override
    public String toString() {
        return  super.toString() + ", imei: " + imei;
    }
}
