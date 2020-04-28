package ru.job4j.LearnList;
import org.junit.Test;
import org.junit.Before;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;

public class SimpleQueuTest {
    SimpleQueu<String> newstack=new SimpleQueu<>();
    @Test
    public void pollTest() {
        newstack.push("1");
        newstack.push("2");
        newstack.push("3");
        System.out.println(newstack.poll());
        System.out.println(newstack.poll());
        System.out.println(newstack.poll());
    }
}