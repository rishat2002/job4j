package ru.job4j.ru.job4j.tracker;

import ru.job4j.tracker.Tracker;

public class DeleteAction implements UserAction{

    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id=input.askStr("Enter id");
        if (tracker.delete(id)) {
            System.out.println("Item with id"+id+"deleted");
        }
        else {
            System.out.println("Item cant deleted");
        }
        return true;
    }
}
