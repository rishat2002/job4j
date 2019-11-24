package ru.job4j.ru.job4j.tracker;

import ru.job4j.tracker.Tracker;

public class FindNameAction implements UserAction{

    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name=input.askStr("");
        if (tracker.findByName(name).length!=0) {
            for (int i=0;i<tracker.findByName(name).length;i++)
                System.out.println(tracker.findByName(name)[i].getId());
        }
        else {
            System.out.println("Item not found");
        }
        return true;
    }
}
