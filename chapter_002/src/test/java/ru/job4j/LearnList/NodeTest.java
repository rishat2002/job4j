package ru.job4j.LearnList;

import org.junit.Before;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NodeTest {
    Node first;
    Node second;

    Node third;

    Node fourth;

    @Before
    public void prepare() {
        first = new Node(1);
        second = new Node(2);
        third = new Node(3);
        fourth = new Node(4);
    }

    @Test
    public void whenLastLoopOnFirstThenTrue() {
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenLoopInTheMiddleThenTrue() {
        first.next = second;
        second.next = third;
        third.next = second;
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenNoLoopThenFalse() {
        first.next = second;
        second.next = third;
        third.next = fourth;
        assertThat(first.hasCycle(first), is(false));
    }
}