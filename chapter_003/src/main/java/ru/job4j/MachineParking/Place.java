package ru.job4j.MachineParking;

public abstract class Place {
    private boolean place;

    public Place(boolean place) {
        this.place = place;
    }

    public boolean isPlace() {
        return place;
    }

    public void setPlace(boolean place) {
        this.place = place;
    }
}
