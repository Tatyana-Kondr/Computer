package shopComp;

import shopComp.model.Computer;
import shopComp.model.DesktopPC;
import shopComp.model.Laptop;
import shopComp.model.Smartphone;

public class ComputerAppl {
    public static void main(String[] args) {

        Computer[] shop = new Computer[5];
        shop[0] = new DesktopPC(100100, "HP",350.0,"i5", 12, 512, "HP_21'");
        shop[1] = new Laptop(100101,"Asus",870.0,"i7", 16, 512,  3, 2.1);
        shop[2] = new Laptop(100102,"Asus",680.0,"i7", 24, 1024,  3, 2.1);
        shop[3] = new Smartphone(100103,"Samsung",530.0,"Snapdragon", 8, 128,  24, 0.15, 123456789098l);

    }
}
