package ru.job4j.LearnSet;

import java.util.Optional;

public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    Optional<MenuItem<E>> findBy(E value);
}
