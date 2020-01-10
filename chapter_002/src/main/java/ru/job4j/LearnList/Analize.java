package ru.job4j.LearnList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        List<User> list = new ArrayList<>(previous);
        for (int i = 0; i < current.size(); i++) {
            int equalsobject = 0;
            for (int s = 0; s < list.size(); s++) {
                if (current.get(i).equals(list.get(s))) {
                    equalsobject = 1;
                    list.remove(s);
                    break;
                } else if ((list.get(s).name).equals(current.get(i).name)) {
                    equalsobject = 1;
                    info.changed++;
                    list.remove(s);
                }
            }
            if (equalsobject == 0) {
                info.added++;
            }
        }
        info.deleted = list.size();
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