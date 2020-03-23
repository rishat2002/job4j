package ru.job4j.NewMachineParking;

public class BigPlace implements GivePlace {
    private boolean place;
    @Override
    public boolean isPlace() {
        return place;
    }
    @Override
    public void setPlace(boolean place) {
        this.place = place;
    }
}
