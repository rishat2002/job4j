package ru.job4j.ru.job4j.tracker;

import ru.job4j.tracker.Tracker;

public class FindByIdAction implements UserAction{

    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id=input.askStr("Enter id");
        if (tracker.findById(id)!=null) {
            System.out.println("Found "+tracker.findById(id).getName());
        }
        else {
            System.out.println("Item not found");
        }
        return true;
    }
}
