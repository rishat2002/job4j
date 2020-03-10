package ru.job4j.MachineParking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    public List<BigPlace> getBparking() {
        return bparking;
    }
    public List<SmallPlace> getSparking() {
        return sparking;
    }
    private List<BigPlace>bparking=new ArrayList<>();
    private List<SmallPlace> sparking=new ArrayList<>();
    private int amoutBigPlace;
    private int amoutSmallPlace;
    private final int amountPlaceForBigCar=3;
    public Parking(int amoutBigPlace, int amoutSmallPlace) {
        this.amoutBigPlace = amoutBigPlace;
        this.amoutSmallPlace = amoutSmallPlace;
        this.createPark(amoutBigPlace,amoutSmallPlace);
    }
    public void createPark(int amoutBigPlace,int amoutSmallPlace) {
        for(int n=0;n<amoutBigPlace;n++) {
            bparking.add(new BigPlace(true));
        }
        for(int m=0;m<amoutSmallPlace;m++) {
            sparking.add(new SmallPlace(true));
        }
    }
    private boolean bussy (Car car) {
        boolean n = false;
        if (car instanceof BigCar) {
            for (BigPlace b : bparking) {
                if (b.isPlace()) {
                    b.setPlace(false);
                    return n = true;
                }
            }
            int i=0;
            for (SmallPlace b : sparking) {
                if (b.isPlace()) {
                    i++;
                }
            }
            int l=0;
            if (i>=amountPlaceForBigCar){
                for (SmallPlace b : sparking) {
                    if (b.isPlace()) {
                        b.setPlace(false);
                        l++;
                        if (l==amountPlaceForBigCar){
                            return n=true;
                        }
                    }
                }
            }
        }
        if (car instanceof LittleCar) {
            for (SmallPlace b : sparking) {
                if (b.isPlace()) {
                    b.setPlace(false);
                    return n = true;
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Parking p=new Parking(1,5);
        LittleCar car1=new LittleCar();
        LittleCar car2=new LittleCar();
        BigCar bcar1=new BigCar();
        BigCar bcar2=new BigCar();
        System.out.println(p.bussy(car1));
        System.out.println(p.bussy(bcar1));
        System.out.println(p.bussy(car2));
        System.out.println(p.bussy(bcar2)+"listsStarts");
        for (BigPlace b:p.getBparking()) {
            System.out.println(b.isPlace());
        }
        for (SmallPlace b:p.getSparking()) {
            System.out.println(b.isPlace());
        }

    }
}
