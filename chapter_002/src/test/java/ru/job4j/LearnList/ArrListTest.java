package ru.job4j.LearnList;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class ArrListTest {
    ArrList<String>list=new ArrList<String>();
    @Before
    public void start() {
        for (int i=0;i<12;i++) {
            list.add(Integer.toString(i));
        }
    }
    @Test
    public void addTest() {
        assertThat("0",is(list.get(0)));
        assertThat("2",is(list.get(2)));
        assertThat("11",is(list.get(11)));
    }

    @Test
    public void iteratorTest() {
        Iterator iter=list.iterator();
        assertThat("0",is(iter.next()));
    }
    @Test(expected = NoSuchElementException.class)
    public void iteratorTest1() {
        Iterator iter=list.iterator();
        for (int i=0;i<16;i++) {
            iter.next();
        }
    }
    @Test(expected = ConcurrentModificationException.class)
    public void iteratorTest2() {
        Iterator iter=list.iterator();
        iter.next();
        list.add("12");
        iter.next();
    }
}