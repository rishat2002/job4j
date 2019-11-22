package ru.job4j.ru.job4j.tracker;

import ru.job4j.tracker.Tracker;

public class StubAction implements UserAction {
    private boolean call = false;
    @Override
    public String name() {
        return "Stub action";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}
