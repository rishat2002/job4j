package ru.job4j.ru.job4j.tracker;

import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class FindNameAction implements UserAction{

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
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String>output) {
        String name=input.askStr("");
        if (tracker.findByName(name).isEmpty()) {
            for (int i=0;i<tracker.findByName(name).size();i++)
                output.accept(tracker.findByName(name).get(i).getId());
        }
        else {
            output.accept("Item not found");
        }
        return true;
    }
}
