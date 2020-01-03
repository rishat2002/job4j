package ru.job4j;

import org.junit.Test;
import ru.job4j.LearhMap.UserWithEquals;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapwithEqualsTest {
    @Test
    public void userwithEquals() {
        UserWithEquals user5=new UserWithEquals("petya", 2, new GregorianCalendar(1992,2,3));
        UserWithEquals user6=new UserWithEquals("petya", 2, new GregorianCalendar(1992,2,3));
        Map<UserWithEquals,Object> map2=new HashMap<>();
        map2.put(user5,new Object());
        map2.put(user6,new Object());
        System.out.println(map2);
    }
}
