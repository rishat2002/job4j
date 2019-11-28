package ru.job4j.ru.job4j.tracker;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class ShowAction extends BaseAction implements UserAction {

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] show=tracker.findAll();
        for (int i=0;i<show.length;i++) {
            System.out.println(show[i].getName());
        }
        return true;
    }
}
