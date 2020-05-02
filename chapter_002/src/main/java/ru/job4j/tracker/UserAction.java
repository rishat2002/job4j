package ru.job4j.tracker;

import java.util.function.Consumer;

public interface UserAction {
    String info();
    int key();
    String name();
    boolean execute(Input input, ITracker tracker, Consumer<String> output);
}
