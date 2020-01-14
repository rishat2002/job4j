package ru.job4j.LearnList;

import org.junit.Before;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NodeTest {
    Node<Integer> first;
    Node<Integer> second;
    Node<Integer> third;
    Node<Integer> fourth;

    @Before
    public void prepare() {

    }

    @Test
    public void whenLastLoopOnFirstThenTrue() {
        this.first = new Node<>(1);
        this.second = new Node<>(2);
        this.third = new Node<>(3);
        this.fourth = new Node<>(4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenLoopInTheMiddleThenTrue() {
        this.first = new Node<>(1);
        this.second = new Node<>(2);
        this.third = new Node<>(3);
        this.fourth = new Node<>(4);
        first.next = second;
        second.next = third;
        third.next = second;
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenNoLoopThenFalse() {
        this.first = new Node<>(1);
        this.second = new Node<>(2);
        this.third = new Node<>(3);
        this.fourth = new Node<>(4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        assertThat(first.hasCycle(first), is(false));
    }
}