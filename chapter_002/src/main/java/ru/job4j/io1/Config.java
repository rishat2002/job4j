package ru.job4j.io1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() throws IOException {
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            if (line.indexOf("=") != -1) {
                String key = line.substring(0, line.indexOf("="));
                String value = line.substring(line.indexOf("=") + 1, line.length());
                values.put(key, value);
            }
        }
        br.close();
        fr.close();
    }


    public String value(String key) {
        String x = null;
        for (Map.Entry<String, String> entry : this.values.entrySet()) {
            if (key.equals(entry.getKey())) {
                x = entry.getValue();
                break;
            }
        }
        return x;
    }

    public Map<String, String> getCloneValues() {
        return (new HashMap<>(values));
    }

    public static void main(String[] args) throws IOException {
        Config conf = new Config("C:\\projects\\job4j\\chapter_002\\src\\main\\java\\ru\\job4j\\io1\\app.properties");
        conf.load();
    }
}
//Задание.
//
//1. Реализуйте метод load по аналогии с методом toString. Метод load должен загружать пару ключ-значение в Map values.
//2. Реализуйте метод value(String key) он должен возвращать значение ключа.
//3. Напишите тест ConfigTest.