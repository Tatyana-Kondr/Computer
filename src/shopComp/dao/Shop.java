package shopComp.dao;

import shopComp.model.Computer;

public interface Shop {
    Computer findComputer(int barcode);
    boolean addComputer(Computer computer);
    Computer removeComputer(int barcode);
    int quantity();
    int totalSSD();
    double avrPrice();
    void printComputers();
    Computer[] blackFridaySale(double pr);

}
