package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
public class PrimeNumberTest {
    @Test
    public void when5() {
        PrimeNumber prime = new PrimeNumber();
        int rsl = prime.calc(5);
        assertThat(rsl, is(3));
    }

    @Test
    public void when11() {
        PrimeNumber prime1 = new PrimeNumber();
        int rsl = prime1.calc(11);
        assertThat(rsl, is(5));
    }
}
