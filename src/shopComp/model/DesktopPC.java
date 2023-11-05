package shopComp.model;

public class DesktopPC extends Computer{
    // поля класса
    private String monitor;

    // конструктор
    public DesktopPC(int barcode, String brand, double price, String cpu, int ram, int ssd, String monitor) {
        super(barcode, brand, price, cpu, ram, ssd);
        this.monitor = monitor;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    @Override
    public String toString() {
        return super.toString() + ", monitor: " + monitor;
    }
}
