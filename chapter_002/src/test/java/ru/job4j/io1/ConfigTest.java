package ru.job4j.io1;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.*;

public class ConfigTest {
    Config conf = new Config("C:\\projects\\job4j\\chapter_002\\src\\main\\java\\ru\\job4j\\io1\\app.properties");

    @Test
    public void load() throws IOException {
        conf.load();
        Map<String, String> expected = new HashMap<>();
        expected.putIfAbsent("hibernate.connection.driver_class", "org.postgresql.Driver");
        expected.putIfAbsent("hibernate.connection.url", "jdbc:postgresql://127.0.0.1:5432/trackstudio");
        expected.putIfAbsent("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        expected.putIfAbsent("hibernate.connection.password", "password");
        expected.putIfAbsent("hibernate.connection.username", "postgres");

    }

    @Test
    public void value() throws IOException {
        conf.load();
        String result = conf.value("hibernate.connection.password");
        assertThat(result, is("password"));
    }
}