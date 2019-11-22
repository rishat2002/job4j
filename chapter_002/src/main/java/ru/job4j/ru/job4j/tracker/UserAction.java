package ru.job4j.ru.job4j.tracker;

import ru.job4j.tracker.Tracker;

public interface UserAction {
    String name();
    boolean execute(Input input, Tracker tracker);
}
