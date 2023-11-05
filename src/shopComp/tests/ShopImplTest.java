package shopComp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shopComp.dao.Shop;
import shopComp.dao.ShopImpl;
import shopComp.model.Computer;
import shopComp.model.DesktopPC;
import shopComp.model.Laptop;
import shopComp.model.Smartphone;

import java.util.concurrent.Callable;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class ShopImplTest {
    Shop shop;
    Computer[] comp;

    @BeforeEach
    void setUp() {
        shop = new ShopImpl(5);
        comp = new Computer[4];
        comp[0] = new DesktopPC(100, "HP",750.0,"i5", 12, 512, "HP_21'");
        comp[1] = new Laptop(101,"Asus",870.0,"i7", 16, 512,  3, 2.1);
        comp[2] = new Laptop(102,"Asus",680.0,"i7", 24, 1024,  3, 2.1);
        comp[3] = new Smartphone(103,"Samsung",530.0,"Snapdragon", 8, 128,  24, 0.15, 123456789098l);
        // добавим элементы массива
        for (int i = 0; i < comp.length; i++) {
            shop.addComputer(comp[i]);
        }
    }

    @Test
    void findComputer() {
        assertEquals(comp[1], shop.findComputer(101));
        assertNull(shop.findComputer(105));
    }

    @Test
    void addComputer() {   // добавляем
        assertFalse(shop.addComputer(null)); // не можем добавить null
        assertFalse(shop.addComputer(comp[1])); // не можем добавить уже существующий
        Computer comp1 = new DesktopPC(104, "Lenovo", 690.0, "i5", 16, 512, "Lenovo_ 19'"); // создали новый
        assertTrue(shop.addComputer(comp1)); // добавили нового сотрудника
        assertEquals(5, shop.quantity());
        Computer comp2 = new DesktopPC(105, "Asus", 690.0, "i5", 16, 512, "Asus_ 19'"); // создали новый
        assertFalse(shop.addComputer(comp2)); // не можем прeвысить capacity
        shop.printComputers();
        System.out.println("-------------------------------");
    }

    @Test
    void removeComputer() {   // удаляем
        shop.printComputers();
        System.out.println("...................");
        assertEquals(comp[1], shop.removeComputer(101));
        assertEquals(3, shop.quantity());  // сотрудников стало на 1 меньше
        assertNull(shop.removeComputer(101)); // дважды не можем удалить
        assertNull(shop.findComputer(101));  // не можем найти после удаления
        shop.printComputers();
        System.out.println("-------------------------------");
    }

    @Test
    void quantity() {
        assertEquals(4, shop.quantity());
    }

    @Test
    void totalSSD() {
        assertEquals(2176, shop.totalSSD());
    }

    @Test
    void avrPrice() {
        assertEquals(707.5, shop.avrPrice());
    }

    @Test
    void printComputers() {
        shop.printComputers();
    }

    @Test
    void BlackFridaySaleTest (){
       Computer[] actual = shop.blackFridaySale(600);
       Computer[] expected = {comp[0], comp[1], comp[2]};
       assertArrayEquals(expected, actual);
    }

}