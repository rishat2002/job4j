package ru.job4j.LearnList;
import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class SimpleArrayListTest
{

    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }
    @Test
    public void whenDeleteThreeElementsThenUseGetSizeResultThree() {
        list.delete();
        assertThat(list.get(0), is(2));
        assertThat(2, is(list.getSize()));
    }
    @Test
    public void iteratorTest() {
        Iterator newiter=list.iterator();
        assertThat(list.get(0),is(newiter.next()));
        assertThat(list.get(1),is(newiter.next()));
    }
    @Test(expected = NoSuchElementException.class)
    public void iterator1Test() {
        Iterator newiter=list.iterator();
        newiter.next();
        newiter.next();
        newiter.next();
        newiter.next();
    }
    @Test(expected = ConcurrentModificationException.class)
    public void iterator2Test() {
        Iterator newiter=list.iterator();
        newiter.next();
        list.add(4);
        newiter.next();
    }
}