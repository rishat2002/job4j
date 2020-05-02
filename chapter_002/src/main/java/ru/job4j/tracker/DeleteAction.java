package ru.job4j.tracker;

import java.sql.SQLException;
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
    public boolean execute(Input input, ITracker tracker, Consumer<String> output) {
        String id=input.askStr("Enter id");
        try {
            if (tracker.delete(id)) {
                output.accept("Item with id"+id+"deleted");
            }
            else {
                output.accept("Item cant deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
