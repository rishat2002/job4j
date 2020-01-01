package ru.job4j.LearnList;
import org.junit.Test;
import org.junit.Before;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class SimpleStackTest {
    SimpleStack<String> newstack=new SimpleStack();
    @Test
    public void pushTest() {
        newstack.push("1");
        newstack.push("2");
        newstack.push("3");
    }
    @Test
    public void pollTest() {
        newstack.push("1");
        newstack.push("2");
        newstack.push("3");
        assertThat(newstack.poll(),is("3"));
        assertThat(newstack.poll(),is("2"));
        assertThat(newstack.poll(),is("1"));

    }
}