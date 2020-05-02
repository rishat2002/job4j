package ru.job4j.NewMachineParking;

public class SmallPlace implements GivePlace {
    private boolean place;
    public boolean isPlace() {
        return place;
    }

    @Override
    public void setPlace(boolean place) {
        this.place = place;
    }
}
