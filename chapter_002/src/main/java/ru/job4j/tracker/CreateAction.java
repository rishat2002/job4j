package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.function.Consumer;

public class CreateAction extends BaseAction implements UserAction  {
    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, ITracker tracker, Consumer<String>output) {
        output.accept("Enter name: ");
        String name = input.askStr("");
        Item item = new Item(name);
        try {
            tracker.add(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
