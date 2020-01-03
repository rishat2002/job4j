package ru.job4j;

import org.junit.Test;
import ru.job4j.LearhMap.UserWithEqualsHash;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapwithEqualsHash {
    @Test
    public void userwithEqualsHash() {
        UserWithEqualsHash user1= new UserWithEqualsHash("petya", 2, new GregorianCalendar(1992,2,3));
        UserWithEqualsHash user2= new UserWithEqualsHash("petya", 2, new GregorianCalendar(1992,2,3));
        Map<UserWithEqualsHash,Object> map=new HashMap<>();
        map.put(user1,new Object());
        map.put(user2,new Object());
        System.out.println(map);
    }
}
