package ru.job4j.oop;

public class Battery {
    private int load;
    public Battery(int charge) {
        this.load=charge;
    }
    public void exchange(Battery another) {
        another.load=another.load+this.load;
        this.load=0;
    };

    public static void main(String[] args) {
        Battery firstBattery=new Battery(4);
        Battery secondBattery=new Battery(6);
        secondBattery.exchange(firstBattery);
        System.out.println(firstBattery.load);
    }
}
