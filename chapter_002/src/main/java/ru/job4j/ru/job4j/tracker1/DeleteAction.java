package ru.job4j.ru.job4j.tracker1;

import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class DeleteAction implements UserAction{

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
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String id=input.askStr("Enter id");
        if (tracker.delete(id)) {
            output.accept("Item with id"+id+"deleted");
        }
        else {
            output.accept("Item cant deleted");
        }
        return true;
    }
}
