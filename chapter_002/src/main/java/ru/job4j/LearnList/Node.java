package ru.job4j.LearnList;

public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {

        this.value = value;
    }

    boolean hasCycle(Node<T> node) {
        boolean valid = false;
        String loop = "";
        Node<T> temp = node;
        while (temp.next != null) {
            loop += temp.toString();
            temp = temp.next;
            if (loop.contains(temp.toString())) {
                valid = true;
                break;
            }
        }
        return valid;
    }
}
