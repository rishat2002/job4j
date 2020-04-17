package ru.job4j.Vacancy;

import org.quartz.SchedulerException;

import java.io.IOException;

public interface Grabb {
    void init(Parse parse, Store store, String link) throws IOException, SchedulerException;
}
