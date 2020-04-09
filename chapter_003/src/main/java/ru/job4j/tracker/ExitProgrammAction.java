package ru.job4j.tracker;

import ru.job4j.ru.job4j.tracker1.Input;
import ru.job4j.ru.job4j.tracker1.UserAction;

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
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        return false;
    }


    public boolean execute(Input input, Tracker tracker) {
        System.out.println("You finished the programm");
        return false;
    }
}
