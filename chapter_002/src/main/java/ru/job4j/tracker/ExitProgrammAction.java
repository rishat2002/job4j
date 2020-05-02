package ru.job4j.tracker;

import java.util.function.Consumer;

public class ExitProgrammAction implements UserAction{
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
        return "Exit programm";
    }

    @Override
    public boolean execute(Input input, ITracker tracker, Consumer<String>output) {
        output.accept("You finished the programm");
        return false;
    }
}
