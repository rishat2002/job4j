package ru.job4j;

import org.junit.Test;
import ru.job4j.LearhMap.User;
import ru.job4j.LearhMap.UserWithEquals;
import ru.job4j.LearhMap.UserWithEqualsHash;
import ru.job4j.LearhMap.UserWithHash;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    @Test
    public void userTest() {
        User user1=new User("petya", 2, new GregorianCalendar(1992,2,3));
        User user2=new User("petya", 2, new GregorianCalendar(1992,2,3));
        Map<User,Object>map=new HashMap<>();
        map.put(user1,new Object());
        map.put(user2,new Object());
        System.out.println(map);
    }
}
