package ru.job4j.LearnList;

public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {

        this.value = value;
    }

    boolean hasCycle(Node<T> first) {
        if (first == null)
            return false;
        Node slow, fast;
        slow = fast = first;
        while (true) {
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else
                return false;
            if (slow == null || fast == null)
                return false;
            if (slow == fast)
                return true;
        }
    }
}
