package ru.job4j.sort1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort (List<User> list) {
     Set<User>userset=new TreeSet<>();
     for (User n:list) {
         userset.add(n);
     }
     for (User m:userset) {
         System.out.println(m.getName()+" "+m.getAge());
     }
     return userset;
    }

    public static void main(String[] args) {
        SortUser sort1=new SortUser();
        User user1=new User(12,"pasha");
        User user2=new User(16,"semen");
        User user3=new User(14,"slava");
        List<User>lit=new ArrayList<>();
        lit.add(user1);
        lit.add(user2);
        lit.add(user3);
        sort1.sort(lit);
    }
}
