package ru.job4j.XMLOptimizataion;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties values = new Properties();

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("lite.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public Properties getValues() {
        this.init();
        return values;
    }

    public static void main(String[] args) {

    }
}
