package ru.job4j.NewMachineParking;

public class LittleCar implements CanGetPlace {
    @Override
    public boolean getPlace(Parking park) {
        return park.bussyForSmallPlace(this);
    }
}
