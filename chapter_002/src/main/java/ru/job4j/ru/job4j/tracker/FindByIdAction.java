package ru.job4j.ru.job4j.tracker;

import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class FindByIdAction implements UserAction{

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
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String>output) {
        String id=input.askStr("Enter id");
        if (tracker.findById(id)!=null) {
            output.accept("Found "+tracker.findById(id).getName());
        }
        else {
            output.accept("Item not found");
        }
        return true;
    }
}
