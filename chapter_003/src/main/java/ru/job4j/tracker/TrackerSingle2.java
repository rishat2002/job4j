package ru.job4j.tracker;

public class TrackerSingle2 {
    private TrackerSingle2() {
    }

    public static TrackerSingle2 getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingle2 INSTANCE = new TrackerSingle2();
    }

    public static void main(String[] args) {

    }
}
