package ru.job4j.Vacancy;

import java.io.IOException;
import java.util.List;

public interface Parse {
    List<Vacancy> list(String link) throws IOException;
    Vacancy detail(String link) throws IOException;
}
