package ru.job4j.ru.job4j.tracker1;

public interface Input {
    String askStr(String question);
    int askInt(String question);
    int askInt(String question, int max);
}
