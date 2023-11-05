package shopComp.model;

public class Laptop extends Computer{
    // поля класса
    private double hours;
    private double weight;

    // конструктор


    public Laptop(int barcode, String brand, double price, String cpu, int ram, int ssd, double hours, double weight) {
        super(barcode, brand, price, cpu, ram, ssd);
        this.hours = hours;
        this.weight = weight;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", hours: " + hours +
                ", weight: " + weight;
    }
}
