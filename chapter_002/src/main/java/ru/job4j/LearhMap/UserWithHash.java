package ru.job4j.LearhMap;

import java.util.Calendar;
import java.util.Objects;

public class UserWithHash {
    private String name;
    private int children;
    private Calendar birthday;

    public UserWithHash(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
