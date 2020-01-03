package ru.job4j.LearhMap;

import java.util.Calendar;
import java.util.Objects;

public class UserWithEqualsHash {
    private String name;
    private int children;
    private Calendar birthday;

    public UserWithEqualsHash(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWithEqualsHash that = (UserWithEqualsHash) o;
        return children == that.children &&
                Objects.equals(name, that.name) &&
                Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
