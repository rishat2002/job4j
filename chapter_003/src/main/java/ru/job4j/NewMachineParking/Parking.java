package ru.job4j.NewMachineParking;

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
    public boolean bussyForBigCar(CanGetPlace c) {
        boolean n = false;
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
            return n;
    }
    public boolean bussyForSmallPlace(CanGetPlace c) {
        boolean n = false;
            for (SmallPlace b : sparking) {
                if (b.isPlace()) {
                    b.setPlace(false);
                    return n = true;
                }
            }
        return n;
    }

    public static void main(String[] args) {
    Parking p=new Parking(2,3);
    LittleCar l1=new LittleCar();
    BigCar b1=new BigCar();
    System.out.println(l1.getPlace(p));
    System.out.println(b1.getPlace(p)+" machine");
    for (BigPlace s:p.bparking) {
        System.out.println(s.isPlace());
    }
    for (SmallPlace s:p.getSparking()) {
            System.out.println(s.isPlace());
        }
    }
}
