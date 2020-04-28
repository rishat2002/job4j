package ru.job4j.LearnList;

import org.junit.Test;
import org.junit.Before;

import java.util.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void addTest() {
        SimpleSet<String> set1 = new SimpleSet<>();
        set1.add("2");
        set1.add("2");
        set1.add("1");
        set1.add("3");
        set1.add("6");
        set1.add("6");
        set1.add("6");
        Set<String> expected = new HashSet<>();
        expected.add("1");
        expected.add("2");
        expected.add("3");
        expected.add("6");
        Set<String> result = new HashSet<>();
        for (String s : set1.getArr()) {
            result.add(s);
        }
        assertThat(expected, is(result));
    }
}