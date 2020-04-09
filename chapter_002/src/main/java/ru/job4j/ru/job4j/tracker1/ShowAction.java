package ru.job4j.ru.job4j.tracker1;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.List;
import java.util.function.Consumer;

public class ShowAction extends BaseAction implements UserAction {

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        List<Item> show=tracker.findall();
        for (int i=0;i<show.size();i++) {
            output.accept(show.get(i).getName());
        }
        return true;
    }
}
