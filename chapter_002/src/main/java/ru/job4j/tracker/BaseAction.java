package ru.job4j.tracker;

public abstract class BaseAction implements UserAction{
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "add new item.");
    }
    @Override
    public int key() {
        return 0;
    }
}
