package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int position = 0;
        for (Task l : tasks) {
            if (l.getPriority() > task.getPriority()) {
                break;
            }
            position++;
        }
        tasks.add(position, task);

    }

    public void sout1() {
        for (Task t : tasks) {
            System.out.println(t.getPriority());

        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}

