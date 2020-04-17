package ru.job4j.Vacancy;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Predicate;

public interface Store {
    void save(Vacancy post) throws SQLException;
    List<Vacancy> get(Predicate<Vacancy> filter) throws SQLException;
}
