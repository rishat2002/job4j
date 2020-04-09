package ru.job4j.ru.job4j.tracker1;

import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class StubAction implements UserAction {
    private boolean call = false;

    @Override
    public String info() {
        return null;
    }

    @Override
    public int key() {
        return 0;
    }

    @Override
    public String name() {
        return "Stub action";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}
