package ru.job4j;

import org.junit.Test;
import ru.job4j.LearhMap.UserWithHash;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapwithHashTest {
    @Test
    public void userwithHash() {
        UserWithHash user3=new UserWithHash("petya", 2, new GregorianCalendar(1992,2,3));
        UserWithHash user4=new UserWithHash("petya", 2, new GregorianCalendar(1992,2,3));
        Map<UserWithHash,Object> map1=new HashMap<>();
        map1.put(user3,new Object());
        map1.put(user4,new Object());
        System.out.println(user3.hashCode()==user4.hashCode());
        System.out.println(map1);
    }
}
