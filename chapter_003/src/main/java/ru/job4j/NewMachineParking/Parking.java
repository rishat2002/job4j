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
            bparking.add(new BigPlace());
        }
        for(int m=0;m<amoutSmallPlace;m++) {
            sparking.add(new SmallPlace());
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
            if (i>=amountPlaceForBigCar) {
                for (int s=0;s<amountPlaceForBigCar;s++) {
                    sparking.get(s).setPlace(false);
                }
                return n=true;
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

    }
}
