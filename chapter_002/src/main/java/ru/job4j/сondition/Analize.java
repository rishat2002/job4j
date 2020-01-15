package ru.job4j.сondition;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        List<User> list = new ArrayList<>(previous);
        info.added = current.size();
        Map<String, User> currentMap = current.stream().collect(Collectors.toMap(user -> user.name, t -> t));
        for (User user : previous) {
            if (currentMap.get(user.name) != null) {
                if (current.equals(currentMap.get(user.id))) {
                    info.added--;
                    break;
                } else {
                    info.changed++;
                }
            } else {
                info.deleted++;
            }

        }
        System.out.println("add " + info.added + "change " + info.changed + "delete " + info.deleted);
        return info;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class Info {
        private int added;
        private int changed;
        private int deleted;

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }
}
//Сколько добавлено новых пользователей.
//Сколько изменено пользователей. Изменённым считается объект в котором изменилось имя. а id осталось прежним.
//Сколько удалено пользователей.