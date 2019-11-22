package ru.job4j.ru.job4j.tracker;

import ru.job4j.tracker.Tracker;

public class ExitProgrammAction implements UserAction{
    @Override
    public String name() {
        return "Exit programm";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("You finished the programm");
        return false;
    }
}
