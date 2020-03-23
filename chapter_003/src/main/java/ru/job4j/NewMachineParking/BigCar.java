package ru.job4j.NewMachineParking;

public class BigCar implements CanGetPlace {
    @Override
    public boolean getPlace(Parking park) {
        return park.bussyForBigCar(this);
    }
}
