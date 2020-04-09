package ru.job4j.ru.job4j.tracker1;

import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public interface UserAction {
    String info();
    int key();
    String name();
    boolean execute(Input input, Tracker tracker, Consumer<String> output);
}
