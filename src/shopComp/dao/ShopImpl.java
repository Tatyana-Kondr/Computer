package shopComp.dao;


import shopComp.model.Computer;

import java.util.function.Predicate;

public class ShopImpl implements Shop{
    // поля
    private Computer[] computers; // массив для хранения
    private int size;  // текущее кол-во

    //конструктор
    public ShopImpl(int capacity){
        computers = new Computer[capacity];  //capaсity - максимальный размер
    }

    @Override
    public Computer findComputer(int barcode) {  // поиск по баркоду
        for (int i = 0; i < size; i++) {
            if(computers[i].getBarcode() == barcode){
                return computers[i];
            }
        }
        return null;
    }

    @Override
    public boolean addComputer(Computer computer) {
        // не добавляем null, не превышаем capacity, не добавляем уже существующего
        if (computer == null || size == computers.length || findComputer(computer.getBarcode()) != null){
            return false;
        }
        computers[size++] = computer;
        return true;
    }

    @Override
    public Computer removeComputer(int barcode) {
        for (int i = 0; i < size; i++) {
            if(computers[i].getBarcode() == barcode){
                Computer victim = computers[i];  // убрали найденный в переменную
                computers[i] = computers[size - 1];  // на место найденного поставили последний сущ. элемент в массиве
                computers[size - 1] = null;  // обнулили последний
                size--;
                return victim;
            }
        }
        return null;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public int totalSSD() {
        int res = 0;
        for (int i = 0; i < size; i++) {
            res += computers[i].getSsd();
        }
        return res;
    }

    @Override
    public double avrPrice() {
        double res =0;
        for (int i = 0; i < size; i++) {
            res += computers[i].getPrice();
        }
        return res / size;
    }

    @Override
    public void printComputers() {
        for (int i = 0; i < size; i++) {
            System.out.println(computers[i]);
        }
    }

    @Override
    public Computer[] blackFridaySale(double pr) {
        int count = 0;
        // считаем сколько элементов, удовлетворяющих заданному условию
        for (int i = 0; i < size; i++) {
            if(computers[i].getPrice() > pr){
                count++;
            }
        }
        Computer[] res = new Computer[count];   // создаем массив с длиной count
        // заполняем массив res
        for (int i = 0, j = 0; j < res.length; i++) {
            if(computers[i].getPrice() > pr){
                res[j++] = computers[i];
            }
        }
        return  res; // это возвращаемый массив
    }
}
