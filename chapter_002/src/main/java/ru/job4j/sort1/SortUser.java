package ru.job4j.sort1;
import java.util.*;
public class SortUser {
    public Set<User> sortage (List<User> list) {
     Set<User>userset=new TreeSet<>();
     for (User n:list) {
         userset.add(n);
     }
     return userset;
    }
    public List<User> sortNameLength (List<User>list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int n=0;
               if (o1.getName().length()>o2.getName().length()) {
                   n=1;
               }
               else if(o1.getName().length()<o2.getName().length()) {
                   n=-1;
               }
                return n;
            }
        });
        for (User m:list) {
            System.out.println(m.getName()+" "+m.getAge());
        }
        return list;
    }
    public List<User> sortByAllFields (List<User>list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }.thenComparing(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getAge(),o2.getAge()) ;
            }
        }));
        for (User m:list) {
            System.out.println(m.getName()+" "+m.getAge());
        }
        return list;
    }

    public static void main(String[] args) {
        SortUser sort1=new SortUser();
        User user1=new User(22,"pasha");
        User user2=new User(16,"pasha");
        User user3=new User(13,"slava");
        User user4=new User(14,"slava");
        List<User>lit=new ArrayList<>();
        lit.add(user1);
        lit.add(user3);
        lit.add(user4);
        lit.add(user2);
        sort1.sortByAllFields(lit);
    }
}
