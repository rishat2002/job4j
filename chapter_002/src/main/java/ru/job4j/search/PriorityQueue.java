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
        if (tasks.isEmpty()) {
            tasks.add(task);
            return;
        }
        int n = tasks.size();
        for (int i = 0; i < n; i++) {
            if (tasks.get(i).getPriority() > task.getPriority()) {
                tasks.add(i, task);
                break;
            }
        }
        if (tasks.size() == n) {
            tasks.add(task);
        }

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

