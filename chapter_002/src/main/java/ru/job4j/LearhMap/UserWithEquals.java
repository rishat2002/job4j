package ru.job4j.LearhMap;

import java.util.Calendar;
import java.util.Objects;

public class UserWithEquals {
    private String name;
    private int children;
    private Calendar birthday;

    public UserWithEquals(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWithEquals that = (UserWithEquals) o;
        return children == that.children &&
                Objects.equals(name, that.name) &&
                Objects.equals(birthday, that.birthday);
    }
}
